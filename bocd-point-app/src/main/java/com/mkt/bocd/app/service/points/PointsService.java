package com.mkt.bocd.app.service.points;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mkt.bocd.common.constant.points.PointsChangeType;
import com.mkt.bocd.common.constant.points.PointsRecordStatus;
import com.mkt.bocd.common.exception.CommonException;
import com.mkt.bocd.domain.dto.points.PointsChangeDTO;
import com.mkt.bocd.domain.entity.points.PointsAccount;
import com.mkt.bocd.domain.entity.points.PointsRecord;
import com.mkt.bocd.app.repository.points.PointsAccountRepository;
import com.mkt.bocd.app.repository.points.PointsRecordRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @author manpoyang
 * @version 1.0
 * @date 2024/12/29 14:28
 */
@Service
@Slf4j
public class PointsService {
    @Autowired
    private PointsAccountRepository accountRepository;

    @Autowired
    private PointsRecordRepository recordRepository;

    /**
     * 增加积分 - 使用乐观锁
     */
    @Transactional(rollbackFor = Exception.class)
    public void increasePoints(PointsChangeDTO dto) {
        String transactionId = generateTransactionId(dto.getUserId(), PointsChangeType.INCREASE);

        // 1. 幂等性检查
        if (isTransactionProcessed(transactionId)) {
            log.info("Transaction already processed: {}", transactionId);
            return;
        }

        // 2. 创建积分变动记录
        PointsRecord record = createPointsRecord(dto, PointsChangeType.INCREASE, transactionId);

        try {
            // 3. 查询账户
            PointsAccount account = accountRepository.getBaseMapper().selectOne(
                    Wrappers.<PointsAccount>lambdaQuery()
                            .eq(PointsAccount::getUserId, dto.getUserId())
            );
            if (account == null) {
                throw new CommonException("账户不存在");
            }

            // 4. 更新积分（使用乐观锁）
            long newPoints = account.getPoints() + dto.getPoints();
            boolean updated = accountRepository.updatePoints(
                    dto.getUserId(), newPoints, account.getVersion()
            );

            if (!updated) {
                throw new CommonException("更新失败，请重试");
            }

            // 5. 更新记录状态
            record.setStatus(PointsRecordStatus.SUCCESS);
            recordRepository.updateById(record);

        } catch (Exception e) {
            // 6. 更新记录状态为失败
            record.setStatus(PointsRecordStatus.FAILED);
            recordRepository.updateById(record);
            throw e;
        }
    }

    /**
     * 减少积分 - 使用悲观锁
     */
    @Transactional(rollbackFor = Exception.class)
    public void decreasePoints(PointsChangeDTO dto) {
        String transactionId = generateTransactionId(dto.getUserId(), PointsChangeType.DECREASE);

        // 1. 幂等性检查
        if (isTransactionProcessed(transactionId)) {
            log.info("Transaction already processed: {}", transactionId);
            return;
        }

        // 2. 创建积分变动记录
        PointsRecord record = createPointsRecord(dto, PointsChangeType.DECREASE, transactionId);

        try {
            // 3. 查询账户（使用悲观锁）
            PointsAccount account = accountRepository.getByUserIdForUpdate(dto.getUserId());
            if (account == null) {
                throw new CommonException("账户不存在");
            }

            // 4. 检查积分是否足够
            if (account.getPoints() < dto.getPoints()) {
                throw new CommonException("积分不足");
            }

            // 5. 更新积分
            long newPoints = account.getPoints() - dto.getPoints();
            account.setPoints(newPoints);
            accountRepository.updateById(account);

            // 6. 更新记录状态
            record.setStatus(PointsRecordStatus.SUCCESS);
            recordRepository.updateById(record);

        } catch (Exception e) {
            // 7. 更新记录状态为失败
            record.setStatus(PointsRecordStatus.FAILED);
            recordRepository.updateById(record);
            throw e;
        }
    }

    // 生成交易ID
    private String generateTransactionId(Long userId, PointsChangeType type) {
        return String.format("%s_%s_%s", userId, type, UUID.randomUUID().toString().replace("-", ""));
    }

    // 检查交易是否已处理
    private boolean isTransactionProcessed(String transactionId) {
        PointsRecord record = recordRepository.getByTransactionId(transactionId);
        return record != null && record.getStatus() == PointsRecordStatus.SUCCESS;
    }

    // 创建积分记录
    private PointsRecord createPointsRecord(PointsChangeDTO dto, PointsChangeType type, String transactionId) {
        PointsRecord record = new PointsRecord();
        record.setUserId(dto.getUserId());
        record.setPoints(dto.getPoints());
        record.setType(type);
        record.setDescription(dto.getDescription());
        record.setTransactionId(transactionId);
        record.setStatus(PointsRecordStatus.PROCESSING);
        recordRepository.save(record);
        return record;
    }
}

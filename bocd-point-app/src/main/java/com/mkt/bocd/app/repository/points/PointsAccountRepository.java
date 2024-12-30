package com.mkt.bocd.app.repository.points;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.repository.CrudRepository;
import com.mkt.bocd.domain.entity.points.PointsAccount;
import com.mkt.bocd.app.mapper.points.PointsAccountMapper;
import org.springframework.stereotype.Repository;

/**
 * @author manpoyang
 * @version 1.0
 * @date 2024/12/29 14:20
 */
@Repository
public class PointsAccountRepository extends CrudRepository<PointsAccountMapper, PointsAccount> {

    // 使用悲观锁查询账户
    public PointsAccount getByUserIdForUpdate(Long userId) {
        return getBaseMapper().selectOne(
                Wrappers.<PointsAccount>lambdaQuery()
                        .eq(PointsAccount::getUserId, userId)
                        .last("FOR UPDATE")
        );
    }

    // 使用乐观锁更新账户积分
    public boolean updatePoints(Long userId, Long points, Integer version) {
        return getBaseMapper().update(null,
                Wrappers.<PointsAccount>lambdaUpdate()
                        .set(PointsAccount::getPoints, points)
                        .eq(PointsAccount::getUserId, userId)
                        .eq(PointsAccount::getVersion, version)
        ) > 0;
    }
}

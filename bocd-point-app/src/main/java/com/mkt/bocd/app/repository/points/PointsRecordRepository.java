package com.mkt.bocd.app.repository.points;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.repository.CrudRepository;
import com.mkt.bocd.domain.entity.points.PointsRecord;
import com.mkt.bocd.app.mapper.points.PointsRecordMapper;
import org.springframework.stereotype.Repository;

/**
 * @author  manpoyang
 * @date  2024/12/29 14:25
 * @version 1.0
*/

@Repository
public class PointsRecordRepository extends CrudRepository<PointsRecordMapper, PointsRecord> {

    public PointsRecord getByTransactionId(String transactionId) {
        return getBaseMapper().selectOne(
                Wrappers.<PointsRecord>lambdaQuery()
                        .eq(PointsRecord::getTransactionId, transactionId)
        );
    }
}

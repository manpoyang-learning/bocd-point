package com.mkt.bocd.domain.entity.points;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import com.mkt.bocd.common.constant.points.PointsChangeType;
import com.mkt.bocd.common.constant.points.PointsRecordStatus;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author manpoyang
 * @version 1.0
 * @date 2024/12/29 14:08
 */
@Data
@TableName("points_record")
public class PointsRecord {
    @TableId(type = IdType.AUTO)
    private Long id;

    private Long userId;

    private Long points;

    @EnumValue
    private PointsChangeType type;

    private String description;

    private String transactionId;

    @EnumValue
    private PointsRecordStatus status;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}


package com.mkt.bocd.infrastructure.entity.points;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mkt.bocd.common.constant.points.StockChangeType;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author manpoyang
 * @version 1.0
 * @date 2024/12/29 22:09
 */
@Data
@TableName("points_mall_stock_record")
public class StockRecord {
    @TableId(type = IdType.AUTO)
    private Long id;

    private Long productId;

    private Integer changeQuantity;

    @EnumValue
    private StockChangeType type;

    private String orderNo;

    private LocalDateTime createTime;
}


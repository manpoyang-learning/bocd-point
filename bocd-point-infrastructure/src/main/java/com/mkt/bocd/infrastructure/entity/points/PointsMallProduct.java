package com.mkt.bocd.infrastructure.entity.points;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mkt.bocd.common.constant.points.ProductStatus;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author manpoyang
 * @version 1.0
 * @date 2024/12/29 22:04
 */
@Data
@TableName("points_mall_product")
public class PointsMallProduct {
    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;

    private String description;

    private Long pointsPrice;

    private Integer stock;

    @EnumValue
    private ProductStatus status;

    private String imageUrl;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
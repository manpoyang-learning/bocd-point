package com.mkt.bocd.domain.entity.points;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author manpoyang
 * @version 1.0
 * @date 2024/12/29 14:07
 */
@Data
@TableName("points_account")
public class PointsAccount {
    @TableId(type = IdType.AUTO)
    private Long id;

    private Long userId;

    private Long points;

    @Version
    private Integer version;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
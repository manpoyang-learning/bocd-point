package com.mkt.bocd.domain.dto.points;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


/**
 * @author manpoyang
 * @version 1.0
 * @date 2024/12/29 14:10
 */
@Data
public class PointsChangeDTO {
    @NotNull(message = "用户ID不能为空")
    private Long userId;

    @NotNull(message = "积分数不能为空")
    @Min(value = 1, message = "积分数必须大于0")
    private Long points;

    private String description;
}
package com.mkt.bocd.domain.dto.points;

import com.mkt.bocd.common.constant.points.ProductStatus;
import lombok.Data;

/**
 * @author manpoyang
 * @version 1.0
 * @date 2024/12/29 22:50
 */
@Data
public class ProductQueryDTO {
    private String name;
    private ProductStatus status;
    private Long maxPoints;
    private Long minPoints;
    private Integer page = 1;
    private Integer size = 10;
}
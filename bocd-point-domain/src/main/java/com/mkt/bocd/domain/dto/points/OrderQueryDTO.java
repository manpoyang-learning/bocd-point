package com.mkt.bocd.domain.dto.points;

import com.mkt.bocd.common.constant.points.OrderStatus;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author manpoyang
 * @version 1.0
 * @date 2024/12/29 22:50
 */
@Data
public class OrderQueryDTO {
    private Long userId;
    private String orderNo;
    private OrderStatus status;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Integer page = 1;
    private Integer size = 10;
}


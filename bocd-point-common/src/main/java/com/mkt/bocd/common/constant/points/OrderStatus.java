package com.mkt.bocd.common.constant.points;

/**
 * @author manpoyang
 * @version 1.0
 * @date 2024/12/29 22:06
 */
public enum OrderStatus {
    CREATED(0, "已创建"),
    COMPLETED(1, "已完成"),
    CANCELLED(2, "已取消");

    private final int code;
    private final String description;

    OrderStatus(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
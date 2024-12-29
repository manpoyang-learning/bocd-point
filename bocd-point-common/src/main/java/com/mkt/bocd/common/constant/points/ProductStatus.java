package com.mkt.bocd.common.constant.points;

/**
 * @author manpoyang
 * @version 1.0
 * @date 2024/12/29 22:06
 */
public enum ProductStatus {
    OFF_SALE(0, "下架"),
    ON_SALE(1, "上架");

    private final int code;
    private final String description;

    ProductStatus(int code, String description) {
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

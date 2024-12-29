package com.mkt.bocd.common.constant.points;

/**
 * @author manpoyang
 * @version 1.0
 * @date 2024/12/29 22:06
 */
public enum StockChangeType {
    STOCK_IN(1, "入库"),
    STOCK_OUT(2, "出库"),
    ORDER_DEDUCT(3, "订单扣减"),
    ORDER_RETURN(4, "订单返还");

    private final int code;
    private final String description;

    StockChangeType(int code, String description) {
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

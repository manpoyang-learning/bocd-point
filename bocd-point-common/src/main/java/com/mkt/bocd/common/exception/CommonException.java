package com.mkt.bocd.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author manpoyang
 * @version 1.0
 * @date 2024/12/28 11:18
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CommonException extends RuntimeException {

    private static final long serialVersionUID = 8653090271840061986L;

    /**
     * 异常码
     */
    private Integer code;

    /**
     * 异常信息
     */
    private String info;

    public CommonException(Integer code) {
        this.code = code;
    }

    public CommonException(Integer code, Throwable cause) {
        this.code = code;
        super.initCause(cause);
    }

    public CommonException(Integer code, String message) {
        this.code = code;
        this.info = message;
    }

    public CommonException(Integer code, String message, Throwable cause) {
        this.code = code;
        this.info = message;
        super.initCause(cause);
    }

    @Override
    public String toString() {
        return "cn.bugstack.x.api.types.exception.AppException{" +
                "code='" + code + '\'' +
                ", info='" + info + '\'' +
                '}';
    }

}

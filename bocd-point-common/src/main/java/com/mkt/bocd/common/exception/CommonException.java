package com.mkt.bocd.common.exception;

import com.mkt.bocd.common.constant.ResultCode;
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

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 错误信息
     */
    private String message;

    /**
     * 所属模块
     */
    private String module;

    public CommonException(String message) {
        super(message);
        this.code = ResultCode.UNKNOWN.getCode();
    }

    public CommonException(int code, String message) {
        super(message);
        this.code = code;
    }

    public CommonException(int code, String message, Throwable e) {
        super(message, e);
        this.code = code;
    }

    public CommonException(String message, String module) {
        super(message);
        this.module = module;
    }

    public CommonException(int code, String message, String module) {
        super(message);
        this.code = code;
        this.module = module;
    }

    public CommonException(int code, String message, String module, Throwable e) {
        super(message, e);
        this.code = code;
        this.module = module;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }


}

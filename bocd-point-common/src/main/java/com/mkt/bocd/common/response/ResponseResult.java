package com.mkt.bocd.common.response;

import com.mkt.bocd.common.constant.ResultCode;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author manpoyang
 * @version 1.0
 * @date 2024/12/28 10:49
 */





@Getter
@Setter
public class ResponseResult<T> implements Serializable {

    private static final long serialVersionUID = 7000723935764546321L;


    private int code;


    private String message;

    private T data;

    public static ResponseResult success() {
        return success(null);
    }

    public static <T> ResponseResult success(T data) {
        return success(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg(), data);
    }

    public static <T> ResponseResult success(String message, T data) {
        return success(ResultCode.SUCCESS.getCode(), message, data);
    }

    public static <T> ResponseResult success(Integer code, String message, T data) {
        return new ResponseResult(code, message, data);
    }




    public static ResponseResult fail(Integer code, String message) {
        return fail(code, message, null);
    }

    public static <T> ResponseResult fail(Integer code, String message, T data) {
        return new ResponseResult(code, message, data);
    }

    public ResponseResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}

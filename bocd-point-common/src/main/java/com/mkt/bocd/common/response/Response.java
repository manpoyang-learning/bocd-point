package com.mkt.bocd.common.response;

import com.mkt.bocd.common.constant.IResultCode;
import com.mkt.bocd.common.constant.ResultCode;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author manpoyang
 * @version 1.0
 * @date 2024/12/28 10:49
 */



@Data
@Accessors(chain = true)

public class Response<T> implements Serializable {
    private static final long serialVersionUID = 7000723935764546321L;

    private Integer code;
    private String msg;
    private T data;

    public static <T> Response<T> ok(T data) {
        return new Response<T>()
                .setCode(ResultCode.SUCCESS.getCode())
                .setMsg(ResultCode.SUCCESS.getMsg())
                .setData(data);
    }

    public static <T> Response<T> fail(String msg) {
        return new Response<T>()
                .setCode(ResultCode.FAIL.getCode())
                .setMsg(msg);
    }

    public static <T> Response<T> fail(IResultCode resultCode) {
        return new Response<T>()
                .setCode(resultCode.getCode())
                .setMsg(resultCode.getMsg());
    }


    public static <T> Response<T> fail(Integer code, String msg) {
        return new Response<T>()
                .setCode(code)
                .setMsg(msg);
    }
}
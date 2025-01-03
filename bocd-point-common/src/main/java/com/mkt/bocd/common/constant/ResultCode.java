package com.mkt.bocd.common.constant;



/**
 * @author manpoyang
 * @version 1.0
 * @date 2024/12/28 10:56
 */
import lombok.AllArgsConstructor;
import lombok.Getter;



@Getter
@AllArgsConstructor
public enum ResultCode implements IResultCode {
    SUCCESS(200, "操作成功"),
    FAIL(500, "操作失败"),
    VALIDATE_FAILED(400, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或token已过期"),
    FORBIDDEN(403, "没有相关权限"),
    UNKNOWN(404, "请求的资源未找到" ),
    // 服务不可用
    SERVICE_UNAVAILABLE(503, "服务不可用");

    private final Integer code;
    private final String msg;



    @Override
    public String toString() {
        return "ResultCode{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}

package com.mkt.bocd.common.handler;

/**
 * @author manpoyang
 * @version 1.0
 * @date 2024/12/28 11:33
 */
import com.mkt.bocd.common.exception.CommonException;
import com.mkt.bocd.common.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
public class GlobalExceptionHandler {

    // 处理自定义异常 C
    @ExceptionHandler(CommonException.class)
    public ResponseEntity<Response<?>> handleAppException(CommonException ex) {
        // 使用 CommonResponse 返回异常信息
        Response<?> response = Response.fail(ex.getCode(), ex.getInfo());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

    }

    // 处理其他类型的异常
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response<?>> handleException(Exception ex) {
        // 处理未知异常并返回
        Response<?> response = Response.fail(404, "Internal Server Error: " + ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}






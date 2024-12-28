package com.mkt.bocd.common.handler;

/**
 * @author manpoyang
 * @version 1.0
 * @date 2024/12/28 11:33
 */
import com.mkt.bocd.common.exception.CommonException;
import com.mkt.bocd.common.response.ResponseResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

//     处理自定义异常 C
//    @ExceptionHandler(CommonException.class)
//    public ResponseEntity<Response<?>> handleAppException(CommonException ex) {
//        // 使用 CommonResponse 返回异常信息
//        Response<?> response = Response.fail(ex.getCode(), ex.getI());
//        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//
//    }

//    // 处理其他类型的异常
    @ExceptionHandler(CommonException.class)
    public ResponseResult<?> handleAuthorizationException(CommonException e) {
        return ResponseResult.fail(e.getCode(), e.getMessage());
    }



}






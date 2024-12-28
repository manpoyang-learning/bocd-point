package com.mkt.bocd.app.controller.hello;

/**
 * @author manpoyang
 * @version 1.0
 * @date 2024/12/28 10:34
 */

import com.mkt.bocd.common.exception.CommonException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mkt.bocd.common.response.Response;
import com.mkt.bocd.app.service.test.SomeService;

@Slf4j
@RestController
@RequestMapping("/api")
public class HelloController {

    @Autowired
    private SomeService someService;

    @GetMapping("/hello")
    public Response<String> hello() {


        return Response.ok("Hello World!");
    }

    @GetMapping("/test")
    public Response<?> testService() {
        throw new CommonException(400, "Invalid request data");
    }

}
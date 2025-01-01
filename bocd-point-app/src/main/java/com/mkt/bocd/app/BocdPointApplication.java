package com.mkt.bocd.app;

/*
  @author manpoyang
 * @version 1.0
 * @date 2024/12/27 19:56
 */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.mkt.bocd.**"})
@MapperScan("com.mkt.bocd.app.mapper")
//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class BocdPointApplication {
    public static void main(String[] args) {
        SpringApplication.run(BocdPointApplication.class, args);
    }
}
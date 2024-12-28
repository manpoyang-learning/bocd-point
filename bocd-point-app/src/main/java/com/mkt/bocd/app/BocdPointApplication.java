package com.mkt.bocd.app;

/**
 * @author manpoyang
 * @version 1.0
 * @date 2024/12/27 19:56
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.mkt.bocd.point.mapper")
public class BocdPointApplication {
    public static void main(String[] args) {
        SpringApplication.run(BocdPointApplication.class, args);
    }
}
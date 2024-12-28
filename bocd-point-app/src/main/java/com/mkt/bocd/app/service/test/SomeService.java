package com.mkt.bocd.app.service.test;

/**
 * @author manpoyang
 * @version 1.0
 * @date 2024/12/28 11:27
 */

import com.mkt.bocd.common.exception.CommonException;
import org.springframework.stereotype.Service;

@Service
public class SomeService {

    public void someMethod() {
        // 模拟发生异常
        throw new CommonException(400, "Invalid request data");
    }
}

package com.mkt.bocd.app.controller.auth;

import com.mkt.bocd.common.response.ResponseResult;
import com.mkt.bocd.infrastructure.security.util.JwtTokenUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.HashMap;
import java.util.Map;

/**
 * @author manpoyang
 * @version 1.0
 * @date 2025/1/1 16:46
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final PasswordEncoder passwordEncoder;

    public AuthController(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseResult<?> login(@RequestParam String username, @RequestParam String password) {
        // 这里为了简化，直接使用硬编码的用户验证
        String hardcodedUsername = "user";
        String hardcodedPassword = "password";

        if (username.equals(hardcodedUsername) && passwordEncoder.matches(password, passwordEncoder.encode(hardcodedPassword))) {
            String token = JwtTokenUtil.generateToken(username);

            Map<String, String> response = new HashMap<>();
            response.put("token", token);

            return ResponseResult.success(response);
        } else {
            return ResponseResult.fail(401, "Invalid credentials");
        }
    }
}
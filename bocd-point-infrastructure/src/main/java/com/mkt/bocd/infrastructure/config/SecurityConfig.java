package com.mkt.bocd.infrastructure.config;

/**
 * @author manpoyang
 * @version 1.0
 * @date 2025/1/1 16:00
 */


import com.mkt.bocd.infrastructure.filter.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http , JwtAuthenticationFilter jwtFilter) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/auth/login", "/public/**").permitAll() // 登录和公开接口
                .anyRequest().authenticated() // 其他接口需要认证
                .and()
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class) // 注册过滤器
                .sessionManagement().disable(); // 禁用会话（完全基于 Token）

        return http.build();
    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable() // 禁用 CSRF
//                .authorizeRequests()
//                .anyRequest().permitAll(); // 允许所有请求，不做任何拦截
//        return http.build();
//    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // 使用 BCrypt 作为密码加密方式
    }


}
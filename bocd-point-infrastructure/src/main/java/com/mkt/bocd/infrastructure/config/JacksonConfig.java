package com.mkt.bocd.infrastructure.config;

/**
 * @author manpoyang
 * @version 1.0
 * @date 2024/12/30 19:41
 */
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class JacksonConfig {

    @Bean
    public ObjectMapper objectMapper() {
        // 通过 Jackson2ObjectMapperBuilder 创建 ObjectMapper
        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json()
                .modulesToInstall(new JavaTimeModule()) // 注册 JavaTimeModule
                .build();
        return objectMapper;
    }
}
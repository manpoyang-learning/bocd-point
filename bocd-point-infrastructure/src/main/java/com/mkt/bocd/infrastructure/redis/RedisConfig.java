package com.mkt.bocd.infrastructure.redis;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author manpoyang
 * @version 1.0
 * @date 2024/12/30 19:14
 */

/**
 * Redis 配置类，用于配置 RedisTemplate 和通用序列化策略。
 * 该配置类支持存储多种类型的对象到 Redis 中，并进行 JSON 序列化和反序列化。
 */
@Configuration
public class RedisConfig {

    /**
     * RedisTemplate 配置方法
     *
     * @param factory Redis 连接工厂，自动注入
     * @return 配置好的 RedisTemplate 实例
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        // 创建 RedisTemplate 实例，用于操作 Redis 中的键值对
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        // 设置连接工厂，确保与 Redis 服务器的连接
        template.setConnectionFactory(factory);

        // 创建 ObjectMapper 实例，注册 JavaTimeModule 支持 LocalDateTime 等 Java 8 时间类型
        ObjectMapper objectMapper = new ObjectMapper();
        // 注册 JavaTimeModule，处理 Java 8 时间类型
        objectMapper.registerModule(new JavaTimeModule());
        // 自动注册所有可用的 Jackson 模块（包括 JavaTimeModule）
        objectMapper.findAndRegisterModules();

        // 启用自动包含类型信息，用于反序列化时重建对象的实际类型
        objectMapper.activateDefaultTyping(
                objectMapper.getPolymorphicTypeValidator(),  //  验证器，用于验证实际要反序列化的子类型是否有效
                ObjectMapper.DefaultTyping.NON_FINAL, // 定义哪些类型的对象需要添加额外的类型信息，NON_FINAL：非 final类都会包含
                JsonTypeInfo.As.PROPERTY); // 类型信息的包含方式 PROPERTY：类型信息作为JSON对象的一个属性


        // 创建通用的 JSON 序列化器，支持所有类型的对象
        GenericJackson2JsonRedisSerializer serializer = new GenericJackson2JsonRedisSerializer(objectMapper);

        // 设置键的序列化方式为 StringRedisSerializer，默认使用 UTF-8 编码
        template.setKeySerializer(new StringRedisSerializer());
        // 设置值的序列化方式为通用的 Jackson2JsonRedisSerializer，支持所有类型
        template.setValueSerializer(serializer);

        return template;
    }
}



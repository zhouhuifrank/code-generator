package com.frankzhou.api.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description redisson客户端工具类
 * @date 2023-01-18
 */
@Configuration
@ConditionalOnExpression("${spring.data.redis.enabled}")
public class RedissonConfig {

    @Value("${spring.data.redis.host}")
    private String host;

    @Value("${spring.data.redis.password}")
    private String password;

    @Value(("${spring.data.redis.port}"))
    private Integer port;

    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();
        String address = "redis://" + host + ":" + port;
        config.useSingleServer().setAddress(address).setPassword(password);
        return Redisson.create(config);
    }
}

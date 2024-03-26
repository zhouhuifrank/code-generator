package com.frankzhou.intelligence.bi.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description druid配置类
 * @date 2024-03-26
 */
@Configuration
public class DruidConfig {

    /**
     * 初始化数据源
     * druid监控访问网址 http://localhost:8080/intelligenceBi/druid/login.html
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }
}

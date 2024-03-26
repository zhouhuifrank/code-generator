package com.frankzhou.api;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 数据服务应用
 * @date 2024-03-26
 */
@Slf4j
@MapperScan(basePackages = "com.frankzhou.api.mapper")
@SpringBootApplication
public class DataServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataServiceApplication.class, args);
        log.info("==========Data Service Start Success==========");
    }

}

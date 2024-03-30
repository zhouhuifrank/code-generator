package com.frankzhou.data.sync;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 实时数据同步平台
 * @date 2024-03-24
 */
@Slf4j
@MapperScan(basePackages = "com.frankzhou.data.sync.mapper")
@SpringBootApplication
public class DataSyncApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataSyncApplication.class, args);
        log.info("===============Real Time Data Sync Start Success==============");
    }

}

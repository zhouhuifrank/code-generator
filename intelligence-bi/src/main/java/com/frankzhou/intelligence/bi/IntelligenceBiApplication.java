package com.frankzhou.intelligence.bi;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j
@SpringBootApplication
@MapperScan(basePackages = "com.frankzhou.intelligence.bi.mapper")
@EnableScheduling
@EnableTransactionManagement
public class IntelligenceBiApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntelligenceBiApplication.class, args);
		log.info("=========Intelligence Bi Start Success=========");
	}

}

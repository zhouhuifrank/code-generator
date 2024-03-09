package com.frankzhou.intelligence.bi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class IntelligenceBiApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntelligenceBiApplication.class, args);
		log.info("=========Intelligence Bi Start Success=========");
	}

}

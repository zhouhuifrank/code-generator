package com.frankzhou.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class CodeCommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodeCommonApplication.class, args);
        log.info("=========Code Common Start Success========");
    }

}

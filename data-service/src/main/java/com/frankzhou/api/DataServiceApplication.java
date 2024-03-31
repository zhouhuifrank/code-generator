package com.frankzhou.api;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.net.InetAddress;
import java.net.UnknownHostException;

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

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext application = SpringApplication.run(DataServiceApplication.class, args);
        ConfigurableEnvironment env = application.getEnvironment();
        env.getProperty("server.servlet.context-path");
        log.info("----------------------------------------------------------\n\t" +
                        "Application {} is running! Access URLs:\n\t" +
                        "Local: \t\thttp://localhost:{}/{}\n\t" +
                        "External: \t\thttp://{}:{}/{}\n\t"+
                        "Api Doc: \thttp://{}:{}/{}/doc.html\n"+
                        "----------------------------------------------------------",
                env.getProperty("spring.application.name"),
                env.getProperty("server.port"),
                env.getProperty("server.servlet.context-path"),
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port"),
                env.getProperty("server.servlet.context-path"),
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port"),
                env.getProperty("server.servlet.context-path"));
    }

}

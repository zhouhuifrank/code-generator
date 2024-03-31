package com.frankzhou.intelligence.bi;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.mapping.Environment;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@SpringBootApplication
@MapperScan(basePackages = "com.frankzhou.intelligence.bi.mapper")
@EnableScheduling
@EnableTransactionManagement
public class IntelligenceBiApplication {

	public static void main(String[] args) throws UnknownHostException {
		ConfigurableApplicationContext application = SpringApplication.run(IntelligenceBiApplication.class, args);
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

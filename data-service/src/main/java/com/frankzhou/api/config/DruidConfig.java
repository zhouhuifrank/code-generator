package com.frankzhou.api.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewFilter;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
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
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    // druid监控访问网址 http://localhost:8080/dataService/druid/login.html
    @Bean
    public ServletRegistrationBean druidServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        bean.addInitParameter("allow","");
        bean.addInitParameter("resetEnable","false");
        bean.addInitParameter("loginUsername","admin");
        bean.addInitParameter("loginPassword","admin");
        return bean;
    }

    @Bean
    public FilterRegistrationBean statFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean(new StatViewFilter());
        bean.addUrlPatterns("/*");
        bean.addInitParameter("exclusions","*.js,*.gif,/druid/*");
        return bean;
    }
}

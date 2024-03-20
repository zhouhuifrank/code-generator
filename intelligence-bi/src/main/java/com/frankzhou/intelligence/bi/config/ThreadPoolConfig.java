package com.frankzhou.intelligence.bi.config;

import cn.hutool.extra.spring.SpringUtil;
import com.frankzhou.intelligence.bi.common.factory.MyThreadFactory;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskDecorator;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 线程池配置类
 * @date 2024-03-16
 */
@Slf4j
@Configuration
@EnableAsync
public class ThreadPoolConfig implements AsyncConfigurer {

    public static final String COMMON_EXECUTOR = "COMMON_EXECUTOR";

    public static final String AI_EXECUTOR = "AI_EXECUTOR";

    public static final String WS_EXECUTOR = "WS_EXECUTOR";

    @Override
    public Executor getAsyncExecutor() {
        return commonExecutor();
    }

    @Bean(ThreadPoolConfig.COMMON_EXECUTOR)
    public ThreadPoolTaskExecutor commonExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(15);
        executor.setKeepAliveSeconds(60);
        executor.setQueueCapacity(100);
        executor.setThreadFactory(new MyThreadFactory(executor));
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.setThreadNamePrefix("common-executor");
        executor.setAwaitTerminationMillis(6000);
        executor.setTaskDecorator(new LogTaskDecorator(ThreadPoolConfig.COMMON_EXECUTOR));
        executor.initialize();
        return executor;
    }

    @Bean(ThreadPoolConfig.AI_EXECUTOR)
    public ThreadPoolTaskExecutor aiExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(4);
        executor.setMaxPoolSize(4);
        executor.setKeepAliveSeconds(60);
        executor.setQueueCapacity(8);
        executor.setThreadFactory(new MyThreadFactory(executor));
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.setThreadNamePrefix("ai-executor");
        executor.setAwaitTerminationMillis(6000);
        executor.setTaskDecorator(new LogTaskDecorator(ThreadPoolConfig.AI_EXECUTOR));
        executor.initialize();
        return executor;
    }

    @Bean(ThreadPoolConfig.WS_EXECUTOR)
    public ThreadPoolTaskExecutor wsExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(20);
        executor.setMaxPoolSize(25);
        executor.setKeepAliveSeconds(60);
        executor.setQueueCapacity(1000);
        executor.setThreadFactory(new MyThreadFactory(executor));
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.setThreadNamePrefix("ws-executor");
        executor.setAwaitTerminationMillis(6000);
        executor.setTaskDecorator(new LogTaskDecorator(ThreadPoolConfig.WS_EXECUTOR));
        executor.initialize();
        return executor;
    }


    public class LogTaskDecorator implements TaskDecorator {

        private String executorName;

        public LogTaskDecorator (String executorName) {
            executorName = this.executorName;
        }

        @Override
        public Runnable decorate(Runnable runnable) {
            ThreadPoolTaskExecutor executor = (ThreadPoolTaskExecutor) SpringUtil.getBean(executorName);
            String executorName = executor.getThreadNamePrefix();
            int corePoolSize = executor.getCorePoolSize();
            int maxPoolSize = executor.getMaxPoolSize();
            int activeCount = executor.getActiveCount();
            int queueCapacity = executor.getQueueCapacity();

            Runnable decorateTask = () -> {
                runnable.run();
                log.info("任务执行中,线程池名称:{},核心线程数:{},最大线程数:{},当前活跃线程数:{},队列容量:{}",executorName,corePoolSize,maxPoolSize,activeCount,queueCapacity);
            };
            return decorateTask;
        }
    }
}

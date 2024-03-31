package com.frankzhou.intelligence.bi.util;

import com.frankzhou.intelligence.bi.config.ThreadPoolConfig;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Executor;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description
 * @date 2024-03-31
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class ThreadPoolTests {

    @Resource(name = ThreadPoolConfig.COMMON_EXECUTOR)
    private Executor commonExecutor;


    @Test
    public void testExecutor() {
        commonExecutor.execute(() -> {
            for (int i=0; i<10; i++) {
                log.info("线程池执行中:{}", i);
            }
        });
    }
}

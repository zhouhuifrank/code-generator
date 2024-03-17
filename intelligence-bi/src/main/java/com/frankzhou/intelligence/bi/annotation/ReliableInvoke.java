package com.frankzhou.intelligence.bi.annotation;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 可靠消息(异步任务)调用
 * @date 2024-03-16
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ReliableInvoke {

    /**
     * 消息类型
     */
    String messageType() default "";

    /**
     * 最大重试次数
     */
    int maxRetryCount() default 3;

    /**
     * 是否异步执行 true异步/false同步
     */
    boolean async() default true;

    /**
     * 执行异步方法时使用的线程池 默认使用ForkJoin线程池
     */
    String executor() default "";
}

package com.frankzhou.intelligence.bi.aop;

import com.frankzhou.common.util.JsonUtil;
import com.frankzhou.intelligence.bi.annotation.ReliableInvoke;
import com.frankzhou.intelligence.bi.domain.dto.invoke.ReliableInvokeDTO;
import com.frankzhou.intelligence.bi.domain.dto.invoke.ReliableMessageRecordDTO;
import com.frankzhou.intelligence.bi.domain.enums.MessageStatusEnum;
import com.frankzhou.intelligence.bi.service.ReliableInvokeService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 可靠消息(异步)调用切面
 * @date 2024-03-16
 */
@Slf4j
@Aspect
@Component
@Order(Ordered.HIGHEST_PRECEDENCE + 1)
public class ReliableInvokeAspect {

    @Resource
    private ReliableInvokeService reliableInvokeService;

    @Pointcut("@annotation(com.frankzhou.intelligence.bi.annotation.ReliableInvoke)")
    public void aopPoint() {
    }

    @Around("aopPoint()")
    public Object doReliableInvoke(ProceedingJoinPoint jp) throws Throwable {
        /**
         * 如果不在事务环境下 则直接进行，不进行保证
         */
        boolean isInTransaction = TransactionSynchronizationManager.isActualTransactionActive();
        if (!isInTransaction) {
            return jp.proceed();
        }

        Method method = getMethod(jp);
        ReliableInvoke reliableInvoke = method.getAnnotation(ReliableInvoke.class);

        String className = method.getDeclaringClass().getName();
        String methodName = method.getName();
        Class<?>[] parameterTypes = method.getParameterTypes();
        List<String> parameterStringList = Stream.of(parameterTypes).map(Class::getName).collect(Collectors.toList());
        Object[] args = jp.getArgs();
        List<String> argStringList = Stream.of(args).map(Object::toString).collect(Collectors.toList());
        ReliableInvokeDTO reliableInvokeDTO = ReliableInvokeDTO
                .builder()
                .className(className)
                .methodName(methodName)
                .parameterTypes(JsonUtil.toJsonStr(parameterStringList))
                .args(JsonUtil.toJsonStr(argStringList))
                .build();

        ReliableMessageRecordDTO recordDTO = ReliableMessageRecordDTO
                .builder()
                .messageType(reliableInvoke.messageType())
                .reliableInvokeDTO(reliableInvokeDTO)
                .messageStatus(MessageStatusEnum.SEND_BEFORE.getCode())
                .retryCount(0)
                .maxRetryCount(reliableInvoke.maxRetryCount())
                .executor(reliableInvoke.executor())
                .build();

        reliableInvokeService.doInvoke(recordDTO, reliableInvoke.async());
        return null;
    }

    private Method getMethod(ProceedingJoinPoint jp) {
        MethodSignature methodSignature = (MethodSignature) jp.getSignature();
        Method method = methodSignature.getMethod();
        return method;
    }
}

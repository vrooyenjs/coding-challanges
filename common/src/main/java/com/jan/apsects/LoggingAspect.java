package com.jan.apsects;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class LoggingAspect {

    @Pointcut("@within(org.springframework.stereotype.Component)")
    public void components() {
    }

    @Pointcut("execution(* *.execute*(..))")
    public void executeMethod() {
    }

    @Around("components() && executeMethod()")
    public Object logAroundExeutionMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        String packageName = proceedingJoinPoint.getSignature().getDeclaringTypeName();
        String methodName = proceedingJoinPoint.getSignature().getName();

        log.info("{}.{} - Starting", packageName, methodName);
        long start = System.currentTimeMillis();

        Object obj = null;
        try {
            obj = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            log.error("{}.{} - Exception occurred: {}", packageName, methodName, ExceptionUtils.getRootCauseMessage(throwable), throwable);
            throw throwable;
        }
        log.info("{}.{} - Completed in {}ms", packageName, methodName, (System.currentTimeMillis() - start));

        return obj;
    }
}

package com.epam.telescope.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    private Logger myLogger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.epam.telescope.controller.*.*(..))")
    private void forControllerPackage() {
    }

    @Pointcut("execution(* com.epam.telescope.service.*Impl.*(..))")
    private void forServicePackage() {
    }

    @Pointcut("forControllerPackage() || forServicePackage()")
    private void forAppFlow() {
    }

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {

        String method = joinPoint.getSignature().toShortString();
        myLogger.info("=======>> @Before: calling method: " + method);
        Object[] args = joinPoint.getArgs();

        for (Object tempArg : args) {
            myLogger.info("=====>> argument: " + tempArg);
        }
    }

    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "result"
    )
    public void afterReturning(JoinPoint joinPoint, Object result) {

        String method = joinPoint.getSignature().toShortString();
        myLogger.info("=======>> @AfterReturning: calling method: " + method);
        myLogger.info("======>> result : " + result);
    }
}

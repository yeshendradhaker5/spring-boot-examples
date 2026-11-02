package com.ch6.aopex2.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect {

    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("execution(* com.ch6.aopex2.service.*.*(..))")
    public String log(ProceedingJoinPoint joinPoint) throws Throwable{
        String methodName = joinPoint.getSignature().getName();

        Object [] parameters = joinPoint.getArgs();

        logger.info("Method name "+methodName+" with parameters are "
                + Arrays.asList(parameters));
        logger.info("Source Location "+joinPoint.getSourceLocation());
        logger.info("Static Part "+joinPoint.getStaticPart()+"" +
                "Target "+joinPoint.getTarget()+
                "This "+joinPoint.getThis());
        Object returnedResponse = joinPoint.proceed();
        return (returnedResponse.equals("SUCCESS")) ? "FAILED" : null;
    }
}

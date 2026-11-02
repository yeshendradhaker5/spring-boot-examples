package com.ch6.aopex3.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect {

    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("@annotation(com.ch6.aopex3.custom.ToLog)")
    public Object log(ProceedingJoinPoint joinPoint)throws Throwable{
        String methodName = joinPoint.getSignature().getName();

        Object [] parameters = joinPoint.getArgs();

        logger.info("Method name "+methodName+" with parameters are "
                + Arrays.asList(parameters));

        Object returnedResponse = joinPoint.proceed();
        return (returnedResponse.equals("SUCCESS")) ? "FAILED" : null;
    }
}

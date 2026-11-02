package com.ch6.aopex5.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

import java.util.logging.Logger;

@Aspect
@Order(1)
public class SecurityAspect {

    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("@annotation(com.ch6.aopex5.custom.SecurityCheck)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable{
        logger.info("Method Under Security Check");
        Object returnedValue = joinPoint.proceed();

        Object [] parameters = joinPoint.getArgs();

        logger.info("SMethod name "+joinPoint.getSignature().getName()+" with parameters "+
                parameters);
        logger.info("Security Check passed");
        return returnedValue;
    }
}

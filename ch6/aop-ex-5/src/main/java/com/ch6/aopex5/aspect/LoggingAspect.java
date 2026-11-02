package com.ch6.aopex5.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.logging.Logger;

@Aspect
public class LoggingAspect {

    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("@annotation(com.ch6.aopex5.custom.ToLog)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable{
        logger.info("Method Execution starts");
        Object returnedValue = joinPoint.proceed();

        Object [] parameters = joinPoint.getArgs();

        logger.info("Method name "+joinPoint.getSignature().getName()+" with parameters "+
                parameters);

        return returnedValue;
    }

}

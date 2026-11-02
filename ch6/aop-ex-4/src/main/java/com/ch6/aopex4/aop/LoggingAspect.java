package com.ch6.aopex4.aop;

import com.ch6.aopex4.config.ProjectConfig;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    private Logger logger = Logger.getLogger(ProjectConfig.class.getName());

    @Before("@annotation(com.ch6.aopex4.custom.ToLog)")
    public void logBefore(JoinPoint joinPoint) throws Throwable{
        logger.info("Called Before");

    }
}

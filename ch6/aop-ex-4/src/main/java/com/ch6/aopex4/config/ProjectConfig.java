package com.ch6.aopex4.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.logging.Logger;

@Configuration
@ComponentScan(basePackages = "com.ch6.aopex4")
@EnableAspectJAutoProxy
public class ProjectConfig {


}

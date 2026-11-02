package com.ch6.aopex3.config;

import com.ch6.aopex3.aop.LoggingAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.ch6.aopex3")
@EnableAspectJAutoProxy
public class ProjectConfig {

    @Bean
    LoggingAspect loggingAspect(){
        return new LoggingAspect();
    }
}

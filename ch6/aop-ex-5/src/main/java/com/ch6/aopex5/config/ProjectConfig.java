package com.ch6.aopex5.config;

import com.ch6.aopex5.aspect.LoggingAspect;
import com.ch6.aopex5.aspect.SecurityAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.ch6.aopex5")
@EnableAspectJAutoProxy
public class ProjectConfig {

    @Bean
    LoggingAspect loggingAspect(){
        return new LoggingAspect();
    }

    @Bean
    SecurityAspect securityAspect(){
        return new SecurityAspect();
    }
}

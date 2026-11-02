package com.ch6.aopex1.congig;

import com.ch6.aopex1.aop.LoggingAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.ch6.aopex1")
@EnableAspectJAutoProxy
public class ProjectConfig {

    @Bean
    LoggingAspect loggingAspect(){
        return new LoggingAspect();
    }
}

package com.ch5.beanscope3.config;

import com.ch5.beanscope3.model.CommentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean
    CommentService commentService1(){
        return new CommentService();
    }

    @Bean
    CommentService commentService2(){
        return new CommentService();

    }

}

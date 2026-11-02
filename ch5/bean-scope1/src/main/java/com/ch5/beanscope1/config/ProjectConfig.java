package com.ch5.beanscope1.config;

import com.ch5.beanscope1.model.CommentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean
    CommentService commentService(){
        return new CommentService();
    }

}

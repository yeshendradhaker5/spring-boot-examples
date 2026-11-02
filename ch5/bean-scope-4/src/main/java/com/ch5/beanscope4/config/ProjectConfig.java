package com.ch5.beanscope4.config;

import com.ch5.beanscope4.repository.DBRepository;
import com.ch5.beanscope4.service.CommentService;
import com.ch5.beanscope4.service.UserService;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ProjectConfig {

    @Bean
    CommentService commentService(){
        return new CommentService(dbRepository());
    }

    @Bean
    UserService userService(){
        return new UserService(dbRepository());
    }

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    DBRepository dbRepository(){
        return new DBRepository();
    }
}

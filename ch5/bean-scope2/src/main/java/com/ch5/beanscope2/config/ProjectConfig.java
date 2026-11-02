package com.ch5.beanscope2.config;

import com.ch5.beanscope2.model.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean
    Parrot parrot(){
        Parrot parrot = new Parrot("Koko");
        return parrot;
    }

}

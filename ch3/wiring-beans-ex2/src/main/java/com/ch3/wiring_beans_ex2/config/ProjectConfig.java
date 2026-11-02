package com.ch3.wiring_beans_ex2.config;

import com.ch3.wiring_beans_ex2.model.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.ch3.wiring_beans_ex2")
public class ProjectConfig {

    @Bean
    Parrot parrot(){
        Parrot parrot = new Parrot("Koko");
        return parrot;
    }
}

package com.ch3.InjectingBeanThroughParam.config;

import com.ch3.InjectingBeanThroughParam.model.Parrot;
import com.ch3.InjectingBeanThroughParam.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean
    Parrot parrot(){
        Parrot parrot = new Parrot();
        parrot.setName("Koko");
        return parrot;
    }

    @Bean
    Person person(Parrot parrot){
        Person person = new Person();
        person.setName("John");
        person.setParrot(parrot);
        return person;
    }
}

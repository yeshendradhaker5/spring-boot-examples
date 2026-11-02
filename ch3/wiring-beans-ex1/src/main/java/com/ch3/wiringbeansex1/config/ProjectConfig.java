package com.ch3.wiringbeansex1.config;

import com.ch3.wiringbeansex1.model.Parrot;
import com.ch3.wiringbeansex1.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean
    Parrot parrot(){
        Parrot parrot = new Parrot();
        parrot.setName("KoPo");
        return parrot;
    }

    @Bean
    Person person(){
        Person person = new Person();
        person.setName("John");
        person.setParrot(parrot());
        return person;
    }
}

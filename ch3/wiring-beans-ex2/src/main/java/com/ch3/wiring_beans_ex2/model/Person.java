package com.ch3.wiring_beans_ex2.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
    private String name;
    private final Parrot parrot;

    public Person(Parrot parrot){
        this.parrot=parrot;
    }

    public Parrot getParrot(){
        return this.parrot;
    }
}

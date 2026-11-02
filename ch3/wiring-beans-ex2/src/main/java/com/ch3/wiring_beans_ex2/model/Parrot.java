package com.ch3.wiring_beans_ex2.model;

public class Parrot {
    private String name;

    public Parrot(String name){
        this.name=name;
    }

    public String getName(){
        return this.name;
    }
}

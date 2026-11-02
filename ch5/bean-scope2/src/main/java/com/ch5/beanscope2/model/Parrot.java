package com.ch5.beanscope2.model;

public class Parrot {

    private String name;

    public Parrot(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name=name;
    }
}

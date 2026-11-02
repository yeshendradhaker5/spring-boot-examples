package com.ch3.wiringbeansex1.model;

public class Parrot {
    private String name;

    public Parrot(){
        System.out.println("Call this time");
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name=name;
    }
}

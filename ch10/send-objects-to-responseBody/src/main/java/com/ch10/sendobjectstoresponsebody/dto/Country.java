package com.ch10.sendobjectstoresponsebody.dto;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

public class Country {
    private String name;
    private int population;

    public void setName(String name) {
        this.name = name;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

//    public String getName() {
//        return name;
//    }
//
//    public int getPopulation() {
//        return population;
//    }
}

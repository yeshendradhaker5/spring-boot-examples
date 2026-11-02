package com.ch9.applicationscope.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

@Component
@ApplicationScope
public class LoginCount {

    private int count;

    public void increment(){
        this.count++;
    }

    public int getCount(){
        return this.count;
    }

}

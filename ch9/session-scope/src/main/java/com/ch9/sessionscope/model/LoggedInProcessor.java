package com.ch9.sessionscope.model;

import com.ch9.sessionscope.service.LoggedUserManagement;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoggedInProcessor {

    private String username;
    private String password;
    private final LoggedUserManagement loggedUserManagement;

    public LoggedInProcessor(LoggedUserManagement loggedUserManagement){
        this.loggedUserManagement = loggedUserManagement;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername(){
        return this.username;
    }

    public boolean login(){
        if("chris".equals(this.username) && "evans".equals(password)){
            this.loggedUserManagement.setUsername(this.username);
            return true;
        }
        else{
            return false;
        }
    }
}

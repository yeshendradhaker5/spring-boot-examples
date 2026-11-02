package com.ch9.applicationscope.model;

import com.ch9.applicationscope.service.LoggedUserManagement;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoggedInProcessor {

    private String username;
    private String password;
    private final LoggedUserManagement loggedUserManagement;
    private final LoginCount loginCount;

    public LoggedInProcessor(LoggedUserManagement loggedUserManagement, LoginCount loginCount){
        this.loggedUserManagement = loggedUserManagement;
        this.loginCount = loginCount;
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
        loginCount.increment();
        if("chris".equals(this.username) && "evans".equals(password)){
            this.loggedUserManagement.setUsername(this.username);
            return true;
        }
        else{
            return false;
        }
    }
}

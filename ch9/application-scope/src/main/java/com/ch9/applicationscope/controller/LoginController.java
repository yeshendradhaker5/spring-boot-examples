package com.ch9.applicationscope.controller;

import com.ch9.applicationscope.model.LoggedInProcessor;
import com.ch9.applicationscope.service.LoggedUserManagement;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final LoggedInProcessor loggedInProcessor;
    private final LoggedUserManagement loggedUserManagement;

    public LoginController(LoggedInProcessor loggedInProcessor, LoggedUserManagement loggedUserManagement){
        this.loggedInProcessor = loggedInProcessor;
        this.loggedUserManagement = loggedUserManagement;
    }

    @GetMapping("/")
    public String loginPage(){
        if(loggedUserManagement.getUsername()!=null){
            return "redirect:/main";
        }

        return "login.html";
    }

    @PostMapping("/")
    public String login(@RequestParam(required = false) String username,
                        @RequestParam(required = false) String password,
                        Model model){

        loggedInProcessor.setUsername(username);
        loggedInProcessor.setPassword(password);

        boolean isLoggedIn = loggedInProcessor.login();
        if(isLoggedIn){
            return "redirect:/main";
        }
        else {
            model.addAttribute("loginStatus", "Login failed");
            return "login.html";
        }

    }
}

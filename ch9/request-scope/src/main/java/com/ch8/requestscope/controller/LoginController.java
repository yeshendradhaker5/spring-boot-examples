package com.ch8.requestscope.controller;

import com.ch8.requestscope.processor.LoginProcessor;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.logging.Logger;

@Controller
public class LoginController {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(LoginController.class);
    private final LoginProcessor loginProcessor;
    private Logger logger = Logger.getLogger(LoginController.class.getName());

    @Autowired
    public LoginController(LoginProcessor loginProcessor){
        this.loginProcessor = loginProcessor;
    }

    @GetMapping("/")
    public String loginPage(){
        return "login.html";
    }

    @PostMapping("/")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model){

        loginProcessor.setUsername(username);
        loginProcessor.setPassword(password);
        boolean isLoggedIn = loginProcessor.login(username, password);
        if(isLoggedIn){
            model.addAttribute("isLoggedIn", "Login successful.");
        }
        else {
            model.addAttribute("isLoggedIn", "Login Failed, please try again.");
        }

        return "login.html";
    }
}

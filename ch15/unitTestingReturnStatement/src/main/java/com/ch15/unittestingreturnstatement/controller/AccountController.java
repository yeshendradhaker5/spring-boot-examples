package com.ch15.unittestingreturnstatement.controller;

import com.ch15.unittestingreturnstatement.model.Account;
import com.ch15.unittestingreturnstatement.service.AccountService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    private final AccountService accountService;


    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @PostMapping("/signup")
    public Account signUp(@RequestParam(required = false) String username,
                          @RequestParam(required = false) String name,
                          @RequestParam(required = false) String password){
       return accountService.signUp(username, name, password);
    }

    @PostMapping("/login")
    public String login(@RequestParam(required = false) String username,
                         @RequestParam(required = false) String password,
                         Model model){
        Boolean isLoggedIn = accountService.login(username, password);

        if(isLoggedIn){
            model.addAttribute("login", "Logged in successfully");
        }
        else {
            model.addAttribute("login", "Login failed");
        }

        return "login.html";
    }

}

package com.ch9.applicationscope.controller;

import com.ch9.applicationscope.model.LoginCount;
import com.ch9.applicationscope.service.LoggedUserManagement;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private final LoggedUserManagement loggedUserManagement;
    private final LoginCount loginCount;

    public MainController(LoggedUserManagement loggedUserManagement, LoginCount loginCount) {
        this.loggedUserManagement = loggedUserManagement;
        this.loginCount = loginCount;
    }

    @GetMapping("/main")
    public String dashboardPage(@RequestParam(required = false) String logout,
                                Model model){

        if(logout != null){
            loggedUserManagement.setUsername(null);
        }

        if(loggedUserManagement.getUsername() == null){
            return "redirect:/";
        }

        model.addAttribute("username", loggedUserManagement.getUsername());
        model.addAttribute("logincount", loginCount.getCount());
        return "main.html";
    }

}

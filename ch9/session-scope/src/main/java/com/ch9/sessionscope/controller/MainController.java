package com.ch9.sessionscope.controller;

import com.ch9.sessionscope.model.LoggedInProcessor;
import com.ch9.sessionscope.service.LoggedUserManagement;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private final LoggedUserManagement loggedUserManagement;

    public MainController(LoggedUserManagement loggedUserManagement) {
        this.loggedUserManagement = loggedUserManagement;
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
        return "main.html";
    }

}

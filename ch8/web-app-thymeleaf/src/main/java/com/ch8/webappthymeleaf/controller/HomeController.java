package com.ch8.webappthymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String homePage(Model page){
        page.addAttribute("color", "blue");
        page.addAttribute("name", "Kevin");

        return "home.html";
    }
}

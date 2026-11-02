package com.ch8.webapprequestparams.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {

    @RequestMapping("/home")
    public String homePage(@RequestParam(required = false) Integer id, Model page){
        page.addAttribute("color", id);
        page.addAttribute("name", "Kevin");

        return "home.html";
    }
}

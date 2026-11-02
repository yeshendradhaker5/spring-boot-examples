package com.ch7.firstwebapp1.controller;

import com.ch7.firstwebapp1.custom.ToLog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/home")
    @ToLog
    public String homeController(){
        return "home.html";
    }

}

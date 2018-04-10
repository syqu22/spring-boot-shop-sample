package com.syqu.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/index")
    public String home1(){
        return "home";
    }

    @GetMapping("/home")
    public String home2(){
        return "home";
    }
}

package com.syqu.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {

    @GetMapping("/about")
    public String about(){
        return "about";
    }

    @GetMapping("/help")
    public String help(){
        return "help";
    }
}

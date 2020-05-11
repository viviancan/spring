package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class HomeController {
    // Controller Exercise - Version 1
//    @GetMapping("/")
//    @ResponseBody
//    public String home(){
//        return "This is the landing page!";
//    }

    @GetMapping("/")
    public String welcome(){
        return "home";
    }

}

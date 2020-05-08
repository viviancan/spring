package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

//  /add/3/and/4	7
//  /subtract/3/from/10	7
//  /multiply/4/and/5	20
//  /divide/6/by/3	2

@Controller
public class MathController {
    @GetMapping("/add/{a}/and/{b}")
    @ResponseBody
    public int add(@PathVariable int a, @PathVariable int b){
        return a + b;

    }

    @GetMapping("/subtract/{a}/from/{b}")
    @ResponseBody
    public int subtract(@PathVariable int a, @PathVariable int b){
        return b - a;

    }


    @GetMapping("/multiply/{a}/from/{b}")
    @ResponseBody
    public int multiply(@PathVariable int a, @PathVariable int b){
        return a * b;

    }

    @GetMapping("/divide/{a}/by/{b}")
    @ResponseBody
    public int divide(@PathVariable int a, @PathVariable int b){
        return a / b;

    }




}

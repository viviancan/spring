package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Controller
class HelloController {
    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello from Spring!";
    }

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }


    @GetMapping("/join")
    public String showJoinForm() {
        return "join";
    }

    @PostMapping("/join")
    public String joinCohort(@RequestParam(name = "cohort") String cohort, Model model) {
        model.addAttribute("cohort", "Welcome to " + cohort + "!");
        return "join";
    }

    @GetMapping("/roll-dice")
    public String rollDice(){
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{userNum}")
    public String rollDiceReturn(@PathVariable int userNum, Model model){
        boolean isEqual = false;

//        https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java
        int randomNumber = ThreadLocalRandom.current().nextInt(1, 6 + 1);

        if(randomNumber == userNum){
            isEqual = true;
        }

        model.addAttribute("userNum", userNum);
        model.addAttribute("isEqual", isEqual);
        model.addAttribute("randomNum", randomNumber);

        return "roll-dice-answer";
    }




}

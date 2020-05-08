package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//        GET	/posts	posts index page
//        GET	/posts/{id}	view an individual post
//        GET	/posts/create	view the form for creating a post
//        POST	/posts/create	create a new post

@Controller
public class PostController {
//    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    @GetMapping("/posts")
    @ResponseBody
    public String index(){
        return "Index page for posts";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String post(@PathVariable long id){
        return "Page for Post: " + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String postCreateForm(){
        return "Viewing the form to create a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createNewPost(){
        return "Creating a new post";
    }
}

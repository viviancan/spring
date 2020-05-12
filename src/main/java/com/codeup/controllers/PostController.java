package com.codeup.controllers;

import com.codeup.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

//        GET	/posts	posts index page
//        GET	/posts/{id}	view an individual post
//        GET	/posts/create	view the form for creating a post
//        POST	/posts/create	create a new post

@Controller
public class PostController {
//    @RequestMapping(path = "/posts", method = RequestMethod.GET)

// Version One
//    @GetMapping("/posts")
//    @ResponseBody
//    public String index(){
//        return "Index page for posts";
//    }

//    @GetMapping("/posts/{id}")
//    @ResponseBody
//    public String post(@PathVariable long id){
//        return "Page for Post: " + id;
//    }
//


//Version Two - Views lesson
    @GetMapping("/posts")
    public String index(Model model){
        ArrayList<Post> postList = new ArrayList<>();

//        postList.add(new Post("Day 1", "This is the body of a post for day 1!"));
//        postList.add(new Post("Day 2", "This is the body of a post for day 2!"));
//        postList.add(new Post("Day 3", "This is the body of a post for day 3!"));

        for (int i = 1; i <= 5; i++) {
            String fTitle = "Day " + i;
            String fBody = "This is the body of a post for day " + i;
            postList.add(new Post( fTitle, fBody));
        }

        model.addAttribute("posts", postList);

        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String post(@PathVariable long id, Model model){
        Post newPost = new Post("Example Post", "This is the body of a post!");
        model.addAttribute("post", newPost);
        return "posts/show";
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

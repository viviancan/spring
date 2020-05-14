package com.codeup.controllers;

import com.codeup.models.Post;
import com.codeup.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


@Controller
public class PostController {
    private final PostRepository postRepo;

    public PostController(PostRepository postRepo) {
        this.postRepo = postRepo;
    }

    @GetMapping("/")
    public String fallback(){
        return "redirect:/posts";
    }

    @GetMapping("/posts")
    public String index(Model model){

        List<Post> postList = postRepo.findAll();

        model.addAttribute("posts", postList);

        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String post(@PathVariable long id, Model model){
        model.addAttribute("post", postRepo.getOne(id));
        return "posts/show";
    }

    @GetMapping("/posts/{id}/edit")
    public String editPost(@PathVariable long id, Model model){
        model.addAttribute("post", postRepo.getOne(id));
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String editPost(@PathVariable long id, Model model, @RequestParam String title, @RequestParam String body){

        Post oldPost = postRepo.getOne(id);
        oldPost.setTitle(title);
        oldPost.setBody(body);
        postRepo.save(oldPost);

        return "redirect:/posts/" + id;
    }

    @PostMapping("/posts/{id}/delete")
    public String delete(@PathVariable long id) {
        postRepo.deleteById(id);
        return "redirect:/posts";
    }

    @GetMapping("/posts/create")
    public String showCreatePostForm(Model model){
        System.out.println("posts/create method");
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createNewPost(@ModelAttribute Post newPost) {
        Post savedPost = postRepo.save(newPost);
        System.out.println(savedPost.getId());

        return "redirect:/posts/" + savedPost.getId();
    }
}

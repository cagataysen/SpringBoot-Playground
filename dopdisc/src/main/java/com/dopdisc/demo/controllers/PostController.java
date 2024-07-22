package com.dopdisc.demo.controllers;

import com.dopdisc.demo.entities.Post;
import com.dopdisc.demo.entities.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {



    @GetMapping
    public String getAllPosts() {
        return "get all posts";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String getAllPostsBySpecificUser(@PathVariable int userId){
        return userId + ": extracted user id";
    }




}

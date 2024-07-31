package com.dopdisc.demo.controllers;

import com.dopdisc.demo.entities.Post;
import com.dopdisc.demo.entities.User;
import com.dopdisc.demo.requests.PostCreateRequest;
import com.dopdisc.demo.requests.PostUpdateRequest;
import com.dopdisc.demo.services.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {

    private PostService postService;

    public PostController(PostService postService){
        this.postService = postService;
    }

//    @GetMapping
//    public List<Post> getAllPosts() {
//
//        return postService.getAllPosts();
//    }

    @GetMapping
    public List<Post> getAllPostsBySpecificUser(@RequestParam Optional<Long> userId) {
        return postService.getAllPostsBySpecificUser(userId);
    }

    @GetMapping("/{postId}")
    public Post getOnePost(@PathVariable Long postId){
        return postService.getOnePostById(postId);
    }

    @PostMapping
    public Post createOnePost(@RequestBody PostCreateRequest newPostRequest){
        return postService.createOnePost(newPostRequest);
    }

    @PutMapping("/{postId}")
    public Post updateOnePostById(@PathVariable Long postId, @RequestBody PostUpdateRequest updatePost){
        return postService.updateOnePostById(postId, updatePost);
    }

    @DeleteMapping("/{postId}")
    public void deleteOnePostById(@PathVariable Long postId){
        postService.deleteById(postId);
    }

}

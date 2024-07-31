package com.dopdisc.demo.services;

import com.dopdisc.demo.entities.Post;
import com.dopdisc.demo.entities.User;
import com.dopdisc.demo.repositories.PostRepository;
import com.dopdisc.demo.repositories.UserRepository;
import com.dopdisc.demo.requests.PostCreateRequest;
import com.dopdisc.demo.requests.PostUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private PostRepository postRepository;

    private UserService userService;

    PostService(PostRepository postRepository, UserService userService){
        this.postRepository = postRepository;
        this.userService = userService;
    }


    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public List<Post> getAllPostsBySpecificUser(Optional<Long> userId) {
        if(userId.isPresent()){
            return postRepository.findByUserId(userId.get());
        }
        return postRepository.findAll();

    }


    public Post getOnePostById(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }


    public Post createOnePost(PostCreateRequest newPostRequest) {
        User user = userService.getOneUserById(newPostRequest.getUserId());
        if(user == null){
            return null;
        }
        Post toSave = new Post();
        toSave.setId(newPostRequest.getId());
        toSave.setText(newPostRequest.getText());
        toSave.setTitle(newPostRequest.getTitle());
        toSave.setDate(new Date());

        return postRepository.save(toSave);
    }


    public Post updateOnePostById(Long postId, PostUpdateRequest updatePost) {
        Optional<Post> post = postRepository.findById(postId);

        if(post.isPresent()){
            Post toUpdate = post.get();
            toUpdate.setText(updatePost.getText());
            toUpdate.setTitle(updatePost.getTitle());
            postRepository.save(toUpdate);
            return toUpdate;
        }

        return null;

    }

    public void deleteById(Long postId) {
        postRepository.deleteById(postId);
    }

}

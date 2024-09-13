package com.example.demo.controllers;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserContoller {

    @Autowired
    UserRepository userRepository;

    @PostConstruct
    public void init(){
        User user1 = new User();

        user1.setUserId("1");
        user1.setUserName("Cagatay Sen");
        user1.setUserPwd("123abc");

        HashMap<Integer, String> title = new HashMap<>();
        title.put(1, "admin");
        user1.setUserTitle(title);

        userRepository.save(user1);

    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        return ResponseEntity.ok(userRepository.save(user));
    }

    @GetMapping
    public ResponseEntity<List<User>> fetchAllUserList(){
        return ResponseEntity.ok(userRepository.findAll());
    }


}

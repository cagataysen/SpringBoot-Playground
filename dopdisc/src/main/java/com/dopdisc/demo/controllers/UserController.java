package com.dopdisc.demo.controllers;

import com.dopdisc.demo.entities.User;
import com.dopdisc.demo.repositories.UserRepository;
import com.dopdisc.demo.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    UserService userService;

    public UserController (UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("{userId}")
    public User getOneUserById(Long userId){
        return userService.getOneUserById(userId);
    }

    @PostMapping
    public User createUser(@RequestBody User newUser){
        return  userService.saveOneUser(newUser);
    }

    @PutMapping("/{userId}")
    public User updateOneUser(@PathVariable Long userId, @RequestBody User newUser){
        return userService.updateOneUser(userId, newUser);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteById(userId);
    }

}

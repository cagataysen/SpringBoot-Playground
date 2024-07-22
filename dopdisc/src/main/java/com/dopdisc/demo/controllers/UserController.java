package com.dopdisc.demo.controllers;

import com.dopdisc.demo.entities.User;
import com.dopdisc.demo.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    UserRepository userRepository;

    public UserController (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/id")
    @ResponseBody
    public String getUser(@PathVariable long id){
        return "User received" + id;
    }

    @PostMapping
    @ResponseBody
    public User createUser(@RequestBody User newUser){
        return  userRepository.save(newUser);
    }

    @PutMapping
    @ResponseBody
    public String updateUser(@PathVariable int id, @RequestBody User user){
        return "User updated: " + user.getName();
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteUser(@PathVariable int id) {
        // Logic to delete user with the given ID
        return "User deleted: " + id;
    }

}

package com.dopdisc.demo.services;

import com.dopdisc.demo.entities.User;
import com.dopdisc.demo.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getOneUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }


    public User saveOneUser(User newUser) {
        return userRepository.save(newUser);
    }

    public User updateOneUser(Long userId, User newUser) {
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()){
            User foundUser = user.get();
            foundUser.setUsername(newUser.getUsername());
            foundUser.setPwd(newUser.getPwd());
            userRepository.save(foundUser);
            return foundUser;
        }
        else{
            return null;
        }
    }

    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }


}

package com.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.model.User;
import com.hospital.repository.UserRepository;
 
@RestController
@CrossOrigin("*")
public class AppController {
 
    @Autowired
    private UserRepository userRepo;
     
    @GetMapping(path = "/userDetails", produces=MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<User> findAllUserDetails() {
        return userRepo.findAll();
    }

    @PostMapping("/saveUser" )
    public User saveUser(@RequestBody User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        User userresp = userRepo.save(user);
        return userresp;
    }
}

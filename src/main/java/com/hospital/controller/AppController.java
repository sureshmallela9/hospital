package com.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.model.User;
import com.hospital.repository.UserRepository;
 
@RestController
public class AppController {
 
    @Autowired
    private UserRepository userRepo;
     
    @GetMapping(path = "/userDetails", produces=MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<User> viewHomePage() {
    	System.out.println("Test");
        return userRepo.findAll();
    }

    @PostMapping("/register" )
    public String processRegister(User user) {
       BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
       String encodedPassword = passwordEncoder.encode(user.getPassword());
       user.setPassword(encodedPassword);
       userRepo.save(user);
       return "register_success";
    }
}

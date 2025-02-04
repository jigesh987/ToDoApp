package com.todoapp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.todoapp.entity.User;
import com.todoapp.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    
    // Handle Registration
    @PostMapping("/register")
    public String register(@RequestBody User user) {
        return userService.registerUser(user.getUsername(), user.getPassword());
        
       
    }

    // Handle Login
    @GetMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        Optional<User> user = userService.loginUser(username,password);
        if (user.isPresent()) {
            return "user logged in ";
           // return "redirect:/profile";  // ✅ Redirect to profile.jsp
        } 
        return "username or password maybe wrong";
       }


}

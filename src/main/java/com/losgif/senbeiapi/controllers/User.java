package com.losgif.senbeiapi.controllers;

import com.losgif.senbeiapi.requests.LoginRequest;
import com.losgif.senbeiapi.requests.RegisterRequest;
import com.losgif.senbeiapi.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class User {
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/login")
    String login(@RequestBody LoginRequest request) {
        try {
           userService.login(request.getEmail(), request.getPassword());
        } catch (Exception e) {
            return e.getMessage();
        }

        return "Login successful";
    }

    @RequestMapping("/register")
    String register(@RequestBody RegisterRequest request) {
        return "Register success";
    }
}

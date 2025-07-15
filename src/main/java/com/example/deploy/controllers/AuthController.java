package com.example.deploy.controllers;

import com.example.deploy.models.*;
import com.example.deploy.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private AuthService svc;
    @GetMapping("/home")
    public String home() {
        return "Welcome to home for Spring backend deployment";
    }
    @PostMapping("/register")
    public String register(@RequestBody UserDetailsDto dto) {
        return svc.register(dto);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest req) {
        return svc.login(req);
    }
}

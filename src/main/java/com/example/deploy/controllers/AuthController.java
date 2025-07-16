package com.example.deploy.controllers;

import com.example.deploy.Models.JwtResponse;
import com.example.deploy.Models.LoginRequest;
import com.example.deploy.Models.RegisterDetails;
import com.example.deploy.Models.UserDetailsDto;
import com.example.deploy.Repository.RegisterDetailsRepository;
import com.example.deploy.Services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthService authService;

    @PostMapping("/register")
    public String addNewUser(@RequestBody UserDetailsDto registerDetails){
        authService.addNewEmployee(registerDetails);
        return "Employee Register Successfully";
    }

    @PostMapping("/login")
    public JwtResponse Login(@RequestBody LoginRequest login) {
        return authService.authenticate(login);
    }

}
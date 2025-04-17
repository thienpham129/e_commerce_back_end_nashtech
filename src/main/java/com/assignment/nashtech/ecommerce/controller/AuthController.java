package com.assignment.nashtech.ecommerce.controller;

import com.assignment.nashtech.ecommerce.dto.UserLoginDTO;
import com.assignment.nashtech.ecommerce.dto.UserRegisterDTO;
import com.assignment.nashtech.ecommerce.model.User;
import com.assignment.nashtech.ecommerce.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid UserRegisterDTO userRegisterDTO){
        System.out.println("Received password: " + userRegisterDTO.getPassword());
        if (userRegisterDTO.getPassword() == null){
            throw new IllegalArgumentException("Password ís null");
        }
        User user = userService.register(userRegisterDTO);
        return ResponseEntity.ok("User registered successfully " + user.getUserName());
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLoginDTO userLoginDTO){
        boolean isAuthenticated = userService.authenticate(userLoginDTO);
        if (isAuthenticated){
            return ResponseEntity.ok("Login successfully");
        }else {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }
}

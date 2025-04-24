package com.assignment.nashtech.ecommerce.controller;

import com.assignment.nashtech.ecommerce.exception.RoleNotFoundException;
import com.assignment.nashtech.ecommerce.exception.UserAlreadyExistsException;
import com.assignment.nashtech.ecommerce.request.SignInRequestDto;
import com.assignment.nashtech.ecommerce.request.SignUpRequestDto;
import com.assignment.nashtech.ecommerce.response.ApiResponseDto;
import com.assignment.nashtech.ecommerce.response.SignInResponseDto;
import com.assignment.nashtech.ecommerce.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/sign-up")
    public ResponseEntity<ApiResponseDto<?>> registerUser(@RequestBody @Valid SignUpRequestDto signUpRequestDto) throws UserAlreadyExistsException, RoleNotFoundException {
        return authService.signUp(signUpRequestDto);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<ApiResponseDto<?>> signInUser(@RequestBody @Valid SignInRequestDto signInRequestDto){
        return authService.signIn(signInRequestDto);
    }
}

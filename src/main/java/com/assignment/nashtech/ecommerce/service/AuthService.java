package com.assignment.nashtech.ecommerce.service;

import com.assignment.nashtech.ecommerce.request.SignInRequestDto;
import com.assignment.nashtech.ecommerce.response.SignInResponseDto;
import com.assignment.nashtech.ecommerce.exception.RoleNotFoundException;
import com.assignment.nashtech.ecommerce.exception.UserAlreadyExistsException;
import com.assignment.nashtech.ecommerce.request.SignUpRequestDto;
import com.assignment.nashtech.ecommerce.response.ApiResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    ResponseEntity<ApiResponseDto<?>> signUp(SignUpRequestDto request) throws UserAlreadyExistsException, RoleNotFoundException;

    ResponseEntity<ApiResponseDto<?>> signIn(SignInRequestDto signInRequestDto);
}

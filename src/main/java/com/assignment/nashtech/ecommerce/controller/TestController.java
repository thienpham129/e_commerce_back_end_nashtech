package com.assignment.nashtech.ecommerce.controller;

import com.assignment.nashtech.ecommerce.enums.ResponseStatus;
import com.assignment.nashtech.ecommerce.response.ApiResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping()
    public ResponseEntity<ApiResponseDto<?>> test(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponseDto.builder()
                        .status(String.valueOf(ResponseStatus.SUCCESS))
                        .message(("Securing Spring Boot using Spring Security"))
                        .build());
    }
}

package com.assignment.nashtech.ecommerce.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SignInResponseDto {
    private String token;
    private String type = "Bearer ";
    private int id;
    private String userName;
    private String email;
    private List<String> roles;
}

package com.assignment.nashtech.ecommerce.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequestDto {

    @NotBlank(message = "Username is required!")
    @Size(min = 3, message = "Username must have at least 3 character!")
    @Size(max = 20, message = "Username must have almost 20 character!")
    private String userName;

    @Email(message = "Email is not in valid format!")
    @NotBlank(message = "Email is required!")
    private String email;

    @NotBlank(message = "Password is required!")
    @Size(min = 8, message = "Password must have at least 8 characters!")
    @Size(max = 20, message = "Password can have almost 20 characters!")
    private String password;

    private Set<String> roles;
}

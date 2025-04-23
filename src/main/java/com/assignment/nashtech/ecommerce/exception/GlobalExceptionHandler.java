package com.assignment.nashtech.ecommerce.exception;

import com.assignment.nashtech.ecommerce.enums.ResponseStatus;
import com.assignment.nashtech.ecommerce.response.ApiResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFound(ResourceNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserRegistrationException.UsernameAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleUserNameExists(UserRegistrationException.UsernameAlreadyExistsException exception) {
        Map<String, String> error = new HashMap<>();
        error.put("error", exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(UserRegistrationException.EmailAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleEmailExists(UserRegistrationException.EmailAlreadyExistsException exception) {
        Map<String, String> error = new HashMap<>();
        error.put("error", exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponseDto<?>> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception) {
        List<String> errorMessage = new ArrayList<>();

        exception.getBindingResult().getFieldErrors().forEach(error -> {
            errorMessage.add(error.getDefaultMessage());
        });

        return ResponseEntity
                .badRequest()
                .body(
                        ApiResponseDto.builder()
                                .status(String.valueOf(ResponseStatus.FAIL))
                                .message("Registration Failed: Please provide valid data.")
                                .response(errorMessage)
                                .build()
                );
    }

    @ExceptionHandler(value = UserAlreadyExistsException.class)
    public ResponseEntity<ApiResponseDto<?>> UserAlreadyExistsExceptionHandler(UserAlreadyExistsException exception) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(
                        ApiResponseDto.builder()
                                .status(String.valueOf(ResponseStatus.FAIL))
                                .message(exception.getMessage())
                                .build()
                );
    }

    @ExceptionHandler(value = RoleNotFoundException.class)
    public ResponseEntity<ApiResponseDto<?>> RoleNotFoundExceptionHandler(RoleNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(
                        ApiResponseDto.builder()
                                .status(String.valueOf(ResponseStatus.FAIL))
                                .message(exception.getMessage())
                                .build()
                );
    }
}

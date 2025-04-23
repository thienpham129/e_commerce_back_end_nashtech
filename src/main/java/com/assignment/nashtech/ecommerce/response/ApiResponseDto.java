package com.assignment.nashtech.ecommerce.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponseDto<T> {
    private String status;
    private String message;
    private T response;
}

package com.assignment.nashtech.ecommerce.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReviewResponseDto {
    private int id;
    private int userId;
    private int rating;
    private String userName;
    private String comment;
}

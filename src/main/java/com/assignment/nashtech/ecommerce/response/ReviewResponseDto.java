package com.assignment.nashtech.ecommerce.response;

import com.assignment.nashtech.ecommerce.model.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewResponseDto {
    private int id;
    private int userId;
    private int productId;
    private int rating;
    private String userName;
    private String comment;

    public ReviewResponseDto(Review review) {
        this.id = review.getReviewId();
        this.userId = review.getUser().getUserId();
        this.productId = review.getProduct().getProductId();
        this.rating = review.getRating();
        this.comment = review.getComment();
        this.userName = review.getUser().getUserName();
    }
}

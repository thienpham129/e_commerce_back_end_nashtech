package com.assignment.nashtech.ecommerce.dto;

public class UserReviewDTO {
    private Integer productId;
    private Integer rating;
    private String comment;

    public UserReviewDTO() {
    }

    public UserReviewDTO(Integer productId, Integer rating, String comment) {
        this.productId = productId;
        this.rating = rating;
        this.comment = comment;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

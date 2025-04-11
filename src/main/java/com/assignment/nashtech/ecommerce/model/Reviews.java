package com.assignment.nashtech.ecommerce.model;

import java.time.LocalDateTime;

public class Reviews {
    private int review_id;
    private int user_id;
    private int product_id;
    private int rating;
    private String comment;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public Reviews() {
    }

    public Reviews(int review_id, int user_id, int product_id, int rating, String comment, LocalDateTime created_at, LocalDateTime updated_at) {
        this.review_id = review_id;
        this.user_id = user_id;
        this.product_id = product_id;
        this.rating = rating;
        this.comment = comment;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getReview_id() {
        return review_id;
    }

    public void setReview_id(int review_id) {
        this.review_id = review_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "Reviews{" +
                "review_id=" + review_id +
                ", user_id=" + user_id +
                ", product_id=" + product_id +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}

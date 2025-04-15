package com.assignment.nashtech.ecommerce.service;

import com.assignment.nashtech.ecommerce.dto.ReviewDTO;
import com.assignment.nashtech.ecommerce.model.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    List<Review> getAllReview();

    Optional<Review> getReviewById(int reviewId);

    Review saveReview(ReviewDTO reviewDTO);

    Review updateReviewById(int reviewId, ReviewDTO reviewDTO);

    void deleteReviewById(int reviewId);
}

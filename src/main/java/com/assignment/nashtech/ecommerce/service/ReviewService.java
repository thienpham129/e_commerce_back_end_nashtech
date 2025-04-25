package com.assignment.nashtech.ecommerce.service;

import com.assignment.nashtech.ecommerce.dto.ReviewDTO;
import com.assignment.nashtech.ecommerce.model.Review;
import com.assignment.nashtech.ecommerce.model.User;
import com.assignment.nashtech.ecommerce.request.ReviewRequestDto;
import com.assignment.nashtech.ecommerce.response.ReviewResponseDto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    List<Review> getAllReview();

    Optional<Review> getReviewById(int reviewId);

    List<Review> saveAllReviews(List<ReviewDTO> reviewDTOs);

    Review saveReview(ReviewDTO reviewDTO);

    Review updateReviewById(int reviewId, ReviewDTO reviewDTO);

    void deleteReviewById(int reviewId);

    ReviewResponseDto createOrUpdate(int productId, ReviewRequestDto dto);

    void delete(int reviewId);

    List<ReviewResponseDto> listByProduct(int productId);

    Page<ReviewResponseDto> listByProductWithPagination(int productId, int page, int size);
}

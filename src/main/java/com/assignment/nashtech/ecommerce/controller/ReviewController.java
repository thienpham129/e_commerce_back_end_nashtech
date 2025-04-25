package com.assignment.nashtech.ecommerce.controller;

import com.assignment.nashtech.ecommerce.dto.ReviewDTO;
import com.assignment.nashtech.ecommerce.exception.ResourceNotFoundException;
import com.assignment.nashtech.ecommerce.model.Review;
import com.assignment.nashtech.ecommerce.model.User;
import com.assignment.nashtech.ecommerce.request.ReviewRequestDto;
import com.assignment.nashtech.ecommerce.response.ReviewResponseDto;
import com.assignment.nashtech.ecommerce.service.ReviewService;
import com.assignment.nashtech.ecommerce.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<Review> getAllReview() {
        return reviewService.getAllReview();
    }

    @GetMapping("/{reviewId}")
    public Optional<Review> getReviewById(@PathVariable int reviewId) {
        return reviewService.getReviewById(reviewId);
    }

    @PostMapping("/")
    public Review createReview(@RequestBody ReviewDTO reviewDTO) {
        return reviewService.saveReview(reviewDTO);
    }

    @PostMapping("/saveAllReviews")
    public List<Review> createMultipleReviews(@RequestBody List<ReviewDTO> reviewDTOs) {
        return reviewService.saveAllReviews(reviewDTOs);
    }

    @PutMapping("/user/{reviewId}")
    public Review UpdateReviewById(@PathVariable int reviewId, @RequestBody ReviewDTO reviewDTO) {
        return reviewService.updateReviewById(reviewId, reviewDTO);
    }

    @DeleteMapping("/{reviewId}")
    public void deleteReviewById(@PathVariable int reviewId) {
        reviewService.deleteReviewById(reviewId);
    }

    @PostMapping("/user/{productId}")
    @PreAuthorize("isAuthenticated()")
    public ReviewResponseDto addOrUpdate(@PathVariable int productId, @RequestBody @Valid ReviewRequestDto dto) {
        return reviewService.createOrUpdate(productId, dto);
    }

    @DeleteMapping("/user/{reviewId}")
    @PreAuthorize("isAuthenticated()")
    public void delete(@PathVariable int reviewId){
        reviewService.delete(reviewId);
    }

    @GetMapping("/public/user/product/{productId}")
    public List<ReviewResponseDto> list(@PathVariable int productId){
        return reviewService.listByProduct(productId);
    }
}

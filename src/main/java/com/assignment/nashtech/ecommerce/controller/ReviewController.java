package com.assignment.nashtech.ecommerce.controller;

import com.assignment.nashtech.ecommerce.dto.ReviewDTO;
import com.assignment.nashtech.ecommerce.model.Review;
import com.assignment.nashtech.ecommerce.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

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

    @PutMapping("/{reviewId}")
    public Review UpdateReviewById(@PathVariable int reviewId, @RequestBody ReviewDTO reviewDTO) {
        return reviewService.updateReviewById(reviewId, reviewDTO);
    }

    @DeleteMapping("/{reviewId}")
    public void deleteReviewById(@PathVariable int reviewId) {
        reviewService.deleteReviewById(reviewId);
    }
}

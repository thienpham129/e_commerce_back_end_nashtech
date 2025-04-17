package com.assignment.nashtech.ecommerce.implement;

import com.assignment.nashtech.ecommerce.dto.ReviewDTO;
import com.assignment.nashtech.ecommerce.exception.ResourceNotFoundException;
import com.assignment.nashtech.ecommerce.model.Product;
import com.assignment.nashtech.ecommerce.model.Review;
import com.assignment.nashtech.ecommerce.model.User;
import com.assignment.nashtech.ecommerce.repository.ProductRepository;
import com.assignment.nashtech.ecommerce.repository.ReviewRepository;
import com.assignment.nashtech.ecommerce.repository.UserRepository;
import com.assignment.nashtech.ecommerce.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewImpl implements ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Review> getAllReview() {
        return reviewRepository.findAll();
    }

    @Override
    public Optional<Review> getReviewById(int reviewId) {
        return reviewRepository.findById(reviewId);
    }

    @Override
    public List<Review> saveAllReviews(List<ReviewDTO> reviewDTOs) {
        List<Review> reviews = new ArrayList<>();

        for (ReviewDTO reviewDTO : reviewDTOs) {
            User user = userRepository.findById(reviewDTO.getUserId()).orElseThrow(() -> new ResourceNotFoundException("User not Found"));
            Product product = productRepository.findById(reviewDTO.getProductId()).orElseThrow(() -> new ResourceNotFoundException("Product not Found"));

            Review review = new Review();
            review.setUser(user);
            review.setProduct(product);
            review.setRating(reviewDTO.getRating());
            review.setComment(reviewDTO.getComment());

            reviews.add(review);
        }
        return reviewRepository.saveAll(reviews);
    }

    @Override
    public Review saveReview(ReviewDTO reviewDTO) {
        User user = userRepository.findById(reviewDTO.getUserId()).orElseThrow(() -> new RuntimeException("User Not Found"));
        Product product = productRepository.findById(reviewDTO.getProductId()).orElseThrow(() -> new RuntimeException("Product not Found"));

        Review review = new Review();
        review.setUser(user);
        review.setProduct(product);
        review.setRating(reviewDTO.getRating());
        review.setComment(reviewDTO.getComment());

        return reviewRepository.save(review);
    }

    @Override
    public Review updateReviewById(int reviewId, ReviewDTO reviewDTO) {
        Optional<Review> reviewExisting = reviewRepository.findById(reviewId);
        User user = userRepository.findById(reviewDTO.getUserId()).orElseThrow(() -> new RuntimeException("User not Found"));
        Product product = productRepository.findById(reviewDTO.getProductId()).orElseThrow(() -> new RuntimeException("Product not Found"));

        if (reviewExisting.isPresent()) {
            Review r = reviewExisting.get();
            r.setUser(user);
            r.setProduct(product);
            r.setRating(reviewDTO.getRating());
            r.setComment(reviewDTO.getComment());
            return reviewRepository.save(r);
        }
        return null;
    }

    @Override
    public void deleteReviewById(int reviewId) {
        reviewRepository.deleteById(reviewId);
    }
}

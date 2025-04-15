package com.assignment.nashtech.ecommerce.repository;

import com.assignment.nashtech.ecommerce.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}

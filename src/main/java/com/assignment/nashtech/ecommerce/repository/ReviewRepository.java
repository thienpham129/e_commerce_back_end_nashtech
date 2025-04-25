package com.assignment.nashtech.ecommerce.repository;

import com.assignment.nashtech.ecommerce.model.Product;
import com.assignment.nashtech.ecommerce.model.Review;
import com.assignment.nashtech.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    @Query("SELECT r.product.id, AVG(r.rating) FROM Review r GROUP BY product.id")
    List<Object[]> findAverageRatingForProducts();

    @Query("SELECT AVG(r.rating) FROM Review r WHERE r.product.id = :productId")
    Double findAverageRatingsByProductId(@Param("productId")Integer productId);

    Optional<Review> findByUserAndProduct(User user, Product product);

    Optional<Review> findByUserUserIdAndProductProductId(int userId, int productId);
    List<Review> findByProductProductId(int productId);
}

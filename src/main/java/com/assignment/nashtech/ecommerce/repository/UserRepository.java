package com.assignment.nashtech.ecommerce.repository;

import com.assignment.nashtech.ecommerce.model.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsByUserName(@NotNull @Size(max = 256) String userName);

    boolean existsByEmail(@NotNull @Size(max = 256) String email);

    Optional<User> findByUserName(String userName);

    Optional<User> findByEmail(String email);
}

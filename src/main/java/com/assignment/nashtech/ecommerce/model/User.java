package com.assignment.nashtech.ecommerce.model;

import com.assignment.nashtech.ecommerce.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @NotNull
    @Size(max = 256)
    @Column(name = "username", nullable = false, length = 256)
    private String userName;

    @NotNull
    @Size(max = 256)
    @Column(name = "email", nullable = false, length = 256)
    private String email;

    @Size(max = 256)
    @Column(name = "first_name", length = 256)
    private String firstName;

    @Size(max = 256)
    @Column(name = "last_name", length = 256)
    private String lastName;

    @Past(message = "Birth date must be in the pass")
    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private UserRole userRole;

    @Column(name = "avatar_url")
    private String avatarUrl;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Review> userReviews = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> userOrders = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<AddToCart> userAddToCarts = new ArrayList<>();

    public User() {
    }

    public User(int userId, String userName, String email, String firstName, String lastName, LocalDate birthDate, UserRole userRole, String avatarUrl, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.userRole = userRole;
        this.avatarUrl = avatarUrl;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public User(int userId, String userName, String email, String firstName, String lastName, LocalDate birthDate, UserRole userRole, String avatarUrl, LocalDateTime createdAt, LocalDateTime updatedAt, List<Review> userReviews, List<Order> userOrders, List<AddToCart> userAddToCarts) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.userRole = userRole;
        this.avatarUrl = avatarUrl;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.userReviews = userReviews;
        this.userOrders = userOrders;
        this.userAddToCarts = userAddToCarts;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public @NotNull @Size(max = 256) String getUserName() {
        return userName;
    }

    public void setUserName(@NotNull @Size(max = 256) String userName) {
        this.userName = userName;
    }

    public @NotNull @Size(max = 256) String getEmail() {
        return email;
    }

    public void setEmail(@NotNull @Size(max = 256) String email) {
        this.email = email;
    }

    public @Size(max = 256) String getFirstName() {
        return firstName;
    }

    public void setFirstName(@Size(max = 256) String firstName) {
        this.firstName = firstName;
    }

    public @Size(max = 256) String getLastName() {
        return lastName;
    }

    public void setLastName(@Size(max = 256) String lastName) {
        this.lastName = lastName;
    }

    public @Past(message = "Birth date must be in the pass") LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(@Past(message = "Birth date must be in the pass") LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Review> getUserReviews() {
        return userReviews;
    }

    public void setUserReviews(List<Review> userReviews) {
        this.userReviews = userReviews;
    }

    public List<Order> getUserOrders() {
        return userOrders;
    }

    public void setUserOrders(List<Order> userOrders) {
        this.userOrders = userOrders;
    }

    public List<AddToCart> getUserAddToCarts() {
        return userAddToCarts;
    }

    public void setUserAddToCarts(List<AddToCart> userAddToCarts) {
        this.userAddToCarts = userAddToCarts;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", userRole=" + userRole +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", userReviews=" + userReviews +
                ", userOrders=" + userOrders +
                ", userAddToCarts=" + userAddToCarts +
                '}';
    }
}

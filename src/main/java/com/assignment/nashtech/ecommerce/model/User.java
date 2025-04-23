package com.assignment.nashtech.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "Users")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @NotNull
    @Size(max = 256)
    @Column(name = "username", nullable = false, length = 256)
    private String userName = "User";

    @NotNull
    @Size(max = 256)
    @Column(name = "email", nullable = false, length = 256)
    private String email;

    @NotNull
    @Size(max = 256)
    @Column(name = "password", nullable = false, length = 256)
    private String password;

    @Size(max = 256)
    @Column(name = "first_name", length = 256)
    private String firstName;

    @Size(max = 256)
    @Column(name = "last_name", length = 256)
    private String lastName;

    @Past(message = "Birth date must be in the pass")
    @Column(name = "birth_date")
    private LocalDate birthDate;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> userRole = new HashSet<>();

    @Column(name = "avatar_url")
    private String avatarUrl;

    private boolean enabled;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Review> userReviews = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Order> userOrders = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<AddToCart> userAddToCarts = new ArrayList<>();
}

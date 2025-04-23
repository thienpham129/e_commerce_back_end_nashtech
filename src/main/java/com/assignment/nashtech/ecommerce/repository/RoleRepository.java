package com.assignment.nashtech.ecommerce.repository;

import com.assignment.nashtech.ecommerce.enums.UserRole;
import com.assignment.nashtech.ecommerce.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(UserRole name);
}

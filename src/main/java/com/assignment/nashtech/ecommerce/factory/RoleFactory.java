package com.assignment.nashtech.ecommerce.factory;

import com.assignment.nashtech.ecommerce.enums.UserRole;
import com.assignment.nashtech.ecommerce.exception.RoleNotFoundException;
import com.assignment.nashtech.ecommerce.model.Role;
import com.assignment.nashtech.ecommerce.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleFactory {
    @Autowired
    RoleRepository roleRepository;

    public Role getInstance(String role) throws RoleNotFoundException {
        switch (role) {
            case "Admin" -> {
                return roleRepository.findByName(UserRole.Admin);
            }
            case "User" -> {
                return roleRepository.findByName(UserRole.User);
            }
            default -> throw new RoleNotFoundException("Role not found for " + role);
        }
    }
}

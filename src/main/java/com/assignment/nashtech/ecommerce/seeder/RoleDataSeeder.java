package com.assignment.nashtech.ecommerce.seeder;

import com.assignment.nashtech.ecommerce.enums.UserRole;
import com.assignment.nashtech.ecommerce.model.Role;
import com.assignment.nashtech.ecommerce.repository.RoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class RoleDataSeeder {
    @Autowired
    RoleRepository roleRepository;

    @EventListener
    @Transactional
    public void loadRoles(ContextRefreshedEvent event){
        List<UserRole> roles = Arrays.stream(UserRole.values()).toList();

        for (UserRole userRole: roles){
            if (roleRepository.findByName(userRole) == null){
                roleRepository.save(new Role(userRole));
            }
        }
    }
}

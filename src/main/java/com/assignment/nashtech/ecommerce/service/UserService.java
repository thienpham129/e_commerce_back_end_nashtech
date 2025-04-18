package com.assignment.nashtech.ecommerce.service;

import com.assignment.nashtech.ecommerce.dto.UserLoginDTO;
import com.assignment.nashtech.ecommerce.dto.UserRegisterDTO;
import com.assignment.nashtech.ecommerce.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(int userId);

    User saveUser(User user);

    User updateUserById(int userId, User user);

    void deleteUserById(int userId);

    User register(UserRegisterDTO userRegisterDTO);

    boolean authenticate(UserLoginDTO userLoginDTO);

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}

package com.assignment.nashtech.ecommerce.service;

import com.assignment.nashtech.ecommerce.dto.UserRegisterDTO;
import com.assignment.nashtech.ecommerce.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(int userId);

    User saveUser(User user);

    User updateUserById(int userId, User user);

    void deleteUserById(int userId);

    User register(UserRegisterDTO userRegisterDTO);
}

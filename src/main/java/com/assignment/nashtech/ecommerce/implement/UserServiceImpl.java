package com.assignment.nashtech.ecommerce.implement;

import com.assignment.nashtech.ecommerce.exception.ResourceNotFoundException;
import com.assignment.nashtech.ecommerce.model.User;
import com.assignment.nashtech.ecommerce.repository.UserRepository;
import com.assignment.nashtech.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int userId) {
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not exist with id: " + userId));
    }

    @Override
    public User saveUser(User user) {
        if (userRepository.existsByUserName(user.getUserName())) {
            throw new RuntimeException("Username already exists");
        }
        return userRepository.save(user);
    }

    /**
     * @param userId
     * @param user
     * @return <p>Optional chỉ chứa được một Object bên trong</p>
     */

    @Override
    public User updateUserById(int userId, User user) {
        Optional<User> userExisting = userRepository.findById(userId);
        if (userExisting.isPresent()) {
            User u = userExisting.get();
            u.setUserName(user.getUserName());
            u.setEmail(user.getEmail());
            u.setFirstName(user.getFirstName());
            u.setLastName(user.getLastName());
            u.setBirthDate(user.getBirthDate());
            u.setUserRole(user.getUserRole());
            u.setAvatarUrl(user.getAvatarUrl());
            u.setUpdatedAt(user.getUpdatedAt());
            return userRepository.save(u);
        }
        return null;
    }

    @Override
    public void deleteUserById(int userId) {
        userRepository.deleteById(userId);
    }
}

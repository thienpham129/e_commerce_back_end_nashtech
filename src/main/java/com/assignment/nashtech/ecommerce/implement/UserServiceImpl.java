package com.assignment.nashtech.ecommerce.implement;

import com.assignment.nashtech.ecommerce.exception.ResourceNotFoundException;
import com.assignment.nashtech.ecommerce.model.User;
import com.assignment.nashtech.ecommerce.repository.UserRepository;
import com.assignment.nashtech.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private PasswordEncoderConfiguration passwordEncoderConfiguration;

//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int userId) {
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not exist with id: " + userId));
    }

    @Override
    public Optional<User> findByUserName(String username) {
        return userRepository.findByUserName(username);
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
            u.setPassword(user.getPassword());
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

//    @Override
//    public User register(UserRegisterDTO userRegisterDTO) {
//        if (userRepository.findByUserName(userRegisterDTO.getUsername()).isPresent()) {
//            throw new UserRegistrationException.UsernameAlreadyExistsException(userRegisterDTO.getUsername());
//        }
//        if (userRepository.findByEmail(userRegisterDTO.getEmail()).isPresent()) {
//            throw new UserRegistrationException.EmailAlreadyExistsException(userRegisterDTO.getEmail());
//        }
//        User user = new User();
//        user.setUserName(userRegisterDTO.getUsername());
//        user.setEmail(userRegisterDTO.getEmail());
//        user.setPassword(passwordEncoderConfiguration.passwordEncoder().encode(userRegisterDTO.getPassword()));
//        return userRepository.save(user);
//    }
//
//    @Override
//    public boolean authenticate(UserLoginDTO userLoginDTO) {
//        User user = userRepository.findByUserName(userLoginDTO.getUsername()).orElseThrow(() -> new ResourceNotFoundException(userLoginDTO.getUsername() + " not Found"));
//
//        return passwordEncoder.matches(userLoginDTO.getPassword(), user.getPassword());
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUserName(username)
//                .orElseThrow(() -> new ResourceNotFoundException("User not Found"));
//
//        return new org.springframework.security.core.userdetails.User(
//                user.getUserName(),
//                user.getPassword(),
//                new ArrayList<>()
//        );
//    }

    @Override
    public boolean existByUserName(String userName) {
        return userRepository.existsByUserName(userName);
    }

    @Override
    public boolean existByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}

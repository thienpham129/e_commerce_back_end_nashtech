package com.assignment.nashtech.ecommerce.controller;

import com.assignment.nashtech.ecommerce.dto.UserLoginDTO;
import com.assignment.nashtech.ecommerce.dto.UserRegisterDTO;
import com.assignment.nashtech.ecommerce.model.User;
import com.assignment.nashtech.ecommerce.repository.UserRepository;
import com.assignment.nashtech.ecommerce.response.JwtResponse;
import com.assignment.nashtech.ecommerce.service.UserService;
import com.assignment.nashtech.ecommerce.util.JwtUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid UserRegisterDTO userRegisterDTO) {
        System.out.println("Received password: " + userRegisterDTO.getPassword());
        if (userRegisterDTO.getPassword() == null) {
            throw new IllegalArgumentException("Password ís null");
        }
        User user = userService.register(userRegisterDTO);
        return ResponseEntity.ok("User registered successfully " + user.getUserName());
    }

    //    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody UserLoginDTO userLoginDTO){
//        boolean isAuthenticated = userService.authenticate(userLoginDTO);
//        if (isAuthenticated){
//            return ResponseEntity.ok("Login successfully");
//        }else {
//            return ResponseEntity.status(401).body("Invalid username or password");
//        }
//    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginDTO loginDTO) throws Exception {
        Optional<User> userOptional = userRepository.findByUserName(loginDTO.getUsername());
        if (userOptional.isEmpty() || !passwordEncoder.matches(loginDTO.getPassword(), userOptional.get().getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid User");
        }

        String token = jwtUtil.generateToken(loginDTO.getUsername());
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().invalidate();

        Cookie cookie = new Cookie("JSESSIONID", null);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        return "Logout successful";
    }
}

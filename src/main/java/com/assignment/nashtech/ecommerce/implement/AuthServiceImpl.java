package com.assignment.nashtech.ecommerce.implement;

import com.assignment.nashtech.ecommerce.configuration.util.JwtUtils;
import com.assignment.nashtech.ecommerce.model.UserDetailsImpl;
import com.assignment.nashtech.ecommerce.request.SignInRequestDto;
import com.assignment.nashtech.ecommerce.response.SignInResponseDto;
import com.assignment.nashtech.ecommerce.enums.ResponseStatus;
import com.assignment.nashtech.ecommerce.exception.RoleNotFoundException;
import com.assignment.nashtech.ecommerce.exception.UserAlreadyExistsException;
import com.assignment.nashtech.ecommerce.factory.RoleFactory;
import com.assignment.nashtech.ecommerce.model.Role;
import com.assignment.nashtech.ecommerce.model.User;
import com.assignment.nashtech.ecommerce.request.SignUpRequestDto;
import com.assignment.nashtech.ecommerce.response.ApiResponseDto;
import com.assignment.nashtech.ecommerce.service.AuthService;
import com.assignment.nashtech.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleFactory roleFactory;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public ResponseEntity<ApiResponseDto<?>> signUp(SignUpRequestDto signUpRequestDto) throws UserAlreadyExistsException, RoleNotFoundException {

        //(1)
        if (userService.existByEmail(signUpRequestDto.getEmail())) {
            throw new UserAlreadyExistsException("Registration Failed: Provided email already exists. Try sign in or provide another email.");
        }
        if (userService.existByUserName(signUpRequestDto.getUserName())) {
            throw new UserAlreadyExistsException("Registration Fail: Provided username already exists. Try sign in or provide another username.");
        }

        //(2)
        User user = createUser(signUpRequestDto);

        //(3)
        userService.save(user);

        //(4)
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponseDto.builder()
                        .status(String.valueOf(ResponseStatus.SUCCESS))
                        .message("User account has been successfully created!")
                        .build()
        );
    }

    @Override
    public ResponseEntity<ApiResponseDto<?>> signIn(SignInRequestDto signInRequestDto) {
        //(1)
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequestDto.getEmail(), signInRequestDto.getPassword()));

        //(2)
        SecurityContextHolder.getContext().setAuthentication(authentication);

        //(3)
        String jwt = jwtUtils.generateJwtToken(authentication);

        //(4)
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        //(5)
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        SignInResponseDto signInResponseDto = SignInResponseDto.builder()
                .userName(userDetails.getUsername())
                .email(userDetails.getEmail())
                .id(userDetails.getUserId())
                .token(jwt)
                .type("Bearer")
                .roles(roles)
                .build();

        return ResponseEntity.ok(
                ApiResponseDto.builder()
                        .status(String.valueOf(ResponseStatus.SUCCESS))
                        .message("Sign in successfull!")
                        .response(signInResponseDto)
                        .build());
    }

    private User createUser(SignUpRequestDto signUpRequestDto) throws RoleNotFoundException {
        return User.builder()
                .email(signUpRequestDto.getEmail())
                .userName(signUpRequestDto.getUserName())
                .password(passwordEncoder.encode(signUpRequestDto.getPassword()))
                .enabled(true)
                .userRole(determineRoles(signUpRequestDto.getRoles()))
                .build();
    }

    private Set<Role> determineRoles(Set<String> strRoles) throws RoleNotFoundException {
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            roles.add(roleFactory.getInstance("User"));
        } else {
            for (String role : strRoles) {
                roles.add(roleFactory.getInstance(role));
            }
        }
        return roles;
    }


}

package com.assignment.nashtech.ecommerce.exception;

public class UserRegistrationException {
    public static class UsernameAlreadyExistsException extends RuntimeException {
        public UsernameAlreadyExistsException(String username) {
            super("Username already exists: " + username);
        }
    }

    public static class EmailAlreadyExistsException extends RuntimeException {
        public EmailAlreadyExistsException(String email) {
            super("Email already exists: " + email);
        }
    }
}

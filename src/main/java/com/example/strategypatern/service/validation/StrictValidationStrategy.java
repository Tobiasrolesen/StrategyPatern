package com.example.strategypatern.service.validation;

import com.example.strategypatern.model.User;
import org.springframework.stereotype.Component;

@Component
public class StrictValidationStrategy implements ValidationStrategy{

    @Override
    public void validate(User user) {
        String username = user.getUsername();
        String email = user.getEmail();
        String password = user.getPassword();

        if (username == null || username.length() < 6 || username.contains(" ")){
            throw new ValidationException ("Username must be at least 6 characters long and contain no spaces");
        }

        if (password == null || password.length() < 10) {
            throw new ValidationException("Password must contain at least 10 characters");
        }
        if (!password.matches(".*[A-Za-z].*")) {
            throw new ValidationException("Password must include at least 1 letter");
        }
        if (!password.matches(".*\\d.*")) {
            throw new ValidationException("Password must include at least 1 number");
        }

        if (email == null || !email.matches("^[^@]+@[^@]+\\.[^@]+$")) {
            throw new ValidationException("Email needs to be in a legal format");
        }
    }
}

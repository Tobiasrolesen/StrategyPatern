package com.example.strategypatern.service.validation;

import com.example.strategypatern.model.User;
import org.springframework.stereotype.Component;

@Component
public class SimpleValidationStrategy implements ValidationStrategy{

    @Override
    public void validate(User user) {
        String username = user.getUsername();
        String email = user.getEmail();
        String password = user.getPassword();

        if (username == null || username.length() < 3){
            throw new ValidationException("Username needs to be longer than 3 characters");
        }

        if (password == null || password.length() < 6){
            throw new ValidationException("Password needs to be longer than 6 characters");
        }

        if (email == null || !email.contains("@") || !email.contains(".")){
            throw new ValidationException ("Email must contain @ and .");
        }
    }
}



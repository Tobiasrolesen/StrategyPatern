package com.example.strategypatern.service;

import com.example.strategypatern.model.User;
import com.example.strategypatern.service.validation.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RegistrationService {

    private final List<User> users = new ArrayList<>();
    private final SimpleValidationStrategy simpleValidationStrategy;
    private final StrictValidationStrategy strictValidationStrategy;

    public RegistrationService(SimpleValidationStrategy simpleValidationStrategy, StrictValidationStrategy strictValidationStrategy) {
        this.simpleValidationStrategy = simpleValidationStrategy;
        this.strictValidationStrategy = strictValidationStrategy;
    }

    public void validateUser(User user, ValidationMode mode) {
        ValidationStrategy strategy = selectStrategy(mode);
        strategy.validate(user);
    }

    public void saveUser (User user){
        users.add(user);
    }

    public List<User> getAllUsers(){
        return List.copyOf(users);
    }

    private ValidationStrategy selectStrategy(ValidationMode mode){
        if (mode == ValidationMode.STRICT) {
            return strictValidationStrategy;
        }
        return simpleValidationStrategy;
    }
}

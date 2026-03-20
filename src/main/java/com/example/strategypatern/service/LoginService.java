package com.example.strategypatern.service;

import com.example.strategypatern.model.User;
import com.example.strategypatern.service.validation.SimpleValidationStrategy;
import com.example.strategypatern.service.validation.StrictValidationStrategy;
import com.example.strategypatern.service.validation.ValidationMode;
import com.example.strategypatern.service.validation.ValidationStrategy;
import org.springframework.boot.autoconfigure.task.TaskExecutionProperties;

import java.util.ArrayList;
import java.util.List;

public class LoginService {

    private List<User> users = new ArrayList<>();
    private ValidationMode mode = ValidationMode.STRICT;

    //Valg af strategi
    private ValidationStrategy whichStrategy() {
        if (mode == ValidationMode.STRICT) {
            return new StrictValidationStrategy();
        }
        return new SimpleValidationStrategy();
    }

    public void validateUser(String fname, String password, String email){
        whichStrategy().validate(fname, password, email);
    }

    public User createUser(String fname, String password, String email){
        User user = new User(fname, password, email);
        users.add(user);

        return user;
    }
}

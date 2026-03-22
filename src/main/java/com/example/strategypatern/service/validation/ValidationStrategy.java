package com.example.strategypatern.service.validation;

import com.example.strategypatern.model.User;

public interface ValidationStrategy {
    void validate(User user);
}

package com.example.strategypatern.service.validation;

public interface ValidationStrategy {
    String validate(String fname, String password, String email);
}

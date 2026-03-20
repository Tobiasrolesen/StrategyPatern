package com.example.strategypatern.service.validation;

public class SimpleValidationStrategy implements ValidationStrategy{
    @Override
    public String validate(String fname, String password, String email) {

        if (fname == null || fname.length() < 3){
            throw new ValidationException("Username needs to be longer than 3 characters");
        }

        if (password == null || password.length() < 6){
            throw new ValidationException("Password needs to be longer than 6 characters");
        }

        if (email == null || !email.contains("@") || !email.contains(".")){
            throw new ValidationException ("Email must contain @ and .");
        }
        return null;
    }
}



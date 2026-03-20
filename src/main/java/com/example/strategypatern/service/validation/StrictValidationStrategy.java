package com.example.strategypatern.service.validation;

public class StrictValidationStrategy implements ValidationStrategy{
    @Override
    public String validate(String fname, String password, String email) {
        if (fname == null || fname.length() < 6 || fname.contains(" ")) {
            throw new ValidationException("Username needs to be at least 6 characters long and cannot have space between.");
        }

        if (password == null || password.length() < 10 && !password.contains("[a-zA-Z]+") && !password.contains("[0-9]+")) {
            throw new ValidationException("Password needs to be at least 10 characters long and include both letters and numbers, and at least 1 capital letter");
        }

        // Regex betyder ^[^@] at den ikke må starte med et @
        // +@[^@] betyder at der skal komme et @ men der må ikke være et efterfølgende
        // +.[^@]+ betyder at der skal komme et. og at der ikke må være et @ efter, der skal dog være andet tekst efter.
        if (email == null || email.contains("^[^@]+@[^@]+.[^@]+")) {
            throw new ValidationException("Email must contain @ and .");
        }

        return null;
    }
}

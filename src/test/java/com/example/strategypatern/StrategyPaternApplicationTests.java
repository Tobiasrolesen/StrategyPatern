/*
package com.example.strategypatern;

import com.example.strategypatern.model.User;
import com.example.strategypatern.service.validation.SimpleValidationStrategy;
import com.example.strategypatern.service.validation.StrictValidationStrategy;
import com.example.strategypatern.service.validation.ValidationException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class StrategyPaternApplicationTests {

    @Test
    void simpleValidateNewUserFname() {
        SimpleValidationStrategy strategy = new SimpleValidationStrategy();
        try {
            strategy.validate("Bo", "123456", "bohening@gmail.com");
        } catch (ValidationException ex) {
            assertEquals("Username needs to be longer than 3 characters", ex.getMessage());
        }
    }

    @Test
    void simpleValidateNewUserPassword() {
        SimpleValidationStrategy strategy = new SimpleValidationStrategy();
        try {
            strategy.validate("Hening", "hej", "Hening@gmail.com");
        } catch (ValidationException ex) {
            assertEquals("Password needs to be longer than 6 characters", ex.getMessage());
        }
    }

    @Test
    void SimpleValidationTestEmailValidation() {
        SimpleValidationStrategy strategy = new SimpleValidationStrategy();

        try {
            strategy.validate("Alfred", "testpassword", "Tobiasrolesengmail.com");
        } catch (ValidationException ex) {
            assertEquals("Email must contain @ and .", ex.getMessage());
        }
    }

    //Valid
    @Test
    void StrictValidationTestNameValidation(){
        StrictValidationStrategy strategy = new StrictValidationStrategy();

        try {
            strategy.validate("Alfredo", "testpassword", "Tobiasrolesen@gmail.com");
        } catch (ValidationException ex){
            assertEquals("Username needs to be at least 6 characters long and cannot have space between.", ex.getMessage());
        }
    }

    @Test
    void StrictValidationTestPasswordValidation(){
        StrictValidationStrategy strategy = new StrictValidationStrategy();

        try {
            strategy.validate("Alfred", "test", "Tobiasrolesen@gmail.com");
        } catch (ValidationException ex){
            assertEquals("Password needs to be at least 10 characters long and include both letters and numbers, and at least 1 capital letter", ex.getMessage());
        }
    }

    @Test
    void StrictValidationTestEmailValidation(){
        StrictValidationStrategy strategy = new StrictValidationStrategy();

        try {
            strategy.validate("Alfred", "testpassword", "Tobiasrolesen@gmailcom");
        } catch (ValidationException ex){
            assertEquals("Email must contain @ and .", ex.getMessage());
        }
    }
}


 */
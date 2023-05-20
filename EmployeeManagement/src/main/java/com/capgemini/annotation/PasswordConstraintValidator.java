package com.capgemini.annotation;

import java.util.regex.Pattern;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {
    private static final int MIN_LENGTH = 8;
    private static final int MAX_LENGTH = 30;
    private static final Pattern SYMBOL_PATTERN = Pattern.compile("[!@#$%^&*(),.?\":{}|<>]");
    private static final Pattern DICTIONARY_PATTERN = Pattern.compile("(?i)password|123456|qwerty");

    @Override
    public void initialize(ValidPassword constraintAnnotation) {
        // Initialization, if needed
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        // Perform password validation logic here
        // Return true if the password is valid, false otherwise
        // You can customize the validation criteria according to your requirements

        // Password length must be between 8 and 30 characters
        if (password.length() < MIN_LENGTH || password.length() > MAX_LENGTH) {
            return false;
        }

        // Password must contain at least 1 uppercase letter
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        // Password must contain at least 1 lowercase letter
        if (!password.matches(".*[a-z].*")) {
            return false;
        }

        // Password must contain at least 1 digit
        if (!password.matches(".*\\d.*")) {
            return false;
        }

        // Password must contain at least 1 symbol
        if (!SYMBOL_PATTERN.matcher(password).find()) {
            return false;
        }

        // Password cannot contain whitespaces
        if (password.contains(" ")) {
            return false;
        }

        // Password cannot match from dictionary
        if (DICTIONARY_PATTERN.matcher(password).matches()) {
            return false;
        }

        // All criteria passed, password is valid
        return true;
    }
}

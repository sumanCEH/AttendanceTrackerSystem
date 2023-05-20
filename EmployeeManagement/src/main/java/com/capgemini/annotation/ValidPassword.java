package com.capgemini.annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = PasswordConstraintValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPassword {
    String message() default "Invalid password";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
//In this updated example, the additional criteria include:
//
//The password length must be between 8 and 30 characters.
//The password must contain at least 1 uppercase letter.
//The password must contain at least 1 lowercase letter.
//The password must contain at least 1 digit character.
//The password must contain at least 1 symbol (special character).
//The password cannot contain whitespaces.
//The password cannot match any word from the dictionary (e.g., "password", "123456", "qwerty").
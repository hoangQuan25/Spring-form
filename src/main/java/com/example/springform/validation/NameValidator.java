package com.example.springform.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NameValidator implements ConstraintValidator<NameValidation, String> {

    @Override
    public void initialize(NameValidation constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        assert value != null;
        if (value.isEmpty()) {
            return false;
        }

        return value.matches("^[a-zA-Z\\s]+$");
    }

}

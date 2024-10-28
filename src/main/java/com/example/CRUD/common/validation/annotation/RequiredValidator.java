package com.example.CRUD.common.validation.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RequiredValidator implements ConstraintValidator<ValidRequired, String> {

    @Override
    public void initialize(ValidRequired constraintAnnotation) {
        // Initialization code if needed
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // Check if the string is null or empty
        return value != null && !value.trim().isEmpty();
    }
}

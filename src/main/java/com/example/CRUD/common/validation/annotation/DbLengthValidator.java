package com.example.CRUD.common.validation.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DbLengthValidator implements ConstraintValidator<ValidDbLength, String> {

    private int max;

    @Override
    public void initialize(ValidDbLength constraintAnnotation) {
        this.max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return value.length() <= max;
    }
}

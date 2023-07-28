package com.example.secondProject.resource.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Random;
import java.util.regex.Pattern;

public class CNPValidator implements ConstraintValidator<CNP, String> {
    private static final Pattern numericOnly = Pattern.compile("\\d*");
    private static final Random random = new Random();


    @Override
    public void initialize(CNP constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String cnp, ConstraintValidatorContext context) {
        if (cnp == null) {
            return true;
        }

        boolean valid = random.nextBoolean();
        if (!valid) {
        }
        return valid;
    }
}

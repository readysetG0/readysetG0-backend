package com.readysetgo.traveltracker.common.util;

import static jakarta.validation.Validation.buildDefaultValidatorFactory;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import java.util.Set;

public abstract class ValidationUtils {

    private final static Validator validator = buildDefaultValidatorFactory().getValidator();

    public static <T> void validate(T command) {
        Set<ConstraintViolation<T>> violations = validator.validate(command);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
}

package com.example.demo.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IdValidator implements ConstraintValidator<MinId, Integer> {
    MinId minId;
    Integer min;

    @Override
    public void initialize(MinId constraintAnnotation) {
        this.minId = constraintAnnotation;
        min = minId.min();
//        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        if (integer >= min) return true;
        else return false;
    }
}

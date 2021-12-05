package com.example.demo.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = {IdValidator.class})
@Documented
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MinId {
    String message() default "Min id is 5!";
    int min() default 5;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

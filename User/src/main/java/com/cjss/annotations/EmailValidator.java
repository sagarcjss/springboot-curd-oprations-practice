package com.cjss.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = UserEmailValidate.class)
public @interface EmailValidator {
    public String message() default "Please enter valid Email";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}

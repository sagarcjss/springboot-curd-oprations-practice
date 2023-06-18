package com.cjss.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UserGenderValidator.class)
public @interface GenderCheck {
    public String message() default "Enter gender as Male or Female only";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}

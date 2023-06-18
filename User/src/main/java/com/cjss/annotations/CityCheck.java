package com.cjss.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER,ElementType.FIELD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UserCityListValidator.class)
public @interface CityCheck {

    public String message() default "valid cities are hyd, pune, mumbai";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}

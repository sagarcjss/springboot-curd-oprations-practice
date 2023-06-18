package com.cjss.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class UserGenderValidator implements ConstraintValidator<GenderCheck, String> {
    @Override
    public boolean isValid(String gender, ConstraintValidatorContext context) {
        if (gender == null || gender.isBlank())
            return false;
        List<String> genderList = Arrays.asList("male", "female");
        Optional<String> optionalGender = genderList.stream().filter(gen -> gen.equalsIgnoreCase(gender)).findAny();
        if (optionalGender.isPresent())
            return true;
        else
            return false;
    }
}

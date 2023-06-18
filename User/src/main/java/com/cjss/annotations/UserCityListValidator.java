package com.cjss.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class UserCityListValidator implements ConstraintValidator<CityCheck, String> {
    @Override
    public boolean isValid(String city, ConstraintValidatorContext context) {
        if (city == null || city.isBlank())
            return false;
        List<String> cityList = Arrays.asList("hyd", "pune", "mumbai");
        Optional<String> optionalCity = cityList.stream().filter(c -> c.equalsIgnoreCase(city)).findAny();
        if (optionalCity.isPresent())
            return true;
        else
            return false;
    }
}

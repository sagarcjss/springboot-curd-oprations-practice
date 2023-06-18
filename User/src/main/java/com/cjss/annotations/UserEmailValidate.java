package com.cjss.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class UserEmailValidate implements ConstraintValidator<EmailValidator, String> {
    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if (email == null || email.isBlank())
            return false;
        String gmailPattern = "[a-zA-Z0-9]+\\.[a-zA-Z0-9]+@gmail\\.com";
        Pattern pattern = Pattern.compile(gmailPattern);
        if (pattern.matcher(email).matches())
            return true;
        else
            return false;
    }
}

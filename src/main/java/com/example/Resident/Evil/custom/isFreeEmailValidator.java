package com.example.Resident.Evil.custom;

import com.example.Resident.Evil.repositories.UserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class isFreeEmailValidator implements ConstraintValidator<isFreeEmail,String> {

    private final UserRepository userRepository;
    public isFreeEmailValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        if (userRepository.findByEmail(email) == null) {
            return true;
        } else {
            return false;
        }
    }
}

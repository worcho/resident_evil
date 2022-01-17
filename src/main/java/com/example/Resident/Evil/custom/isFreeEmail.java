package com.example.Resident.Evil.custom;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = isFreeEmailValidator.class)
public @interface isFreeEmail {
    String message() default "Invalid Email.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

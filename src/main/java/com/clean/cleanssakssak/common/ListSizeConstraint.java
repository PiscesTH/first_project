package com.clean.cleanssakssak.common;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Constraint(validatedBy = ListSizeConstraintValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface ListSizeConstraint {
    String message() default "사진은 두 장 필요합니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

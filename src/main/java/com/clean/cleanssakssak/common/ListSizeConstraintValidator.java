package com.clean.cleanssakssak.common;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class ListSizeConstraintValidator implements ConstraintValidator<ListSizeConstraint, List<String>> {
    @Override
    public boolean isValid(List<String> list, ConstraintValidatorContext context){
        return list.size() == 2;
    }
}

package com.clean.cleanssakssak.common;

import org.springframework.validation.BindingResult;

public class CustomInvalidExcetption extends RuntimeException {

    private BindingResult bindingResult;

    public CustomInvalidExcetption(BindingResult bindingResult) {
        this.bindingResult = bindingResult;
    }

    public BindingResult getBindingResult() {
        return bindingResult;
    }
}

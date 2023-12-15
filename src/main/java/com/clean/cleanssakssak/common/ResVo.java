package com.clean.cleanssakssak.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResVo {
    private int result;
    private String errorMsg;

    public ResVo(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public ResVo(int result) {
        this.result = result;
    }
}

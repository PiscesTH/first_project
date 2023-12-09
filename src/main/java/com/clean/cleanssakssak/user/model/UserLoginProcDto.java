package com.clean.cleanssakssak.user.model;

import lombok.Data;

@Data
public class UserLoginProcDto {
    private int userId;
    private String upw;
    private String nickName;
}

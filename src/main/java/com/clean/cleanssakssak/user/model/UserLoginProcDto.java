package com.clean.cleanssakssak.user.model;

import lombok.Data;

@Data
public class UserLoginProcDto {
    //로그인 성공하면 불러올 정보 중간 처리용
    private int userId;
    private String upw;
    private String nickname;
}

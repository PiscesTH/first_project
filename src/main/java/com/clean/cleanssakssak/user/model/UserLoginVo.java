package com.clean.cleanssakssak.user.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserLoginVo {
    private int result;
    private int userId;
    private String nickname;
}

package com.clean.cleanssakssak.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
public class UserLoginVo {
    private int result;
    private int userId;
    private String nickName;
}

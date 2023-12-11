package com.clean.cleanssakssak.user.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserLoginVo {
    @Schema(description = "로그인 결과")
    private int result;
    @Schema(description = "로그인 한 유저 pk")
    private int userId;
    @Schema(description = "로그인 한 유저 닉네임")
    private String nickname;
}

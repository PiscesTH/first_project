package com.clean.cleanssakssak.user.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UserLoginDto {
    @Schema(description = "아이디")
    private String uid;
    @Schema(description = "비밀번호")
    private String upw;
}

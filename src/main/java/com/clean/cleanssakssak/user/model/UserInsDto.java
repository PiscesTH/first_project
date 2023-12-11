package com.clean.cleanssakssak.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UserInsDto {
    @JsonIgnore
    private int userId;
    @Schema(description = "유저 아이디")
    private String uid;
    @Schema(description = "유저 비밀번호")
    private String upw;
    @Schema(description = "유저 닉네임")
    private String nickname;
}

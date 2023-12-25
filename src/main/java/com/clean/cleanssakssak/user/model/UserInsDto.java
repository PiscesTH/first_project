package com.clean.cleanssakssak.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserInsDto {
    @JsonIgnore
    private int userId;
    @Schema(description = "유저 아이디")
    @NotNull
    @Pattern(regexp = "^[a-z0-9]$", message = "유효하지 않은 아이디입니다.")
    private String uid;
    @Schema(description = "유저 비밀번호")
    @NotNull
    private String upw;
    @Schema(description = "유저 닉네임")
    @NotNull
    private String nickname;
}

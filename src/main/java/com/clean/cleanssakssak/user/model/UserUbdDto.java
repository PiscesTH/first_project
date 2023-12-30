package com.clean.cleanssakssak.user.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserUbdDto {
    @Schema(description = "로그인 한 유저 pk")
    private int loginedUserId;
    @NotBlank(message = "아이디를 입력해주세요.")
    @Pattern(regexp = "^[a-zA-Z0-9]{4,10}$", message = "아이디는 영어 대/소문자와 숫자로만 이루어진 4~10자리이어야 합니다.")
    @Schema(description = "변경할 비밀번호")
    private String upw;
    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Schema(description = "변경할 닉네임")
    private String nickname;
}

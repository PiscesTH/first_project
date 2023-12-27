package com.clean.cleanssakssak.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserInsDto {
    @JsonIgnore
    private int userId;
    @Schema(description = "유저 아이디")
    @NotNull(message = "아이디를 입력해주세요")
    @Pattern(regexp = "^[a-zA-Z0-9]{4,10}$", message = "아이디는 영어 대/소문자와 숫자로만 이루어진 4~10자리이어야 합니다.")
    private String uid;
    @Schema(description = "유저 비밀번호")
    @NotBlank
    private String upw;
    @Schema(description = "유저 닉네임")
    @NotBlank
    private String nickname;
}

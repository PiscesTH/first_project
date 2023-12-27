package com.clean.cleanssakssak.user.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserLoginDto {
    @Schema(description = "아이디")
    @NotBlank(message = "아이디를 입력해주세요.")
    @Pattern(regexp = "")
    private String uid;
    @Schema(description = "비밀번호")
    @NotBlank(message = "비밀번호를 입력해주세요.")
    private String upw;
}

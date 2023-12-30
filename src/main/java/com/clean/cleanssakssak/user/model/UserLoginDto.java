package com.clean.cleanssakssak.user.model;

import com.clean.cleanssakssak.common.ValidationGroup;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserLoginDto {
    @Schema(description = "유저 아이디", example = "Test1234")
    @NotBlank(message = "아이디를 입력해주세요.", groups = ValidationGroup.NotBlankGroup.class)
    @Pattern(regexp = "^[a-zA-Z0-9]{4,10}$",
            message = "아이디는 공백을 제외한 영어나 숫자로 이루어진 4~10자리이어야 합니다.",
            groups = ValidationGroup.PatternCheckGroup.class)
    private String uid;

    @Schema(description = "유저 비밀번호")
    @NotBlank(message = "비밀번호를 입력해주세요.")
    private String upw;
}

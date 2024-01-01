package com.clean.cleanssakssak.user.model;

import com.clean.cleanssakssak.common.ValidationGroup;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
//@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserUbdDto {
    @Schema(description = "로그인 한 유저 pk")
    private int loginedUserId;

    @Schema(description = "유저 비밀번호", example = "특수문자는 @$!%*?&#.~_- 를 사용할 수 있습니다.")
    @NotBlank(message = "비밀번호를 입력해주세요.", groups = ValidationGroup.NotBlankGroup.class)
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@$!%*?&#.~_-])[A-Za-z\\d@$!%*?&#.~_-]{8,16}$",
            message = "비밀번호는 공백을 제외한 영어와 숫자, 특수문자를 하나 이상 포함한 8~16자리이어야 합니다.",
            groups = ValidationGroup.PatternCheckGroup.class)
    private String upw;

    @Schema(description = "변경할 닉네임")
    @NotBlank(message = "닉네임를 입력해주세요.")
    private String nickname;
}

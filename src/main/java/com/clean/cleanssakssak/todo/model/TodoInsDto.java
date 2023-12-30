package com.clean.cleanssakssak.todo.model;

import com.clean.cleanssakssak.common.ValidationGroup;
import com.clean.cleanssakssak.common.ValidationSequence;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Data
@Schema(title = "청소 할 일 작성에 필요한 데이터")
public class TodoInsDto {
    @Schema(description = "로그인 한 유저의 userId")
    private int loginedUserId;

    @Schema(description = "청소 목표")
    @NotBlank(message = "할 일을 입력해주세요.", groups = ValidationGroup.NotBlankGroup.class)
    private String cleaning;

    @Schema(description = "청소 할 날짜", example = "2024-01-01")
    @NotBlank(message = "날짜를 입력해주세요.", groups = ValidationGroup.NotBlankGroup.class)
//  @Pattern(regexp = "^(19|20)\\d\\d([- /.])(0[1-9]|1[012])\\2(0[1-9]|[12][0-9]|3[01])$")
    @Pattern(regexp = "^(19|20)\\d\\d([-])(0[1-9]|1[012])\\2(0[1-9]|[12][0-9]|3[01])$",
            message = " 2024-01-01 와 같은 형식으로 올바른 날짜를 입력해주세요.",
            groups = ValidationGroup.PatternCheckGroup.class)
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private String doDay;

    @JsonIgnore
    private int todoId;
}

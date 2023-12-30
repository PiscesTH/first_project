package com.clean.cleanssakssak.todo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class TodoUpdDto {
    @Schema(description = "청소 내용")
    @NotBlank
    private String cleaning;
    @Schema(description = "청소 할 날짜")
    @Pattern(regexp = "^(19|20)\\d\\d([- /.])(0[1-9]|1[012])\\2(0[1-9]|[12][0-9]|3[01])$")
    private String doDay;
    @Schema(description = "todo pk")
    private int todoId;
    @Schema(description = "로그인 한 유저 pk")
    private int loginedUserId;
}

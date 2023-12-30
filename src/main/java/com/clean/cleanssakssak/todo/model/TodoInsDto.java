package com.clean.cleanssakssak.todo.model;

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
    @NotBlank
    private String cleaning;
    @Schema(description = "청소 할 날짜")
    @NotBlank
//  @Pattern(regexp = "^(19|20)\\d\\d([- /.])(0[1-9]|1[012])\\2(0[1-9]|[12][0-9]|3[01])$")
    @Pattern(regexp = "^(19|20)\\d\\d([-])(0[1-9]|1[012])\\2(0[1-9]|[12][0-9]|3[01])$")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date doDay;
    @JsonIgnore
    private int todoId;
}

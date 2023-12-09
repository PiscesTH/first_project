package com.clean.cleanssakssak.todo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class TodoUpdDto {
    @Schema(description = "청소 내용")
    private String cleaning;
    @Schema(description = "청소 할 날짜")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate doDay;
    @Schema(description = "todo pk")
    private int todoId;
    @Schema(description = "로그인 한 유저 pk")
    private int loginedUserId;
}

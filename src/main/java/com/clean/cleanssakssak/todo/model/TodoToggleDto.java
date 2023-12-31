package com.clean.cleanssakssak.todo.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TodoToggleDto {
    @Schema(description = "todo pk")
    private int todoId;
    @Schema(description = "로그인 한 유저 pk")
    private int loginedUserId;
}

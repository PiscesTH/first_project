package com.clean.cleanssakssak.todo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class TodoToggleDto {
    @Schema(description = "todo pk")
    private int todoId;
    @Schema(description = "로그인 한 유저 pk")
    private int loginedUserId;
}

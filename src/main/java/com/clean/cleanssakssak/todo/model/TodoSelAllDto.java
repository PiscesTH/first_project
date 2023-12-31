package com.clean.cleanssakssak.todo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Schema(title = "청소 할 일 전체 조회에 필요한 데이터",
        description = "8개씩 페이징 처리")
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TodoSelAllDto {
    @Schema(description = "로그인 한 유저 userId")
    private int loginedUserId;
    @Schema(description = "페이지")
    private int page;
    @JsonIgnore
    private int startIdx;
    @JsonIgnore
    private int rowCount;
}

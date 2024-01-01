package com.clean.cleanssakssak.diary.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class DiarySelAllDto {
    @Schema(description = "로그인 한 유저 pk")
    private int loginedUserId;
    @Schema(description = "페이지")
    private int page;
    @JsonIgnore
    private int startIdx;
    @JsonIgnore
    private int rowCount;
}

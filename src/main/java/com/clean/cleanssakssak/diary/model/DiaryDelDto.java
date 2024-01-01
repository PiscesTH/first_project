package com.clean.cleanssakssak.diary.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.beans.ConstructorProperties;

@Data
public class DiaryDelDto {
    @Schema(description = "로그인 한 유저 pk")
    private int loginedUserId;
    @Schema(description = "다이어리 pk")
    private int diaryId;
}

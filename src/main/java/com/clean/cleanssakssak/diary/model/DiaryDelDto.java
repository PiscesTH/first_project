package com.clean.cleanssakssak.diary.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class DiaryDelDto {
    @Schema(description = "로그인 한 유저 pk")
    private int loginedUserId;
    @Schema(description = "다이어리 pk")
    private int diaryId;
}

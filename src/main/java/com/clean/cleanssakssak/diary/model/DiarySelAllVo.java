package com.clean.cleanssakssak.diary.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class DiarySelAllVo {
    @Schema(description = "다이어리 pk")
    private int diaryId;
    @Schema(description = "작성자 닉네임")
    private String nickname;
    @Schema(description = "일기 제목")
    private String title;
    @Schema(description = "일기 내용")
    private String contents;
    @Schema(description = "일기 사진")
    private List<String> pics;
    @Schema(description = "일기 작성 시간")
    private String CreatedAt;
}

package com.clean.cleanssakssak.diary.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class DiaryUpdDto {
    @Schema(title = "다이어리 pk")
    private int diaryId;
    @Schema(title = "로그인 한 유저pk")
    private int loginedUserId;
    @Schema(title = "다이어리 제목")
    private String title;
    @Schema(title = "다이어리 내용")
    private String contents;
    @Schema(title = "다이어리 사진들")
    private List<String> pics;
}

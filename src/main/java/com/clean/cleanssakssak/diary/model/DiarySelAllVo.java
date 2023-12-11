package com.clean.cleanssakssak.diary.model;

import lombok.Data;

import java.util.List;

@Data
public class DiarySelAllVo {
    private int diaryId;
    private String nickname;
    private String title;
    private String contents;
    private List<String> pics;
    private String CreatedAt;
}

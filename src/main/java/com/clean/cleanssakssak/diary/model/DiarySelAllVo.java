package com.clean.cleanssakssak.diary.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Data
public class DiarySelAllVo {
    private int diaryId;
    private String title;
    private String contents;
    private List<String> pics = new ArrayList<>();
    private String CreatedAt;
}

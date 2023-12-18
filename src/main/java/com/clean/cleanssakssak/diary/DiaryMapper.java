package com.clean.cleanssakssak.diary;

import com.clean.cleanssakssak.diary.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DiaryMapper {
    int insDiary(DiaryInsDto dto);
    int insDiaryPics(DiaryInsDto dto);
    List<DiarySelAllVo> selDiaryAll(DiarySelAllDto dto);
    List<DiarySelPicsVo> selPicAll(List<Integer> diaryIdList);
    int delDiary(DiaryDelDto dto);
    int delDiaryPics(DiaryDelDto dto);
    int updDiary(DiaryUpdDto dto);
    int delDiaryPicForUnregister(int loginedUserId);
    int delDiaryForUnregister(int loginedUserId);
}

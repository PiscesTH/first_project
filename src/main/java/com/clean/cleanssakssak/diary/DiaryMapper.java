package com.clean.cleanssakssak.diary;

import com.clean.cleanssakssak.diary.model.DiaryInsDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DiaryMapper {
    int insDiary(DiaryInsDto dto);
    int insDiaryPics(DiaryInsDto dto);
}

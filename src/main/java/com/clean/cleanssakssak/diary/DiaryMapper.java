package com.clean.cleanssakssak.diary;

import com.clean.cleanssakssak.diary.model.DiaryInsDto;
import com.clean.cleanssakssak.diary.model.DiarySelAllDto;
import com.clean.cleanssakssak.diary.model.DiarySelAllVo;
import com.clean.cleanssakssak.diary.model.DiarySelPicsVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DiaryMapper {
    int insDiary(DiaryInsDto dto);
    int insDiaryPics(DiaryInsDto dto);
    List<DiarySelAllVo> selDiaryAll(DiarySelAllDto dto);
    List<DiarySelPicsVo> selPicAll(List<Integer> diaryIdList);
}

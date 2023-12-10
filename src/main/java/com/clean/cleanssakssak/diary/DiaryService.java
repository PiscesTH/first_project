package com.clean.cleanssakssak.diary;

import com.clean.cleanssakssak.common.ResVo;
import com.clean.cleanssakssak.diary.model.DiaryDelDto;
import com.clean.cleanssakssak.diary.model.DiaryInsDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DiaryService {
    private final DiaryMapper mapper;

    public ResVo postDiary(DiaryInsDto dto){
        int insDiaryResult = mapper.insDiary(dto);
        if (dto.getPics() != null && !dto.getPics().isEmpty()) {
            int insPicsResult = mapper.insDiaryPics(dto);
        }
        return new ResVo(dto.getDiaryId());
    }

    public ResVo delDiary(DiaryDelDto dto){
        return null;
    }
}

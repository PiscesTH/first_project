package com.clean.cleanssakssak.diary;

import com.clean.cleanssakssak.common.Const;
import com.clean.cleanssakssak.common.ResVo;
import com.clean.cleanssakssak.diary.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class DiaryService {
    private final DiaryMapper mapper;

    public ResVo postDiary(DiaryInsDto dto) {
        int insDiaryResult = mapper.insDiary(dto);
        if (dto.getPics() != null && !dto.getPics().isEmpty()) {
            int insPicsResult = mapper.insDiaryPics(dto);
        }
        return new ResVo(dto.getDiaryId());
    }


    public List<DiarySelAllVo> getDiaryAll(DiarySelAllDto dto) {
        dto.setRowCount(Const.DIARY_ROW_COUNT);
        dto.setStartIdx((dto.getPage() - 1) * Const.DIARY_ROW_COUNT);
        List<DiarySelAllVo> resultVo = mapper.selDiaryAll(dto);
        if (resultVo == null || resultVo.isEmpty()) {
            return null;
        }
        Map<Integer, DiarySelAllVo> map = new HashMap<>();
        List<Integer> diaryIdList = new ArrayList<>();
        for (DiarySelAllVo vo : resultVo) {
            vo.setPics(new ArrayList<>());
            diaryIdList.add(vo.getDiaryId());
            map.put(vo.getDiaryId(), vo);
        }
        List<DiarySelPicsVo> picsVoList = mapper.selPicAll(diaryIdList);
        if (picsVoList == null) {
            return resultVo;
        }
        for (DiarySelPicsVo picsVo : picsVoList) {
            map.get(picsVo.getDiaryId()).getPics().add(picsVo.getPic());
        }
        return resultVo;
    }

}

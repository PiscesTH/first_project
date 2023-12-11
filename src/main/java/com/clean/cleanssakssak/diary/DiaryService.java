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

    //다이어리 &사진 등록
    public ResVo postDiary(DiaryInsDto dto) {
        int insDiaryResult = mapper.insDiary(dto);
        List<String> picsList = new ArrayList<>();
        for (String pic : dto.getPics()) {
            if (!pic.isBlank()) {
                picsList.add(pic);
            }
        }
        dto.setPics(picsList);
        if (dto.getPics() != null && !dto.getPics().isEmpty()) {
            int insPicsResult = mapper.insDiaryPics(dto);
        }
        return new ResVo(dto.getDiaryId());
    }

    //등록된 다이어리 &사진 리스트 전체 조회(페이징 처리 10개씩)
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

    //등록된 다이어리 삭제
    public ResVo delDiary(DiaryDelDto dto) {
        int delPicsResult = mapper.delDiaryPics(dto);
        int delDiaryResult = mapper.delDiary(dto);
        return new ResVo(delDiaryResult);
    }

    //등록된 다이어리 &사진 수정
    public ResVo updDiary(DiaryUpdDto dto) {
        int updDiaryResult = mapper.updDiary(dto);
        if (updDiaryResult == 0) {
            return new ResVo(Const.FAIL);
        }
        int delPicsResult = mapper.delDiaryPics(DiaryDelDto.builder()
                .diaryId(dto.getDiaryId())
                .loginedUserId(dto.getLoginedUserId())
                .build());
        List<String> picsList = new ArrayList<>();
        for (String pic : dto.getPics()) {
            if (!pic.isBlank()) {
                picsList.add(pic);
            }
        }
        dto.setPics(picsList);
        if (dto.getPics() == null || dto.getPics().isEmpty()) {
            return new ResVo(Const.SUCCESS);
        }
        int insPicsResult = mapper.insDiaryPics(DiaryInsDto.builder()
                .diaryId(dto.getDiaryId())
                .pics(dto.getPics())
                .build());
        return new ResVo(Const.SUCCESS);
    }
}

package com.clean.cleanssakssak.diary;

import com.clean.cleanssakssak.common.ResVo;
import com.clean.cleanssakssak.diary.model.DiaryDelDto;
import com.clean.cleanssakssak.diary.model.DiaryInsDto;
import com.clean.cleanssakssak.diary.model.DiarySelAllDto;
import com.clean.cleanssakssak.diary.model.DiarySelAllVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/diary")
public class DiaryController {
    private final DiaryService service;

    @Operation(summary = "다이어리 작성", description = """
            result > 0 : 다이어리 작성 성공. pk값 리턴<br>
            result = 0 : 다이어리 작성 실패
            """)
    @PatchMapping
    public ResVo postDiary(@RequestBody DiaryInsDto dto){
        return service.postDiary(dto);
    }

    @Operation(summary = "다이어리 삭제 처리", description = """
            result = 1 : 삭제 성공<br>
            reslut = 0 : 삭제 실패
            """)
    @DeleteMapping
    public ResVo delDiary(DiaryDelDto dto){
        return service.delDiary(dto);
    }

    @Operation(summary = "다이어리 전제 조회", description = "10개씩 페이징 처리")
    @GetMapping
    public List<DiarySelAllVo> getDiaryAll(DiarySelAllDto dto){
        return service.getDiaryAll(dto);
    }
}

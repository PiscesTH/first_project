package com.clean.cleanssakssak.diary;

import com.clean.cleanssakssak.common.CustomInvalidExcetption;
import com.clean.cleanssakssak.common.ResVo;
import com.clean.cleanssakssak.diary.model.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/diary")
public class DiaryController {
    private final DiaryService service;

    @Operation(summary = "다이어리 작성", description = """
            result > 0 : 다이어리 작성 성공. pk값 리턴<br>
            result = 0 : 다이어리 작성 실패<br>
            result = -1 : 다이어리 제목 없음
            """)
    @PostMapping
    public ResVo postDiary(@Valid @RequestBody DiaryInsDto dto, @ApiIgnore BindingResult bindingResult) throws Exception {
        /*if (dto.getPics().size() != 2){
            bindingResult.reject("400","사진을 두 장 선택해주세요.");
        }
        if (bindingResult.hasErrors()) {
            throw new MethodArgumentNotValidException(
                    new MethodParameter(
                            this.getClass()
                                    .getDeclaredMethod("postDiary", DiaryInsDto.class, BindingResult.class), 0),
                    bindingResult);
        }
        return service.postDiary(dto);*/
        if (dto.getPics().size() != 2){
            bindingResult.reject("400", "");
            bindingResult.rejectValue("dto.getPics()", "400");
        }
        if (bindingResult.hasErrors()){
            throw new CustomInvalidExcetption(bindingResult);
        }
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
//    @DeleteMapping
//    public ResVo delDiary(@RequestParam Map<String, Integer> params){
//        ObjectMapper mapper = new ObjectMapper();
//        DiaryDelDto dto = mapper.convertValue(params, DiaryDelDto.class);
//        return service.delDiary(dto);
//    }

    @Operation(summary = "다이어리 전제 조회", description = "10개씩 페이징 처리")
    @GetMapping
    public List<DiarySelAllVo> getDiaryAll(DiarySelAllDto dto){
        return service.getDiaryAll(dto);
    }

    @Operation(summary = "다이어리 수정", description = """
            result = 1 : 다이어리 수정 성공. pk값 리턴<br>
            result = 0 : 다이어리 수정 실패<br>
            result = -1 : 다이어리 제목 없음
            """)
    @PutMapping
    public ResVo putDiary(@Valid @RequestBody DiaryUpdDto dto) {
        return service.updDiary(dto);
    }

    @ExceptionHandler({CustomInvalidExcetption.class})
    public ResponseEntity<Map<String, String>> handle(CustomInvalidExcetption e){
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        Map<String, String> map = new HashMap<>();
        BindingResult bindingResult = e.getBindingResult();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            map.put("error type", httpStatus.getReasonPhrase());
            map.put("code", String.valueOf(httpStatus.value()));
            map.put("message", fieldError.getDefaultMessage());
            map.put("error position", fieldError.getField());
            map.put("입력된 값", (String)fieldError.getRejectedValue());
        }
        return new ResponseEntity<>(map, httpStatus);
    }
}

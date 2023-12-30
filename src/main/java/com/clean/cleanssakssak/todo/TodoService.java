package com.clean.cleanssakssak.todo;

import com.clean.cleanssakssak.common.Const;
import com.clean.cleanssakssak.common.ResVo;
import com.clean.cleanssakssak.todo.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoMapper mapper;

    //청소 todo 하나 등록
    public ResVo postTodo(TodoInsDto dto) {
/*        if (dto.getCleaning() == null || dto.getCleaning().isBlank()){  //cleaning 데이터가 null 이거나 공백만 있는 경우 체크
            return new ResVo(Const.FAIL);
        }
        if (dto.getDoDay() == null){    //do_day 데이터가 null 이거나 공백만 있는 경우 체크
            return new ResVo(Const.FAIL);
        }*/
        /*String[] tmp = dto.getDoDay().split("/");   //입력받은 날짜 데이터 원하는 형식으로 변경
        List<String> list = new ArrayList<>(Arrays.asList(tmp));
        list.add(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);
        String date = String.join("-", list);
        dto.setDoDay(date);*/

        int insResult = mapper.insTodo(dto);
        return new ResVo(dto.getTodoId());   //원하는 데이터 형식으로 변경한 날짜 세팅
    }

    //등록한 todo 전체 조회(한 페이지에 8개씩 페이징 처리)
    public List<TodoSelAllVo> getTodoAll(TodoSelAllDto dto) {
        dto.setRowCount(Const.TODO_ROW_COUNT);
        dto.setStartIdx((dto.getPage() - 1) * Const.TODO_ROW_COUNT);
        return mapper.selTodoAll(dto);
    }

    //작성된 todo 수정
    public ResVo patchTodo(TodoUpdDto dto) {
        int updResult = mapper.updTodo(dto);
        return new ResVo(updResult);
    }

    //작성된 todo 삭제
    public ResVo delTodo(TodoToggleDto dto) {
        int delResult = mapper.delTodo(dto);
        return new ResVo(delResult);
    }

    //체크 등록, 해제 처리
    public ResVo toggleCheck(TodoToggleDto dto) {
        int toggleResult = mapper.toggleCheck(dto);
        return new ResVo(toggleResult);
    }
}

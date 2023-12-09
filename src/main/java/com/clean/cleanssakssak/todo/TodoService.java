package com.clean.cleanssakssak.todo;

import com.clean.cleanssakssak.common.Const;
import com.clean.cleanssakssak.common.ResVo;
import com.clean.cleanssakssak.todo.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoMapper mapper;

    //청소 todo 하나 등록
    public ResVo postTodo(TodoInsDto dto){
        int insResult = mapper.insTodo(dto);
        return new ResVo(dto.getTodoId());
    }

    //등록한 todo 전체 조회(한 페이지에 8개씩 페이징 처리)
    public List<TodoSelAllVo> getTodoAll(TodoSelAllDto dto) {
        dto.setRowCount(Const.TODO_ROW_COUNT);
        dto.setStartIdx((dto.getPage()-1) * Const.TODO_ROW_COUNT);
        return mapper.selTodoAll(dto);
    }

    public ResVo patchTodo(TodoUpdDto dto){
        int updResult = mapper.updTodo(dto);
        return new ResVo(updResult);
    }

    public ResVo delTodo(TodoToggleDto dto){
        int delResult = mapper.delTodo(dto);
        return new ResVo(delResult);
    }

    public ResVo toggleCheck(TodoToggleDto dto) {
        int toggleResult = mapper.toggleCheck(dto);
        return new ResVo(toggleResult);
    }
}

package com.clean.cleanssakssak.todo;

import com.clean.cleanssakssak.common.ResVo;
import com.clean.cleanssakssak.common.ValidationSequence;
import com.clean.cleanssakssak.todo.model.*;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/todo")
public class TodoController {
    private final TodoService service;

    @Operation(summary = "청소 할 일 등록", description = "등록 성공 : todo_id 값 리턴 / 등록 실패 : 0 ")
    @PostMapping
    public ResVo postTodo(@Validated(ValidationSequence.class) @RequestBody TodoInsDto dto) {
        return service.postTodo(dto);
    }

    @Operation(summary = "청소 할 일 목록 불러오기", description = "8개씩 페이징 처리")
    @GetMapping
    public List<TodoSelAllVo> getTodoAll(TodoSelAllDto dto) {
        return service.getTodoAll(dto);
    }

    @Operation(summary = "청소 할 일 수정", description = "수정 성공 : 1 / 실패 : 0")
    @PutMapping
    public ResVo patchTodo(@Validated(ValidationSequence.class) @RequestBody TodoUpdDto dto) {
        return service.patchTodo(dto);
    }

    @Operation(summary = "청소 할 일 삭제 처리", description = "삭제 성공 : 1 / 복구 : 0")
    @DeleteMapping
    public ResVo delTodo(TodoToggleDto dto) {
        return service.delTodo(dto);
    }

    @Operation(summary = "할 일 체크 처리", description = "체크 변경 성공 : 1 / 변경 실패 : 0")
    @PostMapping("/check")
    public ResVo toggleCheck(TodoToggleDto dto) {
        return service.toggleCheck(dto);
    }
}

package com.clean.cleanssakssak.todo;

import com.clean.cleanssakssak.todo.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TodoMapper {
    int insTodo(TodoInsDto dto);
    List<TodoSelAllVo> selTodoAll(TodoSelAllDto dto);
    int updTodo(TodoUpdDto dto);
    int delTodo(TodoToggleDto dto);
    int toggleCheck(TodoToggleDto dto);
    int delTodoForUnregister(int loginedUserId);
}

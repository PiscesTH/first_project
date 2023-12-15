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
    public ResVo postTodo(TodoInsDto dto){
        if (dto.getCleaning() == null || dto.getCleaning().isBlank()){  //cleaning 데이터가 null 이거나 공백만 있는 경우 체크
            return new ResVo(Const.FAIL);
        }
        if (dto.getDoDay() == null || dto.getDoDay().isBlank()){    //do_day 데이터가 null 이거나 공백만 있는 경우 체크
            return new ResVo(Const.FAIL);
        }
        /*String[] tmp = dto.getDoDay().split("/");   //입력받은 날짜 데이터 원하는 형식으로 변경
        List<String> list = new ArrayList<>(Arrays.asList(tmp));
        list.add(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);
        String date = String.join("-", list);
        dto.setDoDay(date);*/
 /*
        String[] arr = {"화장실 청소", "방 청소", "책상 정리", "옷 정리", "빨래"};
        for (int i = 0; i < 100; i++) {
            int randomUserId = (int) (Math.random() * 16) + 1;
            int randomTodo = (int) (Math.random() * 5);
            int randomDate = (int) (Math.random()* 28) + 1;
            int randomMonth = (int) (Math.random()* 12) + 1;
            dto.setLoginedUserId(randomUserId);
            dto.setCleaning(arr[randomTodo]);
            dto.setDoDay(String.format("2023-%d-%d",randomMonth,randomDate));

        int insResult = mapper.insTodo(dto);
        }*/
        try {
            String tmpDate = dto.getDoDay();
            SimpleDateFormat bDateFormat = new SimpleDateFormat("MM/dd/yyyy");
            SimpleDateFormat aDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date formatDate = bDateFormat.parse(tmpDate);
            String resultDate = aDateFormat.format(formatDate);
            dto.setDoDay(resultDate);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        int insResult = mapper.insTodo(dto);
        return new ResVo(dto.getTodoId());   //원하는 데이터 형식으로 변경한 날짜 세팅
    }

    //등록한 todo 전체 조회(한 페이지에 8개씩 페이징 처리)
    public List<TodoSelAllVo> getTodoAll(TodoSelAllDto dto) {
        dto.setRowCount(Const.TODO_ROW_COUNT);
        dto.setStartIdx((dto.getPage()-1) * Const.TODO_ROW_COUNT);
        return mapper.selTodoAll(dto);
    }

    //작성된 todo 수정
    public ResVo patchTodo(TodoUpdDto dto){
        try {
            int updResult = mapper.updTodo(dto);
            return new ResVo(updResult);
        }
        catch (Exception e){
            log.info("error : {}",e.getMessage());
            return new ResVo(Const.FAIL, e.getMessage());
        }
    }

    //작성된 todo 삭제
    public ResVo delTodo(TodoToggleDto dto){
        int delResult = mapper.delTodo(dto);
        return new ResVo(delResult);
    }

    //체크 등록, 해제 처리
    public ResVo toggleCheck(TodoToggleDto dto) {
        int toggleResult = mapper.toggleCheck(dto);
        return new ResVo(toggleResult);
    }
}

package com.clean.cleanssakssak.common;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> validExceptionHandler(MethodArgumentNotValidException e){
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

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Map<String, String>> exceptionHandler(Exception e){
        HttpHeaders responseHeaders = new HttpHeaders();
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        Map<String, String> map = new HashMap<>();
        map.put("error type", httpStatus.getReasonPhrase());
        map.put("code", "500");
        map.put("message", "서버에 문제가 발생했습니다. 다시 시도해주세요.");

        return new ResponseEntity<>(map, responseHeaders, httpStatus);
    }

}

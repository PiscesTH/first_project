package com.clean.cleanssakssak.common;

import jakarta.validation.ConstraintViolationException;
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
import java.util.Set;

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

    @ExceptionHandler({ ConstraintViolationException.class })
    public ResponseEntity<Object> handleValidList(final ConstraintViolationException ex) {
        HashMap<String, Object> errMap = new HashMap<>();
        errMap.put("msg", ex.getMessage());
        return new ResponseEntity<>(errMap, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {CustomInvalidExcetption.class})
    public ResponseEntity<Map<String, String>> customExceptionHandler(CustomInvalidExcetption e){
        HttpHeaders responseHeaders = new HttpHeaders();
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        BindingResult bindingResult = e.getBindingResult();
        Map<String, String> map = new HashMap<>();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            map.put("error type", httpStatus.getReasonPhrase());
            map.put("code", String.valueOf(httpStatus.value()));
            map.put("message", fieldError.getDefaultMessage());
            map.put("error position", fieldError.getField());
            map.put("입력된 값", (String)fieldError.getRejectedValue());
        }

        return new ResponseEntity<>(map, responseHeaders, httpStatus);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Map<String, String>> exceptionHandler(Exception e){
        HttpHeaders responseHeaders = new HttpHeaders();
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        Map<String, String> map = new HashMap<>();
        map.put("error type", httpStatus.getReasonPhrase());
        map.put("code", "500");
        map.put("message", e.getMessage());

        return new ResponseEntity<>(map, responseHeaders, httpStatus);
    }
}

package com.example.springcoreannotations.advice;


import com.example.springcoreannotations.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class UserExceptionHandler {




       /* @ExceptionHandler(UserNotFoundException.class)
        public ResponseEntity<AppError> handleException(UserNotFoundException exception) {
            AppError error=new AppError(UUID.randomUUID().toString(),
                    exception.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
        }*/

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(UserNotFoundException.class)
    public Map<String, String> handleBusinessException(UserNotFoundException ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", ex.getMessage());
        return errorMap;
    }
    }


package com.example.FoodDeliverProject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

public class UserDefineException extends Exception{

    public UserDefineException(String exception){
        super(exception);
    }
}

@RestControllerAdvice
class UserDefineExceptionHandle {
    @ExceptionHandler(UserDefineException.class)
    public ResponseEntity<String> getMessage(UserDefineException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
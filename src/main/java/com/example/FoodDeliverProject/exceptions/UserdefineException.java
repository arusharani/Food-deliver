package com.example.FoodDeliverProject.exceptions;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

public class UserdefineException extends Exception{

    public UserdefineException(String exception){
        super(exception);
    }
}

@RestControllerAdvice
class UserdefineExceptionHandle{
    @ExceptionHandler(UserdefineException.class)
    public ResponseEntity<String> getMessage(UserdefineException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
package com.curdOperation.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(value = BooKException.class)
    public ResponseEntity blogNotFoundException(BooKException booKException) {
        return new ResponseEntity(booKException.getMessage(), HttpStatus.BAD_REQUEST);
    }
}

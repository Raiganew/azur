package com.rga.infraestructure.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorController {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handlerError(RuntimeException ex){
        return new ResponseEntity<String>(ex.getMessage(),null, HttpStatus.BAD_REQUEST);
    }
}

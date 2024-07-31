package com.example.starwars.contract.rest.config;

import com.example.starwars.contract.rest.controller.PersonNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalErrorCatcher {
    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<String> handlePersonNotFoundException(PersonNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}

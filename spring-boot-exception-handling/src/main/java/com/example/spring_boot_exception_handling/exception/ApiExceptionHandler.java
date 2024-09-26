package com.example.spring_boot_exception_handling.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler({EntityNotFoundException.class})
    public String entityNotFound() {
        return "Record Not Found";
    }

    @ExceptionHandler({IllegalArgumentException.class})
    public String iaException() {
        return "Wrong Parameter";
    }

}

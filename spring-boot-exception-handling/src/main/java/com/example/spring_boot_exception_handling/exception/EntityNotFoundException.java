package com.example.spring_boot_exception_handling.exception;

public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException(String param){
        super(param);
    }

}

package com.user.management.exceptions;

import org.springframework.web.bind.annotation.RestControllerAdvice;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String msg){
        super(msg);
    }

    public ResourceNotFoundException(){
        super("Resource not found !!");
    }

}

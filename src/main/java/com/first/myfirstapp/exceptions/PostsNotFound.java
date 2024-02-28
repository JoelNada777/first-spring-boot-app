package com.first.myfirstapp.exceptions;

import lombok.Data;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@Data
public class PostsNotFound  extends RuntimeException{
    public PostsNotFound(String message){
        super(message);
    }
}

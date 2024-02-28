package com.first.myfirstapp.exceptions;

import com.first.myfirstapp.exceptions.exceptionDTO.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.xml.crypto.Data;
import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({PostsNotFound.class})
    public ResponseEntity<ExceptionDTO> postsNotFoundException(PostsNotFound postsNotFound){
        ExceptionDTO exceptionDTO = new ExceptionDTO(postsNotFound.getMessage(), new Date());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionDTO);
    }

    @ExceptionHandler({CommentsException.class})
    public ResponseEntity<ExceptionDTO> commentsNotFoundException(CommentsException commentsException){
        ExceptionDTO exceptionDTO = new ExceptionDTO(commentsException.getMessage(),new Date());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionDTO);
    }

}

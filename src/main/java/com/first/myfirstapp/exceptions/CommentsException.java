package com.first.myfirstapp.exceptions;

import lombok.Data;

@Data
public class CommentsException extends RuntimeException{
    public CommentsException(String message){
        super(message);
    }
}

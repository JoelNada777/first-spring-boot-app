package com.first.myfirstapp.exceptions.exceptionDTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class SinglePostNotFound extends RuntimeException{
    private Long id;

    public SinglePostNotFound(Long id){
        super("Post not found with id : "+id);
        this.id=id;
    }
}

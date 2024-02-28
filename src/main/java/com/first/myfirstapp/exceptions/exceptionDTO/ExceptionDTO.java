package com.first.myfirstapp.exceptions.exceptionDTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ExceptionDTO {
    private String message;
    private Date timeStamp;
}

package com.first.myfirstapp.models.DTO;

import lombok.Data;


@Data
public class CommentsDTO {
    private Long id;
    private String name;
    private String email;
    private String body;
}

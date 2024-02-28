package com.first.myfirstapp.models.DTO;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class PostsDTO {
    private Long id;
    private String title;
    private String description;
    private String content;
}

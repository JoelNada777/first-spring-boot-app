package com.first.myfirstapp.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String content;

    @OneToMany(mappedBy = "posts",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Comments> commentsSet = new HashSet<>();

}

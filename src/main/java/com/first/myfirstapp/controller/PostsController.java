package com.first.myfirstapp.controller;

import com.first.myfirstapp.exceptions.PostsNotFound;
import com.first.myfirstapp.models.DTO.PostsDTO;
import com.first.myfirstapp.repo.PostsRepository;
import com.first.myfirstapp.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/posts")
public class PostsController {

    @Autowired
    PostsService postsService;
    @Autowired
    PostsRepository postsRepository;

    @GetMapping("/all-posts")
    public ResponseEntity<?>  getAllPosts(){
        List<PostsDTO> posts = postsService.findAllPosts();
        if(posts.isEmpty()){
            throw new PostsNotFound("Posts Not Found or Empty !!");
        }
        else{
            return ResponseEntity.ok(posts);
        }
    }

    @PostMapping("/create-post")
    public ResponseEntity<?> createPost(@RequestBody PostsDTO postsDTO){
     postsService.addPosts(postsDTO);
      return ResponseEntity.status(HttpStatus.CREATED).body("Post Created");
    }

    @GetMapping("/get-post-by-id/{id}")
    public ResponseEntity<?> getPostById(@PathVariable("id") Long id){
        PostsDTO singlePost = postsService.getPostById(id);
        return ResponseEntity.ok().body(singlePost);
    }

    @PutMapping("/update-post/{id}")
    public ResponseEntity<?> updatePost(@PathVariable("id") Long id, @RequestBody PostsDTO postsDTO ){
        postsService.updatePost(postsDTO,id);
        return ResponseEntity.ok().body("Post is updated !!");
    }

    @DeleteMapping("/delete-post/{id}")
    public ResponseEntity<?> deletePost(@PathVariable("id") Long id){
        postsService.deletePost(id);
        return ResponseEntity.ok("Deleted post !!");
    }


}

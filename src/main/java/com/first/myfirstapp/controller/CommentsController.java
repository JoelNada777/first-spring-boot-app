package com.first.myfirstapp.controller;

import com.first.myfirstapp.exceptions.CommentsException;
import com.first.myfirstapp.models.DTO.CommentsDTO;
import com.first.myfirstapp.models.DTO.PostsDTO;
import com.first.myfirstapp.repo.CommetsRepository;
import com.first.myfirstapp.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentsController {

    @Autowired
    CommentsService commentsService;
    @Autowired
    CommetsRepository commetsRepository;

    @PostMapping ("posts/{postId}/add-comment")
    public ResponseEntity<?> createComment(@PathVariable("postId") Long id, @RequestBody CommentsDTO commentsDTO){
       commentsService.addComments(id,commentsDTO);
       return ResponseEntity.status(HttpStatus.CREATED).body("Comment added !!");
    }

    @GetMapping("/all-comments-of-posts/{postId}")
    public ResponseEntity<?> getCommentsByPost(@PathVariable("postId") Long postId)  {
        List<CommentsDTO> response = commentsService.getAllCommentsForPostsId(postId);
        if(response.isEmpty()){
            throw new CommentsException("Comments for post id :"+postId+" not found or Empty !!");
        }
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/comment-for-post-byid/{postId}/{commentId}")
    public ResponseEntity<?> getCommentByIdforPosts(@PathVariable("postId") Long postId,
                                                    @PathVariable("commentId") Long commentId){
      CommentsDTO comment = commentsService.getSingleCommentForPost(postId,commentId);
        return ResponseEntity.ok().body(comment);
    }

}

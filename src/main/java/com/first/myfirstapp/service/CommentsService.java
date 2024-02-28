package com.first.myfirstapp.service;

import com.first.myfirstapp.models.DTO.CommentsDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentsService {
    public void addComments(long postId, CommentsDTO commentsDTO);
    public List<CommentsDTO> getAllCommentsForPostsId(Long id);
    public CommentsDTO getSingleCommentForPost(Long postId, Long commentId);
}

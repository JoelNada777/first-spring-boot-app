package com.first.myfirstapp.service;

import com.first.myfirstapp.models.DTO.PostsDTO;

import java.util.List;

public interface PostsService {
    public void addPosts(PostsDTO postsDTO);
    public List<PostsDTO> findAllPosts();
   public  PostsDTO getPostById(Long id);
   public void updatePost(PostsDTO postsDTO, Long id);
    void deletePost(Long id);
}

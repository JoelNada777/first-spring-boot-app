package com.first.myfirstapp.service.ServiceImpl;

import com.first.myfirstapp.exceptions.exceptionDTO.SinglePostNotFound;
import com.first.myfirstapp.models.DTO.PostsDTO;
import com.first.myfirstapp.models.entity.Posts;
import com.first.myfirstapp.repo.PostsRepository;
import com.first.myfirstapp.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostsService {

    @Autowired
    PostsRepository postsRepository;

    @Override
    public void addPosts(PostsDTO postsDTO) {
       Posts posts = mapToEntity(postsDTO);
       postsRepository.save(posts);
    }

    @Override
    public List<PostsDTO> findAllPosts() {
        List<Posts> res = postsRepository.findAll();
        return  res.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public PostsDTO getPostById(Long id) {
        Posts posts = postsRepository.findById(id).orElseThrow(()-> new SinglePostNotFound(id));
        return mapToDTO(posts);
    }

    @Override
    public void updatePost(PostsDTO postsDTO, Long id) {
        Posts updatePost = postsRepository.findById(id).orElseThrow(()-> new SinglePostNotFound(id));
        updatePost.setDescription(postsDTO.getDescription());
        updatePost.setTitle(postsDTO.getTitle());
        updatePost.setContent(postsDTO.getContent());
        postsRepository.save(updatePost);
    }

    @Override
    public void deletePost(Long id) {
        Posts posts = postsRepository.findById(id).orElseThrow(()-> new SinglePostNotFound(id));
        postsRepository.delete(posts);
    }


    private PostsDTO mapToDTO(Posts posts){
        PostsDTO postsDTO = new PostsDTO();
        postsDTO.setId(posts.getId());
        postsDTO.setDescription(posts.getDescription());
        postsDTO.setContent(posts.getContent());
        postsDTO.setTitle(posts.getTitle());
        return postsDTO;
    }

    private  Posts mapToEntity(PostsDTO postsDTO){
        Posts posts = new Posts();

        posts.setContent(postsDTO.getContent());
        posts.setTitle(postsDTO.getTitle());
        posts.setDescription(postsDTO.getDescription());
        return posts;
    }

}

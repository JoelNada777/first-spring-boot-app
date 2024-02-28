package com.first.myfirstapp.service.ServiceImpl;

import com.first.myfirstapp.exceptions.BlogApiException;
import com.first.myfirstapp.exceptions.exceptionDTO.SingleCommentNotFound;
import com.first.myfirstapp.exceptions.exceptionDTO.SinglePostNotFound;
import com.first.myfirstapp.models.DTO.CommentsDTO;
import com.first.myfirstapp.models.entity.Comments;
import com.first.myfirstapp.models.entity.Posts;
import com.first.myfirstapp.repo.CommetsRepository;
import com.first.myfirstapp.repo.PostsRepository;
import com.first.myfirstapp.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class CommentsServiceImpl implements CommentsService {

    @Autowired
    CommetsRepository commetsRepository;
   @Autowired
    PostsRepository postsRepository;
    @Override
    public void addComments(long postId, CommentsDTO commentsDTO) {
        Comments comments = mapToEntity(commentsDTO);
        Posts posts = postsRepository.findById(postId).orElseThrow(()-> new SinglePostNotFound(postId));
        comments.setPosts(posts);
        commetsRepository.save(comments);
    }

    @Override
    public List<CommentsDTO> getAllCommentsForPostsId(Long postId) {
       List<Comments> response = commetsRepository.getByPostId(postId);
       return response.stream().map(this::mapToDTO).collect(toList());
    }

    @Override
    public CommentsDTO getSingleCommentForPost(Long postId, Long commentId) throws BlogApiException {

        Posts posts = postsRepository.findById(postId).orElseThrow(()-> new SinglePostNotFound(postId));
        Comments comment = commetsRepository.findById(commentId).orElseThrow(()-> new SingleCommentNotFound(commentId));

        if(!comment.getPosts().getId().equals(posts.getId())){
            throw new BlogApiException(HttpStatus.BAD_REQUEST,"Comment does't belong to Posts");
        }
        return mapToDTO(comment);
    }


    private CommentsDTO mapToDTO(Comments comments){
        CommentsDTO commentsDTO = new CommentsDTO();
        commentsDTO.setBody(comments.getBody());
        commentsDTO.setId(comments.getId());
        commentsDTO.setName(comments.getName());
        commentsDTO.setEmail(comments.getEmail());
        return commentsDTO;
    }

    private Comments mapToEntity(CommentsDTO commentsDTO){
        Comments comments = new Comments();
        comments.setBody(commentsDTO.getBody());
        comments.setName(commentsDTO.getName());
        comments.setEmail(commentsDTO.getEmail());
        return comments;
    }

}

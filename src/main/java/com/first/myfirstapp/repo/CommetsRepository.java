package com.first.myfirstapp.repo;

import com.first.myfirstapp.models.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommetsRepository extends JpaRepository<Comments,Long> {
    @Query("SELECT c FROM Comments c JOIN c.posts p WHERE p.id = :postId")
    List<Comments> getByPostId(Long postId);
}

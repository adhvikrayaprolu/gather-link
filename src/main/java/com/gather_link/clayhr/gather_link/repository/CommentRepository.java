package com.gather_link.clayhr.gather_link.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gather_link.clayhr.gather_link.model.Comments;
import com.gather_link.clayhr.gather_link.model.Posts;
import com.gather_link.clayhr.gather_link.model.Users;

@Repository
public interface CommentRepository extends JpaRepository<Comments, Long> {
    
    List<Comments> findByPost(Posts post);

    List<Comments> findByCommentCreator(Users commentCreator);
    
}

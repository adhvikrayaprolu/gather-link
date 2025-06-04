package com.gather_link.clayhr.gather_link.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gather_link.clayhr.gather_link.model.Comments;
import com.gather_link.clayhr.gather_link.model.Posts;
import com.gather_link.clayhr.gather_link.model.Users;
import com.gather_link.clayhr.gather_link.repository.CommentRepository;

@Service
public class CommentService {
	
	@Autowired
    private CommentRepository commentRepository;

    public void create(Comments comment) {
        commentRepository.save(comment);
    }
    
    public void delete(Long commentId) {
        commentRepository.deleteById(commentId);
    }
    
    public void update(Comments comment) {
        commentRepository.save(comment);
    }
    
    public Comments getByCommentId(Long commentId) {
        Optional<Comments> comment = commentRepository.findById(commentId);
        if (comment.isEmpty()) {
        	return null;
        }
        return comment.get();
    }
    
    public List<Comments> getAll() {
        return commentRepository.findAll();
    }
    
    public List<Comments> getByPost(Posts post) {
        return commentRepository.findByPost(post);
    }

    public List<Comments> getByCommentCreator(Users commentCreator) {
        return commentRepository.findByCommentCreator(commentCreator);
    }
}

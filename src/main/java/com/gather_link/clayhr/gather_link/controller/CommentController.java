package com.gather_link.clayhr.gather_link.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gather_link.clayhr.gather_link.model.Comments;
import com.gather_link.clayhr.gather_link.model.Posts;
import com.gather_link.clayhr.gather_link.model.Users;
import com.gather_link.clayhr.gather_link.service.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController {
	
	@Autowired
    private CommentService commentService;

    @PostMapping
    public String create(@RequestBody Comments comment) {
        commentService.create(comment);
        return "success";
    }
    
    @GetMapping("/{comment_id}")
    public Comments get(@PathVariable("comment_id") Long commentId) {
        return commentService.getByCommentId(commentId);
    }
    
    @DeleteMapping("/{comment_id}")
    public String delete(@PathVariable("comment_id") Long commentId) {
        commentService.delete(commentId);
        return "deleted";
    }
    
    @PutMapping("/{comment_id}")
    public String update(@PathVariable("comment_id") Long commentId, @RequestBody Comments comment) {
        comment.setCommentId(commentId);
        commentService.update(comment);
        return "updated";
    }
    
    @GetMapping("/all")
    public List<Comments> getAll() {
        return commentService.getAll();
    }
    
    @GetMapping("/by-post")
    public List<Comments> getByPost(@RequestParam("post_id") Long postId) {
        Posts post = new Posts();
        post.setPostId(postId);
        return commentService.getByPost(post);
    }
    
    @GetMapping("/by-comment-creator")
    public List<Comments> getByCommentCreator(@RequestParam("comment_creator_id") Long creatorId) {
        Users user = new Users();
        user.setUserId(creatorId);
        return commentService.getByCommentCreator(user);
    }
}

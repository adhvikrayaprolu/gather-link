package com.gather_link.clayhr.gather_link.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gather_link.clayhr.gather_link.model.Groups;
import com.gather_link.clayhr.gather_link.model.Posts;
import com.gather_link.clayhr.gather_link.model.Users;
import com.gather_link.clayhr.gather_link.service.GroupService;
import com.gather_link.clayhr.gather_link.service.PostService;
import com.gather_link.clayhr.gather_link.service.UserService;
import com.gather_link.clayhr.gather_link.dto.PostRequestDTO;
import com.gather_link.clayhr.gather_link.exceptions.UserNotFoundException;


@RestController
@RequestMapping("/posts")
public class PostController {
	
	 @Autowired
	 private PostService postService;
	 
	 @Autowired
	 private UserService userService;
	 
	 @Autowired
	 private GroupService groupService;

	 @PostMapping
	 public String create(@RequestBody PostRequestDTO dto) {
		 Groups group = groupService.getByGroupId(dto.getGroupId());
		 
		 Users user;
		 try {
			 user = userService.getByUserId(dto.getUserId());
		 } catch (UserNotFoundException e) {
			 return "User not found";
		 }
		 
		 Posts post = new Posts();
		 post.setGroup(group);
		 post.setPostCreator(user);
		 post.setContent(dto.getContent());
		 
		 postService.create(post);
		 return "success";
	 }
	 
	 @GetMapping("/{post_id}")
	 public Posts get(@PathVariable("post_id") Long postId) {
		 return postService.getByPostId(postId);
	 }
	 
	 @DeleteMapping("/{post_id}")
	 public String delete(@PathVariable("post_id") Long postId) {
		 postService.delete(postId);
		 return "deleted";
	 }
	 
	 @PutMapping("/{post_id}")
	 public String update(@PathVariable("post_id") Long postId, @RequestBody Posts post) {
		 post.setPostId(postId);
		 postService.update(post);
		 return "updated";
	 }
	 
	 @GetMapping("/all")
	 public List<Posts> getAllPosts() {
		 return postService.getAllPosts();
	 }
	 
	 @GetMapping("/by-group/{group_id}")
	 public List<Posts> getByGroupId(@PathVariable("group_id") Long groupId) {
		 return postService.getByGroupId(groupId);
	 }
	 
	 @GetMapping("/by-user/{user_id}")
	 public List<Posts> getByUserId(@PathVariable("user_id") Long userId) {
		 return postService.getByUserId(userId);
	 }

}

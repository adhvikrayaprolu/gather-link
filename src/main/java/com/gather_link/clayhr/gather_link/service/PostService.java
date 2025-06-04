package com.gather_link.clayhr.gather_link.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gather_link.clayhr.gather_link.model.Posts;
import com.gather_link.clayhr.gather_link.repository.PostRepository;

@Service
public class PostService {
	
	@Autowired
    private PostRepository postRepository;

    public void create(Posts post) {
        postRepository.save(post);
    }
    
    public void delete(Long postId) {
        postRepository.deleteById(postId);
    }
    
    public void update(Posts post) {
        postRepository.save(post);
    }
    
    public Posts getByPostId(Long post_id) {
		Optional<Posts> post = postRepository.findById(post_id);
		if (post.isEmpty()) {
			return null;
		}
		return post.get();
	}
    
    public List<Posts> getAllPosts() {
        return postRepository.findAll();
    }
    
    public List<Posts> getByGroupId(Long groupId) {
        return postRepository.findByGroup_GroupId(groupId);
    }
    
    public List<Posts> getByUserId(Long userId) {
        return postRepository.findByPostCreator_UserId(userId);
    }
}

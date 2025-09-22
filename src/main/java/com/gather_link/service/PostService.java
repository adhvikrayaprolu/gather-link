package com.gather_link.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gather_link.model.Groups;
import com.gather_link.model.Posts;
import com.gather_link.repository.PostRepository;
import com.gather_link.repository.GroupRepository;

@Service
public class PostService {
	
	@Autowired
    private PostRepository postRepository;
	
	@Autowired
	private GroupRepository groupsRepository;

    public void create(Posts post) {
        postRepository.save(post);
        
        Groups group = post.getGroup();
        group.setPostCount(group.getPostCount() + 1);
        groupsRepository.save(group);
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
    
    public List<Posts> getPostsByGroup(Groups group) {
        return postRepository.findByGroup(group);
    }
}

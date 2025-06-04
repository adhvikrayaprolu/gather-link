package com.gather_link.clayhr.gather_link.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gather_link.clayhr.gather_link.model.Posts;


public interface PostRepository extends JpaRepository<Posts, Long> {
	List<Posts> findByGroup_GroupId(Long groupId);
    List<Posts> findByPostCreator_UserId(Long userId);
}

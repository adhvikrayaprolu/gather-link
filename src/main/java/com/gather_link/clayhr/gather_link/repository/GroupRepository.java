package com.gather_link.clayhr.gather_link.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gather_link.clayhr.gather_link.model.Groups;
import com.gather_link.clayhr.gather_link.model.Users;

@Repository
public interface GroupRepository extends JpaRepository<Groups, Long> {

	Groups findByGroupName(String group_name);
	
	List<Groups> findByOwner(Users owner);
	
}

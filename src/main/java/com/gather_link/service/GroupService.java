package com.gather_link.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gather_link.model.Groups;
import com.gather_link.model.Users;
import com.gather_link.repository.GroupMembershipRepository;
import com.gather_link.repository.GroupRepository;
import com.gather_link.repository.PostRepository;

@Service
public class GroupService {
	
	@Autowired
	private GroupRepository groupRepository;
	
	public void create(Groups group) {
        groupRepository.save(group);
    }
	
	public void deleteGroup(Long groupId) {
        groupRepository.deleteById(groupId);
    }
	
	public void updateGroup(Groups group) {
        groupRepository.save(group);
    }
	
	public List<Groups> getAllGroups() {
        return groupRepository.findAll();
    }
	
	public Groups getByGroupId(Long group_id) {
		Optional<Groups> group = groupRepository.findById(group_id);
		if (group.isEmpty()) {
			return null;
		}
		return group.get();
	}

	public Groups getUserByGroupname(String group_name) {
		return groupRepository.findByGroupName(group_name);
	}
	
	public List<Groups> getGroupsByOwner(Users owner) {
	    return groupRepository.findByOwner(owner);
	}
}

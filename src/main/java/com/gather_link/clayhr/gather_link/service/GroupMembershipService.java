package com.gather_link.clayhr.gather_link.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gather_link.clayhr.gather_link.model.GroupMemberships;
import com.gather_link.clayhr.gather_link.model.Users;
import com.gather_link.clayhr.gather_link.repository.GroupMembershipRepository;
import com.gather_link.clayhr.gather_link.repository.GroupRepository;
import com.gather_link.clayhr.gather_link.model.Groups;
import com.gather_link.clayhr.gather_link.model.Role;

@Service
public class GroupMembershipService {
	
	@Autowired
    private GroupMembershipRepository groupMembershipRepository;
	
	@Autowired
	private GroupRepository groupsRepository;
	
	public void create(GroupMemberships membership) {
        groupMembershipRepository.save(membership);
        
        Groups group = membership.getGroup();
        group.setMemberCount(group.getMemberCount() + 1);
        groupsRepository.save(group);
    }
	
	public void delete(Long group_membership_id) {
        groupMembershipRepository.deleteById(group_membership_id);
    }
	
	public void update(GroupMemberships membership) {
        groupMembershipRepository.save(membership);
    }
	
	public GroupMemberships getByGroupMembershipId(Long group_membership_id) {
        Optional<GroupMemberships> groupMembership = groupMembershipRepository.findById(group_membership_id);
        if (groupMembership.isEmpty()) {
			return null;
		}
        return groupMembership.get();
    }
	
	public List<GroupMemberships> getAll() {
        return groupMembershipRepository.findAll();
    }
	
	public List<GroupMemberships> getMembershipsByUser(Users user) {
        return groupMembershipRepository.findByUser(user);
    }
	
	public List<GroupMemberships> getByGroup(Groups group) {
	    return groupMembershipRepository.findByGroup(group);
	}
	
	public void addMember(Groups group, Users user) {
	    GroupMemberships membership = new GroupMemberships();
	    membership.setGroup(group);
	    membership.setUser(user);
	    membership.setRole(Role.MEMBER);
	    groupMembershipRepository.save(membership);
	}

	public void updateRole(Groups group, Long userId, Role role) {
		Users user = new Users();
		user.setUserId(userId);
		GroupMemberships membership = groupMembershipRepository.findByGroupAndUser(group, user);

	    if (membership != null) {
	        membership.setRole(role);
	        groupMembershipRepository.save(membership);
	    }
	}

}

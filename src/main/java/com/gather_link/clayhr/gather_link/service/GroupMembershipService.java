package com.gather_link.clayhr.gather_link.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gather_link.clayhr.gather_link.model.GroupMemberships;
import com.gather_link.clayhr.gather_link.model.Users;
import com.gather_link.clayhr.gather_link.repository.GroupMembershipRepository;

@Service
public class GroupMembershipService {
	
	@Autowired
    private GroupMembershipRepository groupMembershipRepository;
	
	public void create(GroupMemberships membership) {
        groupMembershipRepository.save(membership);
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

}

package com.gather_link.clayhr.gather_link.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gather_link.clayhr.gather_link.model.GroupMemberships;
import com.gather_link.clayhr.gather_link.service.GroupMembershipService;


@RestController
@RequestMapping("/group-memberships")
public class GroupMembershipController {
	@Autowired
    private GroupMembershipService groupMembershipService;
	
	@PostMapping
    public String create(@RequestBody GroupMemberships membership) {
        groupMembershipService.create(membership);
        return "success";
    }
	
	@GetMapping("/{group_membership_id}")
    public GroupMemberships get(@PathVariable("group_membership_id") Long group_membership_id) {
        return groupMembershipService.getByGroupMembershipId(group_membership_id);
    }
	
	@DeleteMapping("/{group_membership_id}")
    public String delete(@PathVariable("group_membership_id") Long group_membership_id) {
        groupMembershipService.delete(group_membership_id);
        return "deleted";
    }
	
	@PutMapping("/{group_membership_id}")
    public String update(@PathVariable("group_membership_id") Long group_membership_id, @RequestBody GroupMemberships membership) {
        membership.setGroupMembershipId(group_membership_id);
        groupMembershipService.update(membership);
        return "updated";
    }
	
	@GetMapping("/all")
    public List<GroupMemberships> getAll() {
        return groupMembershipService.getAll();
    }
}

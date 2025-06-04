package com.gather_link.clayhr.gather_link.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gather_link.clayhr.gather_link.model.Groups;
import com.gather_link.clayhr.gather_link.service.GroupService;

@RestController
@RequestMapping("/groups")
public class GroupController {

    @Autowired
    GroupService groupService;

    @PostMapping
    public String createGroup(@RequestBody Groups group) {
        groupService.create(group);
        return "success";
    }
    
    @GetMapping("/{group_id}")
    public Groups getGroup(@PathVariable("group_id") Long group_id) {
        return groupService.getByGroupId(group_id);
    }
    
    @DeleteMapping("/{group_id}")
    public String deleteGroup(@PathVariable("group_id") Long group_id) {
        groupService.deleteGroup(group_id);
        return "success";
    }

    @PutMapping("/{group_id}")
    public String updateGroup(@PathVariable("group_id") Long group_id, @RequestBody Groups group) {
        group.setGroupId(group_id);
        groupService.updateGroup(group);
        return "success";
    }
    
    @GetMapping("/by-group_name")
    public Groups getByGroupname(@RequestParam(name = "group_name") String group_name) {
        return groupService.getUserByGroupname(group_name);
    }

    @GetMapping("/all")
    public List<Groups> getAllGroups() {
        return groupService.getAllGroups();
    }
}
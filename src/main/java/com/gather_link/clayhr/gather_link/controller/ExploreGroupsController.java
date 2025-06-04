package com.gather_link.clayhr.gather_link.controller;

import com.gather_link.clayhr.gather_link.service.GroupService;
import com.gather_link.clayhr.gather_link.service.UserService;

import jakarta.servlet.http.HttpSession;

import com.gather_link.clayhr.gather_link.model.Groups;
import com.gather_link.clayhr.gather_link.model.Users;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Controller
public class ExploreGroupsController {
	
	@Autowired
    private GroupService groupService;
	
	@Autowired
    private UserService userService;
	
	@GetMapping("/explore-groups")
	public String showGroups(ModelMap model, HttpSession session) {
		
		if (session.getAttribute("loggedInUser") == null) {
	        return "redirect:/login";
	    }
		
        List<Groups> groups = groupService.getAllGroups();
        List<Users> users = userService.getAllUsers();
        
        
        model.addAttribute("groups", groups);
        model.addAttribute("group", new Groups());
        model.addAttribute("users", users); 
        
        return "exploreGroups";
    }
	
	@PostMapping("/groups/add")
    public String addGroup(@ModelAttribute Groups group) {
        groupService.create(group);
        return "redirect:/explore-groups";
    }
}

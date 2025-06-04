package com.gather_link.clayhr.gather_link.controller;

import com.gather_link.clayhr.gather_link.model.GroupMemberships;
import com.gather_link.clayhr.gather_link.model.Groups;
import com.gather_link.clayhr.gather_link.model.Users;
import com.gather_link.clayhr.gather_link.service.GroupMembershipService;
import com.gather_link.clayhr.gather_link.service.GroupService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MyGroupsController {

    @Autowired
    private GroupService groupService;
    
    @Autowired
    private GroupMembershipService groupMembershipService;

    @GetMapping("/my-groups")
    public String showMyGroups(HttpSession session, ModelMap modelMap) {
        Users loggedInUser = (Users) session.getAttribute("loggedInUser");

        if (loggedInUser == null) {
            return "redirect:/login";
        }

        List<Groups> ownedGroups = groupService.getGroupsByOwner(loggedInUser);
        List<GroupMemberships> memberships = groupMembershipService.getMembershipsByUser(loggedInUser);

        List<Groups> memberGroups = new ArrayList<>();
        for (GroupMemberships membership : memberships) {
            Groups group = membership.getGroup();
            if (!group.getOwner().getUserId().equals(loggedInUser.getUserId())) {
                memberGroups.add(group);
            }
        }


        modelMap.addAttribute("ownedGroups", ownedGroups);
        modelMap.addAttribute("memberGroups", memberGroups);

        return "mygroups";
    }
}
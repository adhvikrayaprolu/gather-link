package com.gather_link.clayhr.gather_link.controller;

import com.gather_link.clayhr.gather_link.model.Users;
import com.gather_link.clayhr.gather_link.service.UserService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserWebController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String showUsers(ModelMap modelMap, HttpSession session) {
    	
    	if (session.getAttribute("loggedInUser") == null) {
	        return "redirect:/login";
	    }
    	
        List<Users> allUsers = userService.getAllUsers();
        modelMap.addAttribute("users", allUsers);
        modelMap.addAttribute("user", new Users());
        return "users";
    }
    
    @PostMapping("/users/add")
    public String addUser(Users user) {
        userService.create(user);
        return "redirect:/users";
    }
}
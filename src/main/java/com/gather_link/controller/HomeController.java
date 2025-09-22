package com.gather_link.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

//import com.gather_link.clayhr.gather_link.service.UserService;
import com.gather_link.model.Users;

import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String login() {
	    return "login";
	}

//    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

//    @Autowired
//    private UserService userService;

    @GetMapping("/home")
    public String getHome(HttpSession session, ModelMap modelMap) {
        Users loggedInUser = (Users) session.getAttribute("loggedInUser");

        if (loggedInUser == null) {
            return "redirect:/login";
        }

        modelMap.addAttribute("key", loggedInUser);
        return "home";
    }
    
//    @PostMapping("/new-user")
//    public String saveUser(Users user) {
//        logger.info("username: {}", user.getUsername());
//        logger.info("email: {}", user.getEmail());
//
//        return "home";
//    }
    
//    @ResponseBody
//    @PostMapping("/save-email/{email}")
//    public String saveEmail(@PathVariable(value = "email") String email) {
//        logger.info(email);
//        return "success";
//    }
}

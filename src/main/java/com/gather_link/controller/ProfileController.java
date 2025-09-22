package com.gather_link.controller;

import com.gather_link.model.Users;
import com.gather_link.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String showEditProfile(HttpSession session, Model model) {
        Users user = (Users) session.getAttribute("loggedInUser");
        if (user == null) {
            return "redirect:/login";
        }
        model.addAttribute("loggedInUser", user);
        return "editProfile";
    }

    @PostMapping("/update")
    public String updateProfile(@RequestParam("username") String username,
                                @RequestParam("password") String password,
                                HttpSession session,
                                Model model) {

        Users user = (Users) session.getAttribute("loggedInUser");
        if (user == null) {
            return "redirect:/login";
        }

        user.setUsername(username);
        if (password != null && !password.isEmpty()) {
            user.setPassword(password);
        }

        userRepository.save(user);
        session.setAttribute("loggedInUser", user);

        model.addAttribute("successMessage", "Profile updated successfully!");
        return "redirect:/profile";
    }
}

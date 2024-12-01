package com.concept.security.controller;

import com.concept.security.model.AppUser;
import com.concept.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignupController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new AppUser()); // Bind an empty User object
        return "signup";
    }

    @PostMapping("/signup")
    public String processSignup(AppUser user) {
        // Encode the password
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // Save the user to the database
        userRepository.save(user);
        return "redirect:/login?signup_success"; // Redirect to login page with a success message
    }
}

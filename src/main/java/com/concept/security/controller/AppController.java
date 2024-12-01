package com.concept.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/default")
    public String defaultAfterLogin() {
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home(Model model) {
        return "user-home";
    }

    @GetMapping("/admin/home")
    public String adminHome() {
        return "admin-home";
    }

    @GetMapping("/user/home")
    public String userHome() {
        return "user-home";
    }
}


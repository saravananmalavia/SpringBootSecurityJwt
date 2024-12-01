package com.concept.security.controller;

import com.concept.security.model.AppUser;
import com.concept.security.service.AppUserApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppUserApiController {

    @Autowired
    private AppUserApiService appUserApiService;

    @GetMapping("/api/users")
    public List<AppUser> getAllUsers() {
        return appUserApiService.getAllUsers(); // Returns a list of all users as JSON
    }
}

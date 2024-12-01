package com.concept.security.service;


import com.concept.security.model.AppUser;
import com.concept.security.repository.AppUserApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserApiService {

    @Autowired
    private AppUserApiRepository appUserApiRepository;

    public List<AppUser> getAllUsers() {
        return appUserApiRepository.findAll();
    }
}


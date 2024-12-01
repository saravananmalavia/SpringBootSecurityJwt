package com.concept.security.repository;

import com.concept.security.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserApiRepository extends JpaRepository<AppUser, Long> {
	 AppUser findByUsername(String username);
}

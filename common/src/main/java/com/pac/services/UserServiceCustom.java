package com.pac.services;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.pac.model.User;

public interface UserServiceCustom extends UserDetailsService {
    Optional<User> findByEmail(String email);
}

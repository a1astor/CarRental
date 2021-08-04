package com.pac.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pac.dao.UserRepository;
import com.pac.model.secutiry.User;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserDetailServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userByEmail = userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Unknown email: " + username));
        return org.springframework.security.core.userdetails.User.builder()
                .username(userByEmail.getEmail())
                .password(userByEmail.getPassword())
                .roles(userByEmail.getRole().name())
                .authorities(userByEmail.getRole().getAuthorities())
                .build();

    }
}

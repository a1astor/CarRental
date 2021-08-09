package com.pac.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pac.dao.UserRepository;
import com.pac.model.User;
import com.pac.security.AuthenticationRequestDTO;
import com.pac.security.JwtTokenProvider;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;

    private final UserRepository userRepository;

    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, UserRepository userRepository, JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequestDTO requestDTO) {
        User user = userRepository.findByEmail(requestDTO.getEmail()).orElseThrow(() -> new UsernameNotFoundException("user doesn't exist"));
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(requestDTO.getEmail(), requestDTO.getPassword(),user.getRole().getAuthorities()));
        String token = jwtTokenProvider.createToken(requestDTO.getEmail(), user.getRole().name());
        Map<Object, Object> response = new HashMap<>();
        response.put("email", requestDTO.getEmail());
        response.put("token", token);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
        securityContextLogoutHandler.logout(request, response, null);
    }

}

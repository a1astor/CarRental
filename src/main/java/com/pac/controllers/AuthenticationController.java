package com.pac.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pac.security.JwtTokenProvider;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    private JwtTokenProvider jwtTokenProvider;
}

package com.pac.controllers;

import com.pac.dao.UserDTO;
import com.pac.dao.UserRepository;
import com.pac.exceptions.NoSuchUserException;
import com.pac.model.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@RestController
@RequestMapping("api/user")
public class UserController {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @ApiOperation(value = "Find all users")
    @GetMapping("/")
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @ApiOperation(value = "Add user")
    @PutMapping("/")
    public User addUser(@Valid @RequestBody UserDTO userDTO) {
        User user = new User();
        user.setRole(userDTO.getRole());
        user.setEmail(userDTO.getEmail());
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        return userRepository.save(user);
    }

    @Pattern(regexp = "#^[0-9]+$#")
    @NotNull
    @ApiOperation(value = "Find user by id")
    @GetMapping("/{id}")
    public User findUser(@PathVariable Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchUserException::new);
    }
}

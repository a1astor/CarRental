package com.pac.dao;

import com.pac.model.secutiry.Role;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class UserDTO {
    @NotNull
    private String name;
    private String surname;
    @NotNull
    @Email
    private String email;
    @NotNull
    private Role role;
    @NotNull
    private String password;
}

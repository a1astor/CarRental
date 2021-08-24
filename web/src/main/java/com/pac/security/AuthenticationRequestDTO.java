package com.pac.security;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AuthenticationRequestDTO {
    @Email
    private String email;
    @NotNull
    private String password;
}

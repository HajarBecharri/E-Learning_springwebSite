package com.example.User.dto;

import lombok.Data;

@Data
public class AuthenticationDTO {
    private String email;

    private String password;

    private String role;
}

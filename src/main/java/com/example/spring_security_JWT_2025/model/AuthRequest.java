package com.example.spring_security_JWT_2025.model;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
}
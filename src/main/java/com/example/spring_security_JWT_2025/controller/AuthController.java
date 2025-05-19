package com.example.spring_security_JWT_2025.controller;

import com.example.spring_security_JWT_2025.JwtUtil;
import com.example.spring_security_JWT_2025.model.AuthRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        // In real use case, validate against DB
        if ("admin".equals(authRequest.getUsername()) && "password".equals(authRequest.getPassword())) {
            List<String> roles = List.of("ROLE_USER");
            String token = jwtUtil.generateToken(authRequest.getUsername(), roles);
            return ResponseEntity.ok(Map.of("token", token));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }
}

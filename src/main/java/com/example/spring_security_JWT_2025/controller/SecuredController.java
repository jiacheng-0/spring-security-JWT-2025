package com.example.spring_security_JWT_2025.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecuredController {
    @GetMapping("/secured/data")
    public String securedData() {
        return "You have access to secured data!";
    }
}

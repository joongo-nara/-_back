package com.example.minsuck.controller;

import com.example.minsuck.DTO.AuthDto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(new RegisterResponse(1L, "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(new LoginResponse("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."));
    }
}
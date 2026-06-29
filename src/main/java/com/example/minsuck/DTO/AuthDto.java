package com.example.minsuck.DTO;

public class AuthDto {
    public record RegisterRequest(String nickname, String rank, String militaryUnit, String classType, String password) {}
    public record RegisterResponse(Long userId, String token) {}

    public record LoginRequest(String username, String password) {}
    public record LoginResponse(String token) {}
}
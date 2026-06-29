package com.example.minsuck.service;

import com.example.minsuck.DTO.AuthDto.*;
import com.example.minsuck.domain.User;
import com.example.minsuck.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthService {
    private final UserRepository userRepository;

    public RegisterResponse register(RegisterRequest request) {
        User user = User.builder().nickname(request.nickname()).rank(request.rank()).militaryUnit(request.militaryUnit()).classType(request.classType()).build();
        userRepository.save(user);
        return new RegisterResponse(user.getId(), "TOKEN_SUCCESS");
    }

    public LoginResponse login(LoginRequest request) {
        return new LoginResponse("TOKEN_SUCCESS");
    }
}
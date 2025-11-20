package com.example.EmployeeManagerServer.controller;

import org.springframework.web.bind.annotation.*;
import com.example.EmployeeManagerServer.dto.RegisterRequest;
import com.example.EmployeeManagerServer.service.UserService;
import com.example.EmployeeManagerServer.dto.LoginRequest;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // Регистрация нового пользователя
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
        return userService.registerUser(registerRequest);
    }

    // Логин существующего пользователя
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        return userService.loginUser(loginRequest);
    }
}

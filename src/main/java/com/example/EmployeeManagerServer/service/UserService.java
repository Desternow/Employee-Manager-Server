package com.example.EmployeeManagerServer.service;

import com.example.EmployeeManagerServer.dto.LoginRequest;
import com.example.EmployeeManagerServer.dto.RegisterRequest;
import com.example.EmployeeManagerServer.dto.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.EmployeeManagerServer.model.User;
import com.example.EmployeeManagerServer.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public ResponseEntity<?> registerUser(RegisterRequest registerRequest) {
        Optional<User> existing = userRepository.findByEmail(registerRequest.getEmail());
        if (existing.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Пользователь с такой почтой уже существует");
            // 409 - конфликт, пользователь существует
        }

        String hashedPassword = passwordEncoder.encode(registerRequest.getPassword());

        User user = new User(
                registerRequest.getFirstName(),
                registerRequest.getLastName(),
                registerRequest.getEmail(),
                hashedPassword
        );

        userRepository.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).body("Регистрация успешна");
        // 201 - создано
    }

    public ResponseEntity<?> loginUser(LoginRequest loginRequest) {
        Optional<User> optionalUser = userRepository.findByEmail(loginRequest.getEmail());

        if (optionalUser.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Пользователь не найден");
            // 401 - не авторизован, пользователь не найден
        }

        User user = optionalUser.get();

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getHashPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Неверный пароль");
            // 401 - не авторизован, неверный пароль
        }

        return ResponseEntity.ok(new UserResponse(user));
    }
}
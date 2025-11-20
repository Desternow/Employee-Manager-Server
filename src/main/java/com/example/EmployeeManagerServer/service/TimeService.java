package com.example.EmployeeManagerServer.service;

import com.example.EmployeeManagerServer.dto.TimeEntryRequest;
import com.example.EmployeeManagerServer.dto.TimeEntryResponse;
import com.example.EmployeeManagerServer.dto.UserResponse;
import com.example.EmployeeManagerServer.model.TimeEntry;
import com.example.EmployeeManagerServer.model.User;
import com.example.EmployeeManagerServer.repository.TimeEntryRepository;
import com.example.EmployeeManagerServer.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TimeService {

    private final TimeEntryRepository timeEntryRepository;
    private final UserRepository userRepository;

    public TimeService(TimeEntryRepository timeEntryRepository, UserRepository userRepository) {
        this.timeEntryRepository = timeEntryRepository;
        this.userRepository = userRepository;
    }

    public ResponseEntity<?> addTimeEntry(TimeEntryRequest request) {
        Optional<User> optionalUser = userRepository.findById(request.getUserId());
        if (optionalUser.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Пользователь не найден");
            // 404 - пользователь не найден
        }

        User user = optionalUser.get();

        TimeEntry entry = new TimeEntry();
        entry.setUser(user);
        entry.setDate(request.getDate());
        entry.setTime(request.getTime());
        entry.setType(request.getType());

        timeEntryRepository.save(entry);

        return ResponseEntity.status(HttpStatus.CREATED).body("Отметка времени успешно добавлена");
        // 201 - создано
    }

    public ResponseEntity<?> getEntriesForUserAndDate(Long userId, String dateStr) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Пользователь не найден");
        }

        User user = optionalUser.get();
        LocalDate date;

        try {
            date = LocalDate.parse(dateStr); // ожидаемый формат "yyyy-MM-dd"
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Неверный формат даты");
            // 400 - неверный формат
        }

        List<TimeEntry> entries = timeEntryRepository.findByUserAndDate(user, date);
        List<TimeEntryResponse> response = entries.stream().map(TimeEntryResponse::new).toList();

        return ResponseEntity.ok(response);

    }
}

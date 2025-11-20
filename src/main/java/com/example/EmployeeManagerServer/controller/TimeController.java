package com.example.EmployeeManagerServer.controller;

import com.example.EmployeeManagerServer.dto.TimeEntryRequest;
import com.example.EmployeeManagerServer.service.TimeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/time")
public class TimeController {

    private final TimeService timeService;

    public TimeController(TimeService timeService) {
        this.timeService = timeService;
    }

    // Добавить отметку времени (приход, перерыв, уход)
    @PostMapping("/add")
    public ResponseEntity<?> addTimeEntry(@RequestBody TimeEntryRequest request) {
        return timeService.addTimeEntry(request);
    }

    // Получить все отметки пользователя на определённую дату
    @GetMapping("/user/{userId}/date/{date}")
    public ResponseEntity<?> getEntriesForUserAndDate(@PathVariable Long userId, @PathVariable String date) {
        return timeService.getEntriesForUserAndDate(userId, date);
    }
}

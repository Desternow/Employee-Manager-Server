package com.example.EmployeeManagerServer.dto;

import com.example.EmployeeManagerServer.model.TimeType;

import java.time.LocalDate;
import java.time.LocalTime;

public class TimeEntryRequest {
    private Long userId;
    private LocalDate date;
    private LocalTime time;
    private TimeType type;

    // getters
    public Long getUserId() {
        return userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public TimeType getType() {
        return type;
    }

    // setters
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public void setType(TimeType type) {
        this.type = type;
    }
}

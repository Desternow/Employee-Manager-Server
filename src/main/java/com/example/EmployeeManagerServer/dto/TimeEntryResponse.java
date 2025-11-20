package com.example.EmployeeManagerServer.dto;

import com.example.EmployeeManagerServer.model.TimeType;
import com.example.EmployeeManagerServer.model.TimeEntry;

import java.time.LocalDate;
import java.time.LocalTime;

public class TimeEntryResponse {

    private Long id;
    private UserResponse user;
    private LocalDate date;
    private LocalTime time;
    private TimeType type;

    public TimeEntryResponse() {}

    public TimeEntryResponse(Long id, UserResponse user, LocalDate date, LocalTime time, TimeType type) {
        this.id = id;
        this.user = user;
        this.date = date;
        this.time = time;
        this.type = type;
    }

    public TimeEntryResponse(TimeEntry entry) {
        this.id = entry.getId();
        this.user = new UserResponse(entry.getUser());
        this.date = entry.getDate();
        this.time = entry.getTime();
        this.type = entry.getType();
    }

    // getters
    public Long getId() {
        return id;
    }

    public UserResponse getUser() {
        return user;
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
    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(UserResponse user) {
        this.user = user;
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

package com.example.EmployeeManagerServer.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "time_entries")
public class TimeEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private LocalDate date; // дата события
    private LocalTime time; // время события

    @Enumerated(EnumType.STRING)
    private TimeType type;  // WORK, BREAK, LEAVE

    // getters
    public Long getId() {
        return id;
    }

    public User getUser() {
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
    public void setUser(User newUser) {
        this.user = newUser;
    }

    public void setDate(LocalDate newDate) {
        this.date = newDate;
    }

    public void setTime(LocalTime newTime) {
        this.time = newTime;
    }

    public void setType(TimeType newType) {
        this.type = newType;
    }
}
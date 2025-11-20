package com.example.EmployeeManagerServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.EmployeeManagerServer.model.TimeEntry;
import com.example.EmployeeManagerServer.model.User;
import java.time.LocalDate;
import java.util.List;

public interface TimeEntryRepository extends JpaRepository<TimeEntry, Long> {
    List<TimeEntry> findByUserAndDate(User user, LocalDate date);
}

package com.example.EmployeeManagerServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.EmployeeManagerServer.model.Role;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(String name);
}
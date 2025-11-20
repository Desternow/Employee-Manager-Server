package com.example.EmployeeManagerServer.service;

import com.example.EmployeeManagerServer.model.Role;
import com.example.EmployeeManagerServer.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    // методы для получения роли по имени, создания новых ролей и т.д.
}

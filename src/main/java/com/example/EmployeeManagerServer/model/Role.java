package com.example.EmployeeManagerServer.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String roleName; // "чот типо EMPLOYEE", "HR", "MANAGER", "ACCOUNTANT..."

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Role() {}

    public Role(String roleName) {
        this.roleName = roleName;
    }

    // getters
    public Long getId() {
        return id;
    }

    public String getRoleName() {
        return roleName;
    }

    // setters
    public void setRoleName(String newRoleName) {
        this.roleName = newRoleName;
    }
}

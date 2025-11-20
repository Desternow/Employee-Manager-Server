package com.example.EmployeeManagerServer.dto;

public class LoginRequest {
    private String email;
    private String password;

    public LoginRequest() {}

    // getters
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    // setters
    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


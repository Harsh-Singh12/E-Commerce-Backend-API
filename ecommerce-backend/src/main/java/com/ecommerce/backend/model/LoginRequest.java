package com.ecommerce.backend.model;


import lombok.Data;
import lombok.Setter;
;

@Setter
public class LoginRequest {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
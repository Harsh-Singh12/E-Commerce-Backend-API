package com.ecommerce.backend.controller;

import com.ecommerce.backend.model.RegisterRequest;
import com.ecommerce.backend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request){
        String token = userService.register(
                request.getUsername(),
                request.getEmail(),
                request.getPassword());
                return ResponseEntity.ok(Collections.singletonMap("token",token));
    }
}

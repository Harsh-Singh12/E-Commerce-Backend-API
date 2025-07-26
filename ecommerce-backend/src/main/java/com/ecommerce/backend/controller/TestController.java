package com.ecommerce.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {
    @GetMapping("/secure")
    public ResponseEntity<String> secureHello() {
        return ResponseEntity.ok("✅ Secured content!");
    }
}
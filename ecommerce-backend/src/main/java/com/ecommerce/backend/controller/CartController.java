package com.ecommerce.backend.controller;

import com.ecommerce.backend.dto.CartItemDTO;
import com.ecommerce.backend.repository.UserRepository;
import com.ecommerce.backend.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private  RedisService redisService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/add")
    public ResponseEntity<String> addToCart(
            @RequestBody CartItemDTO item,
            @AuthenticationPrincipal UserDetails userDetails) {

        Long userId = getUserId(userDetails);
        redisService.addToCart(userId, item);
        return ResponseEntity.ok("Item added to cart");
    }

    @GetMapping
    public ResponseEntity<Map<Object, Object>> getCart(@AuthenticationPrincipal UserDetails userDetails) {
        Long userId = getUserId(userDetails);
        return ResponseEntity.ok(redisService.getCart(userId));
    }

    @DeleteMapping("/remove/{productId}")
    public ResponseEntity<String> removeFromCart(
            @PathVariable Long productId,
            @AuthenticationPrincipal UserDetails userDetails) {

        Long userId = getUserId(userDetails);
        redisService.removeFromCart(userId, productId);
        return ResponseEntity.ok("Item removed from cart");
    }

    private Long getUserId(UserDetails userDetails) {
        String email = userDetails.getUsername();
        return userRepository.findByEmail(email)
                .orElseThrow(()-> new RuntimeException("User not Found"))
                .getId();
    }
}

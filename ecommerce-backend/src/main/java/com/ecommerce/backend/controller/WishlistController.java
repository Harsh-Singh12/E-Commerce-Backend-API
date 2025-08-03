package com.ecommerce.backend.controller;

import com.ecommerce.backend.model.User;
import com.ecommerce.backend.repository.UserRepository;
import com.ecommerce.backend.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/wishlist")
public class WishlistController {

    @Autowired
    private  WishlistService wishlistService;
    @Autowired
    private  UserRepository userRepository;

    @PostMapping("/add/{productId}")
    public ResponseEntity<String> addToWishlist(@PathVariable Long productId,
                                                @AuthenticationPrincipal UserDetails userDetails) {
        Long userId = getUserId(userDetails);
        wishlistService.addToWishlist(userId, productId);
        return ResponseEntity.ok("Item added to wishlist");
    }

    @GetMapping
    public ResponseEntity<Set<Object>> getWishlist(@AuthenticationPrincipal UserDetails userDetails) {
        Long userId = getUserId(userDetails);
        return ResponseEntity.ok(wishlistService.getWishlist(userId));
    }

    @DeleteMapping("/remove/{productId}")
    public ResponseEntity<String> removeFromWishlist(@PathVariable Long productId,
                                                     @AuthenticationPrincipal UserDetails userDetails) {
        Long userId = getUserId(userDetails);
        wishlistService.removeFromWishlist(userId, productId);
        return ResponseEntity.ok("Item removed from wishlist");
    }

    private Long getUserId(UserDetails userDetails) {
        String email = userDetails.getUsername();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return user.getId();
    }
}

package com.ecommerce.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class WishlistService {

    @Autowired
    private  RedisTemplate<String, Object> redisTemplate;

    private String getWishlistKey(Long userId) {
        return "wishlist:" + userId;
    }

    public void addToWishlist(Long userId, Long productId) {
        redisTemplate.opsForSet().add(getWishlistKey(userId), productId);
    }

    public Set<Object> getWishlist(Long userId) {
        return redisTemplate.opsForSet().members(getWishlistKey(userId));
    }

    public void removeFromWishlist(Long userId, Long productId) {
        redisTemplate.opsForSet().remove(getWishlistKey(userId), productId);
    }
}

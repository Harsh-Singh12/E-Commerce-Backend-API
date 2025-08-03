package com.ecommerce.backend.service;

import com.ecommerce.backend.dto.CartItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RedisService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private String getCartKey(Long userId) {
        return "cart:" + userId;
    }

    public void addToCart(Long userId, CartItemDTO item) {
        String key = getCartKey(userId);
        Map<Object, Object> cart = redisTemplate.opsForHash().entries(key);
        int quantity = item.getQuantity();
        if (cart.containsKey(item.getProductId().toString())) {
            quantity += Integer.parseInt(cart.get(item.getProductId().toString()).toString());
        }
        redisTemplate.opsForHash().put(key, item.getProductId().toString(), quantity);
    }

    public Map<Object, Object> getCart(Long userId) {
        String key = getCartKey(userId);
        return redisTemplate.opsForHash().entries(key);
    }

    public void removeFromCart(Long userId, Long productId) {
        String key = getCartKey(userId);
        redisTemplate.opsForHash().delete(key, productId.toString());
    }
}

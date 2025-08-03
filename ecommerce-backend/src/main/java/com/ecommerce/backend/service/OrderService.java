package com.ecommerce.backend.service;

import com.ecommerce.backend.model.Order;
import com.ecommerce.backend.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    @Autowired
    private  OrderRepository orderRepository;
    @Autowired
    private  RedisTemplate<String, Object> redisTemplate;

    public Order placeOrder(Long userId) {
        String cartKey = "cart:" + userId;
        Map<Object, Object> cartItems = redisTemplate.opsForHash().entries(cartKey);

        List<Long> productIds = new ArrayList<>();
        for (Object key : cartItems.keySet()) {
            productIds.add(Long.valueOf(key.toString()));
        }

        Order order = new Order();
        order.setUserId(userId);
        order.setOrderDate(new Date());
        order.setProductIds(productIds);

        redisTemplate.delete(cartKey); // clear cart
        return orderRepository.save(order);
    }

    public List<Order> getOrders(Long userId) {
        return orderRepository.findByUserId(userId);
    }
}

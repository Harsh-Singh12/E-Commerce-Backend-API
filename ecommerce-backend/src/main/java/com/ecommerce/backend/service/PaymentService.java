package com.ecommerce.backend.service;

import com.ecommerce.backend.dto.PaymentRequest;
import com.ecommerce.backend.dto.PaymentResponse;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentService {
    public PaymentResponse process(PaymentRequest request) {
        if (request.getAmount() > 0) {
            return new PaymentResponse(true, UUID.randomUUID().toString(), "Payment successful");
        } else {
            return new PaymentResponse(false, null, "Invalid payment amount");
        }
    }
}

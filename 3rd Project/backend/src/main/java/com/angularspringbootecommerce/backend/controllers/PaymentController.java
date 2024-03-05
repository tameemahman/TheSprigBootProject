package com.angularspringbootecommerce.backend.controllers;

import com.angularspringbootecommerce.backend.services.PaymentService;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/create-payment-intent")
    public ResponseEntity<?> createPaymentIntent(@RequestBody BigDecimal amount) {
        try {
            PaymentIntent paymentIntent = paymentService.createPaymentIntent(amount);
            return ResponseEntity.ok(paymentIntent);
        } catch (StripeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating payment intent: " + e.getMessage());
        }
    }
}

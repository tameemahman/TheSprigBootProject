package com.angularspringbootecommerce.backend.controllers;

import com.angularspringbootecommerce.backend.models.PaymentMethod;
import com.angularspringbootecommerce.backend.services.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/payment-methods")
public class PaymentMethodController {

    private final PaymentMethodService paymentMethodService;

    @Autowired
    public PaymentMethodController(PaymentMethodService paymentMethodService) {
        this.paymentMethodService = paymentMethodService;
    }

    @PostMapping(".")
    public ResponseEntity<PaymentMethod> createPaymentMethod(@RequestBody PaymentMethod paymentMethod) {
        PaymentMethod createdPaymentMethod = paymentMethodService.savePaymentMethod(paymentMethod);
        return new ResponseEntity<>(createdPaymentMethod, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PaymentMethod>> getAllPaymentMethods() {
        List<PaymentMethod> paymentMethods = paymentMethodService.getAllPaymentMethods();
        return new ResponseEntity<>(paymentMethods, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentMethod> getPaymentMethodById(@PathVariable Long id) {
        Optional<PaymentMethod> paymentMethod = paymentMethodService.getPaymentMethodById(id);
        return paymentMethod.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentMethod> updatePaymentMethod(@PathVariable Long id, @RequestBody PaymentMethod updatedPaymentMethod) {
        PaymentMethod updatedMethod = paymentMethodService.updatePaymentMethod(id, updatedPaymentMethod);
        if (updatedMethod != null) {
            return new ResponseEntity<>(updatedMethod, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaymentMethod(@PathVariable Long id) {
        paymentMethodService.deletePaymentMethod(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

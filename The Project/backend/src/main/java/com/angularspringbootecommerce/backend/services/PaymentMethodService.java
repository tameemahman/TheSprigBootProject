package com.angularspringbootecommerce.backend.services;

import com.angularspringbootecommerce.backend.models.PaymentMethod;
import com.angularspringbootecommerce.backend.repository.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentMethodService {

    private final PaymentMethodRepository paymentMethodRepository;

    @Autowired
    public PaymentMethodService(PaymentMethodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }

    // Method to save a payment method
    public PaymentMethod savePaymentMethod(PaymentMethod paymentMethod) {
        return paymentMethodRepository.save(paymentMethod);
    }

    // Method to retrieve all payment methods
    public List<PaymentMethod> getAllPaymentMethods() {
        return paymentMethodRepository.findAll();
    }

    // Method to retrieve a payment method by ID
    public Optional<PaymentMethod> getPaymentMethodById(Long id) {
        return paymentMethodRepository.findById(id);
    }

    // Method to update a payment method
    public PaymentMethod updatePaymentMethod(Long id, PaymentMethod updatedPaymentMethod) {
        if (paymentMethodRepository.existsById(id)) {
            updatedPaymentMethod.setId(id);
            return paymentMethodRepository.save(updatedPaymentMethod);
        }
        return null; // Or throw an exception indicating the entity does not exist
    }

    // Method to delete a payment method
    public void deletePaymentMethod(Long id) {
        paymentMethodRepository.deleteById(id);
    }
}

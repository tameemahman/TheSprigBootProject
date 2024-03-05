package com.angularspringbootecommerce.backend.services;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Value("${stripe.secret-key}")
    private String stripeSecretKey;

    public PaymentIntent createPaymentIntent(BigDecimal amount) throws StripeException {
        // Set the Stripe API key
        Stripe.apiKey = stripeSecretKey;

        // Create parameters for the payment intent
        Map<String, Object> params = new HashMap<>();
        // Convert amount to the smallest currency unit (e.g., cents for USD)
        long amountInCents = amount.multiply(BigDecimal.valueOf(100)).longValueExact();
        params.put("amount", amountInCents);
        // Set the currency (e.g., "usd", "eur", "gbp")
        params.put("currency", "usd"); // Adjust this based on your requirements
        // Set the payment method types
        params.put("payment_method_types", Collections.singletonList("card")); // Add more types if needed

        // Create and return the payment intent
        return PaymentIntent.create(params);
    }
}

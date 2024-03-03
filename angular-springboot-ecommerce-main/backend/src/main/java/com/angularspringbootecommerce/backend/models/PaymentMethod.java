package com.angularspringbootecommerce.backend.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class PaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String country;
    private String addressLine1;
    private String addressLine2;
    private String postcode;
    private String city;
    private String phone;
    private String email;
    private String additionalInfo;
    private String amountPayable;
    private String shipping;
    private String totalAmount;

    // Generate Getters and Setters
    // You can generate these using your IDE or manually write them
}

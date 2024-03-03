package com.angularspringbootecommerce.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



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
    private double amountPayable;
    private String shipping;
    private double totalAmount;

    // Constructors, getters, and setters

    public PaymentMethod() {
    }

    public PaymentMethod(String firstName, String lastName, String country, String addressLine1, String addressLine2, String postcode, String city, String phone, String email, String additionalInfo, double amountPayable, String shipping, double totalAmount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.postcode = postcode;
        this.city = city;
        this.phone = phone;
        this.email = email;
        this.additionalInfo = additionalInfo;
        this.amountPayable = amountPayable;
        this.shipping = shipping;
        this.totalAmount = totalAmount;
    }

    public void setId(Long id) {
    }

    // Getters and setters
}


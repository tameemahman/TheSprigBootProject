package com.bootproject.H.B.model;

import lombok.Data;

@Data
public class BillingDetails {
    private String firstName;
    private String lastName;
    private String country;
    private String addressLine1;
    private String addressLine2;
    private String postcode;
    private String city;
    private String phone;
    private String emailAddress;
    private String additionalInformation;
    private double totalAmount;
    private double amountPayable;
    private double shipping;
    private double totalAmountIncludingVAT;
}

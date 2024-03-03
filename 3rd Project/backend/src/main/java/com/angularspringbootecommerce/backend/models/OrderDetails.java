//package com.angularspringbootecommerce.backend.models;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//
//
//@Entity
//public class OrderDetails {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String firstName;
//    private String lastName;
//    private String country;
//    private String addressLine1;
//    private String addressLine2;
//    private String postalCode;
//    private String city;
//    private String phone;
//    private String emailAddress;
//    private String additionalInformation;
//    private double total;
//
//    // Getters and setters
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getCountry() {
//        return country;
//    }
//
//    public void setCountry(String country) {
//        this.country = country;
//    }
//
//    public String getAddressLine1() {
//        return addressLine1;
//    }
//
//    public void setAddressLine1(String addressLine1) {
//        this.addressLine1 = addressLine1;
//    }
//
//    public String getAddressLine2() {
//        return addressLine2;
//    }
//
//    public void setAddressLine2(String addressLine2) {
//        this.addressLine2 = addressLine2;
//    }
//
//    public String getPostalCode() {
//        return postalCode;
//    }
//
//    public void setPostalCode(String postalCode) {
//        this.postalCode = postalCode;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    public String getEmailAddress() {
//        return emailAddress;
//    }
//
//    public void setEmailAddress(String emailAddress) {
//        this.emailAddress = emailAddress;
//    }
//
//    public String getAdditionalInformation() {
//        return additionalInformation;
//    }
//
//    public void setAdditionalInformation(String additionalInformation) {
//        this.additionalInformation = additionalInformation;
//    }
//
//    public double getTotal() {
//        return total;
//    }
//
//    public void setTotal(double total) {
//        this.total = total;
//    }
//}


package com.angularspringbootecommerce.backend.models;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String country;
    private String addressLine1;
    private String addressLine2;
    private String postalCode;
    private String city;
    private String phone;
    private String emailAddress;
    private String additionalInformation;
    private double total;

    // Constructors, getters, and setters

    public OrderDetails() {
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    private  User user;

    public OrderDetails(String firstName, String lastName, String country, String addressLine1, String addressLine2,
                        String postalCode, String city, String phone, String emailAddress, String additionalInformation,
                        double total) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.postalCode = postalCode;
        this.city = city;
        this.phone = phone;
        this.emailAddress = emailAddress;
        this.additionalInformation = additionalInformation;
        this.total = total;
    }


}

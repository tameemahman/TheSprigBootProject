package com.bootproject.H.B.restcontroller;

import com.bootproject.H.B.model.BillingDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/billing")
public class BillingDetailsRestController {

    @PostMapping("/details")
    public ResponseEntity<String> saveBillingDetails(@RequestBody BillingDetails billingDetails) {

        return new ResponseEntity<>("Billing details saved successfully", HttpStatus.OK);
    }

    @GetMapping("/details")
    public ResponseEntity<BillingDetails> getBillingDetails() {

        BillingDetails sampleBillingDetails = new BillingDetails();
        sampleBillingDetails.setFirstName("John");
        sampleBillingDetails.setLastName("Doe");


        return new ResponseEntity<>(sampleBillingDetails, HttpStatus.OK);
    }

    @PutMapping("/details/{id}")
    public ResponseEntity<String> updateBillingDetails(@PathVariable Long id, @RequestBody BillingDetails billingDetails) {

        return new ResponseEntity<>("Billing details updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/details/{id}")
    public ResponseEntity<String> deleteBillingDetails(@PathVariable Long id) {
        
        return new ResponseEntity<>("Billing details deleted successfully", HttpStatus.OK);
    }
}

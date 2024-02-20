package com.bootproject.H.B.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderRestController {

    @GetMapping("/order")
    public String showOrderPage(Model model) {
        // Assuming you have calculated total and cartCount somewhere
        int total = 100; // Sample total amount
        int cartCount = 5; // Sample cart count

        // Adding data to the model to be accessed in Thymeleaf template
        model.addAttribute("total", total);
        model.addAttribute("cartCount", cartCount);

        // Return a simple message indicating the order page is shown
        return "Order page is shown";
    }

    @PostMapping("/order")
    public ResponseEntity<String> processOrder(@RequestBody String orderDetails) {
        // Process the order details received in the request body
        // For example, you can save the order to the database

        // Return a success response with HTTP status 200 OK
        return new ResponseEntity<>("Order processed successfully", HttpStatus.OK);
    }
}

//package com.bootproject.H.B.restcontroller;
//
//import com.bootproject.H.B.model.User;
//import com.bootproject.H.B.repository.IUserRepository;
//import com.bootproject.H.B.repository.ProductRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/user")
//@CrossOrigin("*")
//public class UserRestController {
//    @Autowired
//    private IUserRepository userRepository;
//
//    @Autowired
//    private ProductRepository productRepository;
//
//    @GetMapping("")
//    public List<User> allUser(){
//        return userRepository.findAll();
//    }}
//
package com.bootproject.H.B.restcontroller;

import com.bootproject.H.B.model.User;
import com.bootproject.H.B.repository.IUserRepository;
import com.bootproject.H.B.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserRestController {
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("")
    public List<User> allUser() {
        return userRepository.findAll();
    }

    @PostMapping("")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        // Implement logic to create a new user
        // You can save the user to the repository and return an appropriate response
        // Example:
        // userRepository.save(user);
        // return ResponseEntity.ok(user);

        // Replace the above example with your actual implementation
        return ResponseEntity.status(501).build(); // Not Implemented
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        // Implement logic to update an existing user by ID
        // You can find the user by ID, update its properties, and save it back to the repository
        // Example:
        // User existingUser = userRepository.findById(id).orElse(null);
        // if (existingUser != null) {
        //     existingUser.setName(updatedUser.getName());
        //     // Update other properties as needed
        //     userRepository.save(existingUser);
        //     return ResponseEntity.ok(existingUser);
        // } else {
        //     return ResponseEntity.notFound().build();
        // }

        // Replace the above example with your actual implementation
        return ResponseEntity.status(501).build(); // Not Implemented
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        // Implement logic to delete a user by ID
        // You can find the user by ID and delete it from the repository
        // Example:
        // User existingUser = userRepository.findById(id).orElse(null);
        // if (existingUser != null) {
        //     userRepository.delete(existingUser);
        //     return ResponseEntity.noContent().build();
        // } else {
        //     return ResponseEntity.notFound().build();
        // }

        // Replace the above example with your actual implementation
        return ResponseEntity.status(501).build(); // Not Implemented
    }

    // Add other endpoints (GET by ID, etc.) as needed
}

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
    public List<User> allUser(){
        return userRepository.findAll();
    }}


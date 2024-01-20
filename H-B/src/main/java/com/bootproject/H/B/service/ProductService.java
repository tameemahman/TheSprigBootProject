package com.bootproject.H.B.service;


import com.bootproject.H.B.model.Product;
import com.bootproject.H.B.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProduct() {
        return productRepository.findAll();

    }

    public void removeProductById(long id) {
    }


}

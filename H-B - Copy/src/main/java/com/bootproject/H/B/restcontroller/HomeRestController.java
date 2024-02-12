package com.bootproject.H.B.restcontroller;


import com.bootproject.H.B.model.Product;
import com.bootproject.H.B.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
//@CrossOrigin
public class HomeRestController {

    @Autowired
    ProductRepository productRepository;
    @GetMapping("/product")
    public List<Product> allPro(){
        return  productRepository.findAll();
    }
    @PostMapping("/product")
    public  Product saveProduct(@RequestBody Product product){
        return  productRepository.save(product);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id){
        boolean exist = productRepository.existsById((long) id);
        if (exist){
            productRepository.deleteById((long) id);
            return  new ResponseEntity<>("Product is deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>("Product is not exist", HttpStatus.BAD_REQUEST);
    }
    @PutMapping("/product/{id}")
    public  ResponseEntity<String> update(@PathVariable("id")int id, @RequestBody Product product){
        boolean exist=productRepository.existsById((long) id);
        if (exist){
            Product product1=productRepository.getById((long) id);
            product1.setName(product.getName());
            product1.setId((long) id);
            productRepository.save(product);
            return new ResponseEntity<>("Product is updated", HttpStatus.OK);
        }
        return  new ResponseEntity<>("Product is not Exist", HttpStatus.BAD_REQUEST);
    }
}

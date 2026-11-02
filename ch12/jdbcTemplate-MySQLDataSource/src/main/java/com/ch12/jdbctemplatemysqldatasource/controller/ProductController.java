package com.ch12.jdbctemplatemysqldatasource.controller;

import com.ch12.jdbctemplatemysqldatasource.model.Product;
import com.ch12.jdbctemplatemysqldatasource.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @PostMapping("/product")
    public ResponseEntity<String> addProduct(@RequestBody Product product){
        productRepository.addProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Product added successfully");
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productRepository.getAllProducts();
    }
}

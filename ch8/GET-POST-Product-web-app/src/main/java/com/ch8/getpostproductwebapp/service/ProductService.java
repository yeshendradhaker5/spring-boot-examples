package com.ch8.getpostproductwebapp.service;

import com.ch8.getpostproductwebapp.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();

    public List<Product> addProduct(Product p){
        products.add(p);
        return products;
    }

    public List<Product> getAllProducts(){
        return products;
    }

}

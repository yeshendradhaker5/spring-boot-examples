package com.ch8.getpostproductwebapp.controller;

import com.ch8.getpostproductwebapp.model.Product;
import com.ch8.getpostproductwebapp.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/products")
    public String getAllProducts(Model productPage){

       List<Product> listOfProducts = productService.getAllProducts();
        productPage.addAttribute("products", listOfProducts);
        return "products.html";
    }

    @PostMapping("/add/product")
    public String addProduct(Product p,
                             Model productPage){
        List<Product> listOfProducts = productService.addProduct(p);
        productPage.addAttribute("products", listOfProducts);
        return "products.html";
    }

}

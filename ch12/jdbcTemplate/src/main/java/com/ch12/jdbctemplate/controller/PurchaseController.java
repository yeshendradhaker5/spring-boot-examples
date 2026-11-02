package com.ch12.jdbctemplate.controller;

import com.ch12.jdbctemplate.model.Purchase;
import com.ch12.jdbctemplate.repository.PurchaseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PurchaseController {

    private final PurchaseRepository purchaseRepository;

    public PurchaseController(PurchaseRepository purchaseRepository){
        this.purchaseRepository = purchaseRepository;
    }

    @PostMapping("/add-record")
    public ResponseEntity<String> addPurchase(@RequestBody Purchase purchase){
        purchaseRepository.addPurchase(purchase);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Purchase record inserted");
    }

    @GetMapping("/purchases")
    public List<Purchase> findAllPurchases(){
        return purchaseRepository.findAllPurchases();
    }
}

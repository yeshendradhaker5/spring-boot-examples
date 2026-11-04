package com.ch15.unitesting_annotation.model;

import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

public class Account {
    @Id
    private Long id;
    private String name;
    private BigDecimal balance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

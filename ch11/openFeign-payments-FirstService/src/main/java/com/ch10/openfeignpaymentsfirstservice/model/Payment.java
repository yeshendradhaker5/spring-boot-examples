package com.ch10.openfeignpaymentsfirstservice.model;

public class Payment {
    private String pId;
    private int amount;

    public String getPId() {
        return pId;
    }

    public void setPId(String pId) {
        this.pId = pId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

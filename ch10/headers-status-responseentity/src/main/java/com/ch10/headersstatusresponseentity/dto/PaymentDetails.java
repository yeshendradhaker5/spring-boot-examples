package com.ch10.headersstatusresponseentity.dto;

public class PaymentDetails {

    private String paymentId;
    private Long amount;

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}

package com.example.mobiletest;

public class UpdateWallet {
    private String senderId , recipientId;
    private Double moneyUsed ;

    public UpdateWallet(String senderId, String recipientId, Double moneyUsed) {
        this.senderId = senderId;
        this.recipientId = recipientId;
        this.moneyUsed = moneyUsed;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(String recipientId) {
        this.recipientId = recipientId;
    }

    public Double getMoneyUsed() {
        return moneyUsed;
    }

    public void setMoneyUsed(Double moneyUsed) {
        this.moneyUsed = moneyUsed;
    }
}

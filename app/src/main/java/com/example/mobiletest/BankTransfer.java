package com.example.mobiletest;

import java.io.Serializable;

public class BankTransfer implements Serializable {
    private String sender , recipient , infomationBank , _id , createdAt , updatedAt ;
    private Double moneyBank ;
    private Integer __v;



    public BankTransfer(String sender, String recipient, String infomationBank, Double moneyBank) {
        this.sender = sender;
        this.recipient = recipient;
        this.infomationBank = infomationBank;
        this.moneyBank = moneyBank;
    }
    public BankTransfer(String _id , String sender, String recipient, String infomationBank, Double moneyBank , String createdAt , String updatedAt) {
        this._id = _id ;
        this.sender = sender;
        this.recipient = recipient;
        this.infomationBank = infomationBank;
        this.moneyBank = moneyBank;
        this.createdAt = createdAt ;
        this.updatedAt = updatedAt ;
    }

    public BankTransfer(String _id){
        this._id = _id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getInfomationBank() {
        return infomationBank;
    }

    public void setInfomationBank(String infomationBank) {
        this.infomationBank = infomationBank;
    }

    public Double getMoneyBank() {
        return moneyBank;
    }

    public void setMoneyBank(Double moneyBank) {
        this.moneyBank = moneyBank;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer get__v() {
        return __v;
    }

    public void set__v(Integer __v) {
        this.__v = __v;
    }
}

package com.example.mobiletest;

import java.io.Serializable;

public class BankTransfer implements Serializable {
    private String date ;
    private Double money , remainder;
    private Integer numberId ;

    public BankTransfer(String date, Double money, Double remainder, Integer numberId) {
        this.date = date;
        this.money = money;
        this.remainder = remainder;
        this.numberId = numberId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Double getRemainder() {
        return remainder;
    }

    public void setRemainder(Double remainder) {
        this.remainder = remainder;
    }

    public Integer getNumberId() {
        return numberId;
    }

    public void setNumberId(Integer numberId) {
        this.numberId = numberId;
    }
}

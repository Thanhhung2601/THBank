package com.example.mobiletest;

import java.io.Serializable;

public class User implements Serializable {
    private String phone , userName , password ,confirmPassword;
    private Double money;

    public User(String phone, String userName, String password , String confirmPassword ,Double money ){
       this.phone = phone ;
       this.userName = userName ;
       this.password = password;
       this.confirmPassword = confirmPassword;
       this.money = money ;
    }

    public User(String phone, String userName, String password , Double money) {
        this.phone = phone;
        this.userName = userName;
        this.password = password;
        this.money = money;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}

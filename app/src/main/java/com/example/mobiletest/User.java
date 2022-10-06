package com.example.mobiletest;

import java.io.Serializable;

public class User implements Serializable {
    private String phone , userName , password ;

    public User(String phone, String userName, String password) {
        this.phone = phone;
        this.userName = userName;
        this.password = password;
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


}

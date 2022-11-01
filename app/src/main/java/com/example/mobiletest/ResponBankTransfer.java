package com.example.mobiletest;

import java.util.ArrayList;

public class ResponBankTransfer {
    ArrayList<BankTransfer> dataBankTransfer ;

    public ResponBankTransfer(ArrayList<BankTransfer> dataBankTransfer) {
        this.dataBankTransfer = dataBankTransfer;
    }

    public ArrayList<BankTransfer> getArrBank() {
        return dataBankTransfer;
    }

    public void setArrBank(ArrayList<BankTransfer> dataBankTransfer) {
        this.dataBankTransfer = dataBankTransfer;
    }
}

package com.example.coinnest;

import java.util.Date;

public class Bill {
    private String billName;
    private String amount;
    private Date dueDate;

    public Bill() {
    }

    public Bill(String billName, String amount, Date dueDate) {
        this.billName = billName;
        this.amount = amount;
        this.dueDate = dueDate;
    }

    public String getBillName() {
        return billName;
    }

    public void setBillName(String billName) {
        this.billName = billName;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}

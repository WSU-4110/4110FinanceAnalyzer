package com.example.financeanalyzer;


import java.util.Date;

// define a class to handle receipts
public class Receipt {

    private int receiptID;
    private String storeName;

    private Date date;

    private String category;

    private double price;

    public void receipt(String storeName, Date date, double price) {

        this.storeName = storeName;
        this.date = date;
        this.price = price;

    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStoreName() {
        return storeName;
    }

    public Date getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getReceiptID() {
        return receiptID;
    }
}

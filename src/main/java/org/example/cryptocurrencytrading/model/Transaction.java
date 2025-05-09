package org.example.cryptocurrencytrading.model;

import java.util.Date;

public class Transaction {
    private int id;
    private int userId;
    private String crypto_symbol;
    private double quantity;
    private double price;
    private String type;
    private Date timestamp;

    public Transaction() {
    }

    public Transaction(int userId, String crypto_symbol, double quantity, double price, String type, Date timestamp) {
        this.userId = userId;
        this.crypto_symbol = crypto_symbol;
        this.quantity = quantity;
        this.price = price;
        this.type = type;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCrypto_symbol() {
        return crypto_symbol;
    }

    public void setCrypto_symbol(String crypto_symbol) {
        this.crypto_symbol = crypto_symbol;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}

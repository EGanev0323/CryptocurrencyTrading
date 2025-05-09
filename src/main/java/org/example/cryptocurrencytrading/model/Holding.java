package org.example.cryptocurrencytrading.model;

public class Holding {
    private int id;
    private int userId;
    private String crypto_symbol;
    private double quantity;

    public Holding() {
    }
    public Holding(int userId, String crypto_symbol, double quantity) {
        this.userId = userId;
        this.crypto_symbol = crypto_symbol;
        this.quantity = quantity;
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

}

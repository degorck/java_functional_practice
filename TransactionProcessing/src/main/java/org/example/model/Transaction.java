package org.example.model;

public class Transaction {
    private int year;
    private String type; // "credit" or "debit"
    private String customerName;
    private double amount;

    public Transaction(int year, String type, String customerName, double amount){
        this.year = year;
        this.type = type;
        this.customerName = customerName;
        this.amount = amount;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getYear() {
        return year;
    }

    public String getType() {
        return type;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "year=" + year +
                ", type='" + type + '\'' +
                ", customerName='" + customerName + '\'' +
                ", amount=" + amount +
                '}';
    }
}

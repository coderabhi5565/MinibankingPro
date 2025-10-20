package com.example.demo;

public class Customer {
    private String id;
    private String name;
    private double balance;

    public Customer(String id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void withdraw(double amount){
        if(amount <= 0){
            throw new RuntimeException("Invalid Withdraw Amount");
        }
        if(this.balance < amount){
            throw new RuntimeException("Insufficient Amount");
        }
        this.balance -= amount;
    }

    public void deposit(double amount){
        if(amount <= 0){
            throw new RuntimeException("Invalid Deposit Amount");
        }
        this.balance += amount;
    }

    public double getBalance(){
        return this.balance;
    }
}

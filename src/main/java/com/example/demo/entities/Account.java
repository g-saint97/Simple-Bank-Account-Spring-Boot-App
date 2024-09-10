package com.example.demo.entities;

public class Account {
    private int id;
    private String name;
    private double balance;

    public Account(int id, String name, double balance){
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public Account(int id, String name ){
        this.id = id;
        this.name = name;
    }

    public Account(long id, String name, double balance){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double deposit(double amount){
        this.balance += amount;
        return balance;
    }

    public double withdraw(double amount){
        this.balance -= amount;
        return balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}

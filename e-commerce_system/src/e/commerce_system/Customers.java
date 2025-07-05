/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.commerce_system;

/**
 *
 * @author marko
 */
public class Customers {
    private String name;
    private double balance;

    public Customers(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }
    

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }
    
    public void reduceBalance(double amount){
        if (balance > 0) {
            balance -= amount;
        }else{
            throw new IllegalArgumentException("Not enough balance available");
        }
    }
    
}

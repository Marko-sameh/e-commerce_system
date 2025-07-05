/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.commerce_system;

import java.time.LocalDate;

/**
 *
 * @author marko
 */
public class Products implements Expirable,Shippable{
    private String name;
    private double price;
    private int quantity;
    private LocalDate expiryDate;
    private Double weight;

    public Products(String name, double price, int quantity, LocalDate expiryDate, Double weight) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
    
    public boolean isExpirable(){
        return expiryDate != null;
    }

    @Override
    public boolean isExpired() {
        return isExpirable() && expiryDate.isBefore(LocalDate.now());
    }

    public boolean isShippable(){
        return weight != null;
    }
    
    @Override
    public double getWeight() {
        if (!isShippable()) {
            throw new UnsupportedOperationException("This product is not shippable");
        }
        return weight;
    }

    @Override
    public String toString() {
        return "Products{" + "name=" + name + ", price=" + price + ", quantity=" + quantity + ", expiryDate=" + expiryDate + ", weight=" + weight + '}';
    }
    
    
    public void reduceQuantity(double amount){
        if (amount <= quantity) {
            quantity -= amount;
        }else{
            throw new IllegalArgumentException("Not enough quantity available");
        }
    }
    
    
}




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.commerce_system;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author marko
 */
public class Cart {

    private Map<Products, Integer> items = new HashMap<>();

    public void addProduct(Products product, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity can't be 0 or negative");
        }

        if (product.getQuantity() < quantity) {
            throw new IllegalArgumentException("Not enough stock for" + product.getName());
        }

        items.put(product, items.getOrDefault(product, 0) + quantity);
    }

    public Map<Products, Integer> getItems() {
        return Collections.unmodifiableMap(items);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void clear() {
        items.clear();
        System.out.println("cart has cleared successfully");
    }

    public double getSubTotal() {
        double subTotal = 0.0;
        for (Map.Entry<Products, Integer> entry : items.entrySet()) {
            subTotal += entry.getKey().getPrice() * entry.getValue();
        }
        return subTotal;
    }

    public List<Products> getShippableProducts() {
        List<Products> list = new ArrayList<>();
        for (Map.Entry<Products, Integer> entry : items.entrySet()) {
            if (entry.getKey().isShippable()) {
                list.add(entry.getKey());
            }
        }
        return list;
    }

}

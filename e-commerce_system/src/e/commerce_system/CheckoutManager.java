/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.commerce_system;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author marko
 */
public class CheckoutManager {

    private final ShippingService shippingService = new ShippingService();
    private final double shippingRatePerKg = 30.0;

    public void checkout(Customers customer, Cart cart) {
        if (cart.isEmpty()) {
            throw new IllegalArgumentException("cart is empty");
        }

        for (Map.Entry<Products, Integer> entry : cart.getItems().entrySet()) {
            Products product = entry.getKey();
            int qty = entry.getValue();
            if (product.isExpired()) {
                throw new IllegalArgumentException("Product "
                        + product.getName() + " Expired");
            }
            if (product.getQuantity() < qty) {
                throw new IllegalArgumentException("Product "
                        + product.getName() + " Insufficient stock");
            }
        }

        double subtotal = 0;
        for (Map.Entry<Products, Integer> entry : cart.getItems().entrySet()) {
            subtotal += entry.getKey().getPrice() * entry.getValue();
        }

        List<Products> shipList = new ArrayList<>();
        for (Map.Entry<Products, Integer> entry : cart.getItems().entrySet()) {
            Products product = entry.getKey();
            int qty = entry.getValue();
            if (product.isShippable()) {
                for (int i = 0; i < qty; i++) {
                    shipList.add(product);
                }
            }
        }

        shippingService.ship(shipList);
        double totalWeight = 0.0;
        for (Products p : shipList) {
            totalWeight += p.getWeight() / 1000.0;
        }
        double shippingFees = totalWeight * shippingRatePerKg;

        double total = subtotal + shippingFees;

        if (customer.getBalance() < total) {
            throw new IllegalArgumentException("Customer balance is not enough");
        }

        for (Map.Entry<Products, Integer> entry : cart.getItems().entrySet()) {
            Products product = entry.getKey();
            int qty = entry.getValue();
            product.reduceQuantity(qty);
        }

        customer.reduceBalance(total);

        System.out.println("** Checkout receipt **");
        for (Map.Entry<Products, Integer> entry : cart.getItems().entrySet()) {
            System.out.println(entry.getValue() + "x " + entry.getKey().getName()
                    + " " + entry.getKey().getPrice() * entry.getValue() );
        }
        System.out.println("----------------------");
        System.out.println("Subtotal " + subtotal);
        System.out.println("Shipping " + shippingFees);
        System.out.println("Amount " + total);
        System.out.println("Customer new balance " + customer.getBalance());
        System.out.println("--------------------------------------------");

        cart.clear();
    }
}

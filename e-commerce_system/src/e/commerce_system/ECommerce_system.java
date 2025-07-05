/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.commerce_system;

import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author marko
 */
public class ECommerce_system {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Add product String name, double price, int quantity,if isExpirable LocalDate expiryDate else null, if Shippable double weight else null
        Products cheese = new Products("Cheese", 100, 10, LocalDate.now().plusDays(30), null);
        Products biscuits = new Products("Biscuits", 150, 6, LocalDate.now().plusDays(10), null);
        Products tv = new Products("TV", 2000, 5, null, 5000.0);
        Products phone = new Products("phone", 1000, 5, null, 500.0);
        Products scratchCard = new Products("Scratch Card", 50, 10, null, null);

        Customers customer = new Customers("Ali", 4000);

        Cart cart = new Cart();
        cart.addProduct(cheese, 2);
        cart.addProduct(biscuits, 1);
        cart.addProduct(scratchCard, 2);
        cart.addProduct(tv, 1);
        cart.addProduct(phone, 1);

        CheckoutManager cm = new CheckoutManager();
        cm.checkout(customer, cart);
    }

}

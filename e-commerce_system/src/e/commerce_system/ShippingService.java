/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.commerce_system;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author marko
 */
public class ShippingService {

    public void ship(List<Products> items) {
        if (items == null || items.isEmpty()) {
            throw new IllegalArgumentException("No items to ship");
        }
        Map<String, Integer> countMap = new LinkedHashMap<>();
        Map<String, Double> weightMap = new HashMap<>();

        for (Products p : items) {
            if (p.isShippable()) {
                String key = p.getName() + "|" + p.getWeight();
                countMap.put(key, countMap.getOrDefault(key, 0) + 1);
                weightMap.put(key, p.getWeight());
            }
        }

        System.out.println("** Shipment notice **");
        double totalWeight = 0.0;
        for (String key : countMap.keySet()) {
            String[] parts = key.split("\\|");
            String name = parts[0];
            double weight = weightMap.get(key);
            int count = countMap.get(key);

            if (weight < 1000) {
                System.out.println(count + "x " + name + " " + (int) weight + "g");
            } else {
                double weightInKg = weight / 1000.0;
                System.out.println(count + "x " + name + " " + weightInKg + "Kg");
            }
            totalWeight += weight * count;
        }

        System.out.println("Total package weight " + totalWeight / 1000 + "kg");
        System.out.println("");

    }
}

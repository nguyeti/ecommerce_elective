/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Anthony, Etienne, Timothée
 */
public class ShoppingCart {

    private Map<Product, Integer> products;

    public ShoppingCart() {
        this.products = new HashMap<Product, Integer>(0);
    }

    public void addProduct(Product product, int quantity) {
        if (quantity > 0) {
            if (products.containsKey(product)) {
                int qt = products.get(product);
                products.put(product, qt + quantity);
            } else {
                products.put(product, quantity);
            }
        }
    }

    public Set<Product> getProducts() {
        return products.keySet();
    }

    public int getQuantity(Product product) {
        return products.get(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public float getAmount() {
        float amount = 0;
        for (Product product : this.getProducts()) {
            amount += product.getPrice() * this.getQuantity(product);
        }
        return amount;
    }

}

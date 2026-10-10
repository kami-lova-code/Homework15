package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.search.Searchable;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;




public class ProductBasket {

    private final Map<String, List<Product>> items;

    public ProductBasket() {
        this.items = new HashMap<>();
    }


    public void add(Product product) {
        if (product == null) {
            return;
        }
        items.computeIfAbsent(product.getName(), k -> new LinkedList<>()).add(product);

    }


    public double calculateTotalPrice() {
        double total = 0.0;
        for (List<Product> productList : items.values()) {
            for (Product p : productList)
                if (p != null) {
                    total += p.getPrice();
                }
        }
        return total;
    }


    public int countSpecialProducts() {
        int count = 0;
        for (List<Product> productList : items.values()) {
            for (Product p : productList)
                if (p != null && p.isSpecial()) {
                    count++;
                }
        }

        return count;
    }


         

    public void printBasket() {
        System.out.println("--- Корзина ---");
        for (List<Product> productList : items.values()) {
            for (Product p : productList) {
                if (p != null) {
                    System.out.println(p.toString());
                }
            }
        }
            System.out.println("Итого: " + calculateTotalPrice());
            System.out.println("Специальных товаров: " + countSpecialProducts());
        }


        public List<Searchable> removeByName (String name){
            if (name == null) {
                return new LinkedList<>();
            }

            List<Product> removed = items.remove(name);

            List<Searchable> result = new LinkedList<>();
            if (removed != null) {
                result.addAll(removed);
            }
            return result;
        }
    }



















































        
























































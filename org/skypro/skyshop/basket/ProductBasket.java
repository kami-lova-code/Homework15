package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.search.Searchable;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class ProductBasket {

    private final List<Product> items;

    public ProductBasket() {
        this.items = new LinkedList<>();
    }


    public void add(Product product) {
        if (product == null) {
            return;
        }
        items.add(product);

    }


    public double calculateTotalPrice() {
        double total = 0.0;
        for (Product p : items) {
            if (p != null) {
                total += p.getPrice();
            }
        }
        return total;
    }


    public int countSpecialProducts() {
        int count = 0;
        for (Product p : items) {
            if (p != null && p.isSpecial()) {
                count++;
            }
        }
        return count;


    }

    public void printBasket() {
        System.out.println("--- Корзина ---");
        for (Product p : items) {
            if (p != null) {
                System.out.println(p.toString());
            }
        }
        System.out.println("Итого: " + calculateTotalPrice());
        System.out.println("Специальных товаров: " + countSpecialProducts());
    }


    public List<Searchable> removeByName(String name) {
        List<Searchable> removed = new LinkedList<>();
        Iterator<Product> iterator = items.iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equals(name)) {
                removed.add(product);
                iterator.remove();
            }
        }
        return removed;
    }
}













































        
























































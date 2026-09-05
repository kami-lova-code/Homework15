package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;


public class ProductBasket {
    private final Product[] products = new Product[5];


    public void addProduct(Product product) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product;
                return;
            }
        }
        System.out.println("Невозможно добавить продукт");
    }

    public double calculateTotalPrice() {
        double total = 0.0;
        for (Product p : products) {
            if (p != null) {
                total += p.getPrice();
            }
        }
        return total;
    }


    public int countSpecialProducts() {
        int count = 0;
        for (Product p : products) {
            if (p != null && p.isSpecial()) {
                count++;
            }
        }
        return count;

    }

    public void printBasket() {
        System.out.println("--- Корзина ---");
        for (Product p : products) {
            if (p != null) {
                System.out.println(p.toString());
            }
        }
        System.out.println("Итого: " + calculateTotalPrice());
        System.out.println("Специальных товаров: " + countSpecialProducts());
    }
}










































        
























































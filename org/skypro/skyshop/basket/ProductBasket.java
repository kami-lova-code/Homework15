package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.search.Searchable;

import java.util.*;


public class ProductBasket {

    private final Map<String,List<Product>> items;

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
        return items.values().stream()
                .flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .mapToDouble(Product::getPrice)
                .sum();
    }

    private long getSpecialCount() {
        return items.values().stream()
                .flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .filter(Product::isSpecial)
                .count();
    }



    public int countSpecialProducts() {
        long count = getSpecialCount();

        return Math.toIntExact(count);


    }

    public void printBasket() {
        System.out.println("--- Корзина ---");

        items.values().stream()
                .flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .forEach(System.out::println);



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



















































        
























































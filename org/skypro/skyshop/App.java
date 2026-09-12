package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Arrays;


public class App {
    public static void main(String[] args) {
        SimpleProduct bread = new SimpleProduct("Хлеб",50.0);
        DiscountedProduct milk = new DiscountedProduct("Молоко",100.0,20);
        FixPriceProduct book = new FixPriceProduct("Книга");
        SimpleProduct sugar = new SimpleProduct("Сахар",70.0);
        DiscountedProduct chocolate = new DiscountedProduct("Шоколад", 200.0, 50);

        ProductBasket basket = new ProductBasket();

        basket.addProduct(bread);
        basket.addProduct(milk);
        basket.addProduct(book);
        basket.addProduct(sugar);
        basket.addProduct(chocolate);
        basket.printBasket();

        System.out.println();


        Article article1 = new Article("О пользе хлеба", "Хлеб-источник углеводов и энергии");
        Article article2 = new Article("Как выбрать молоко", "Молоко бывает разной жирности и состава.");
        Article article3 = new Article("Шоколад: вред или польза", "Тёмный шоколад содержит антиоксиданты.");

        SearchEngine engine = new SearchEngine(10);
        engine.add(bread);
        engine.add(milk);
        engine.add(book);
        engine.add(sugar);
        engine.add(chocolate);
        engine.add(article1);
        engine.add(article2);
        engine.add(article3);

        System.out.println("=== Поиск: \"мол\"===");
        Searchable[] results1 = engine.search("мол");
        for (Searchable s: results1) {
            if (s != null) {
                System.out.println(s.getStringRepresentation());
            }
        }

        System.out.println("\n === Поиск: \"хлеб\" ===");
        Searchable[] results2 = engine.search("хлеб");
        for (Searchable s : results2) {
            if (s != null) {
                System.out.println(s.getStringRepresentation());
            }
        }

        System.out.println("\n === Поиск: \"шокол\" ===");
        Searchable[] results3 = engine.search("шокол");
        for (Searchable s : results3) {
            if (s != null) {
                System.out.println(s.getStringRepresentation());
            }
        }

        System.out.println("\n=== Поиск (Arrays.toString):\"нига\" ===");
        System.out.println(Arrays.toString(engine.search("нига")));
    }

}

















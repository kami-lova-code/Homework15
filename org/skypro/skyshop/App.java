package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;
import org.skypro.skyshop.search.BestResultNotFound;
import java.util.Map;
import java.util.List;




public class App {
    public static void main(String[] args) {

        System.out.println("===Проверка невалидных данных===");

        try {
            new SimpleProduct("", 50.0);
        } catch (IllegalArgumentException e) {
            System.out.println("SimpleProduct" + e.getMessage());
        }
        try {
            new SimpleProduct("Хлеб", 0);
        } catch (IllegalArgumentException e) {
            System.out.println("SimpleProduct" + e.getMessage());
        }
        try {
            new DiscountedProduct("Молоко", -100.0, 20);
        } catch (IllegalArgumentException e) {
            System.out.println("DiscountedProduct" + e.getMessage());
        }
        try {
            new DiscountedProduct("Шоколад", 200.0, 150);
        } catch (IllegalArgumentException e) {
            System.out.println("DiscountedProduct" + e.getMessage());
        }
        try {
            new DiscountedProduct("Сахар", 70.0, -5);
        } catch (IllegalArgumentException e) {
            System.out.println("DiscountedProduct" + e.getMessage());
        }
        try {
            new FixPriceProduct("  ");
        } catch (IllegalArgumentException e) {
            System.out.println("FixPriceProduct" + e.getMessage());
        }

        System.out.println();


        SimpleProduct bread = new SimpleProduct("Хлеб", 50.0);
        DiscountedProduct milk = new DiscountedProduct("Молоко", 100.0, 20);
        FixPriceProduct book = new FixPriceProduct("Книга");
        SimpleProduct sugar = new SimpleProduct("Сахар", 70.0);
        DiscountedProduct chocolate = new DiscountedProduct("Шоколад", 200.0, 50);


        ProductBasket basket = new ProductBasket();

        basket.add(bread);
        basket.add(milk);
        basket.add(book);
        basket.add(sugar);
        basket.add(chocolate);
        basket.printBasket();


        System.out.println();


        Article article1 = new Article("О пользе хлеба", "Хлеб-источник углеводов и энергии");
        Article article2 = new Article("Как выбрать молоко", "Молоко бывает разной жирности и состава.");
        Article article3 = new Article("Шоколад: вред или польза", "Тёмный шоколад содержит антиоксиданты.");

        SearchEngine engine = new SearchEngine();
        engine.add(bread);
        engine.add(milk);
        engine.add(book);
        engine.add(sugar);
        engine.add(chocolate);
        engine.add(article1);
        engine.add(article2);
        engine.add(article3);

        System.out.println("=== Поиск: \"мол\"===");
        Map<String,Searchable> results1 = engine.search("мол");
        for (Searchable s : results1.values()) {
            if (s != null) {
                System.out.println(s.getStringRepresentation());
            }
        }

        System.out.println("\n === Поиск: \"хлеб\" ===");
        Map<String,Searchable> results2 = engine.search("хлеб");
        for (Searchable s : results2.values()) {
            if (s != null) {
                System.out.println(s.getStringRepresentation());
            }
        }

        System.out.println("\n === Поиск: \"шокол\" ===");
        Map<String,Searchable> results3 = engine.search("шокол");
        for (Searchable s : results3.values()) {
            if (s != null) {
                System.out.println(s.getStringRepresentation());
            }
        }

        System.out.println("\n=== Поиск:\"нига\" ===");
        System.out.println(engine.search("нига").toString());


        System.out.println("\n=== Лучший результат: \"мол\" ===");
        try {
            Searchable best = engine.findBestMatch("мол");
            System.out.println(best.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n=== Лучший результат: \"хлеб\" ===");
        try {
            Searchable best = engine.findBestMatch("хлеб");
            System.out.println(best.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n=== Лучший результат: \"фырфыр\" ===");
        try {
            Searchable best = engine.findBestMatch("фырфыр");
            System.out.println(best.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());

        }
        System.out.println("\n=== Удаляем «Молоко» ===");
        List<Searchable> removed = basket.removeByName("Молоко");
        System.out.println("Удалено продуктов: " + removed.size());
        for (Searchable s : removed) {
            System.out.println("- " + s.getName());
        }
        System.out.println("\n=== Корзина после удаления ===");
        basket.printBasket();

        System.out.println("\n=== Удаляем «Чай» (не существует) ===");
        List<Searchable> removedEmpty = basket.removeByName("Чай");
        if (removedEmpty.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            System.out.println("Удалено продуктов: " + removedEmpty.size());
        }

        System.out.println("\n=== Корзина после попытки удаления несуществующего ===");
        basket.printBasket();












    }
}





       









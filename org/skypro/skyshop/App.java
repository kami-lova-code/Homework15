package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        Product p1 = new Product("Атоми Ивнинг Кеар Набор", 3000);
        Product p2 = new Product("Маска для лица", 1200);
        Product p3 = new Product("Сыворотка", 2500);
        Product p4 = new Product("Тоник", 900);
        Product p5 = new Product("Крем для рук", 1500);
        Product p6 = new Product("Дополнительный продукт", 1000);

        System.out.println("---Добавление продуктов---");
        basket.addProduct(p1);
        basket.addProduct(p2);
        basket.addProduct(p3);
        basket.addProduct(p4);
        basket.addProduct(p5);

        System.out.println("--- Попытка добавить товар в заполненную корзину---");
        basket.addProduct(p6);

        System.out.println("\n---Печать содепржимого корзины---");
        basket.printBasket();

        System.out.println("\n---Получение общей стоимости---");
        System.out.println("Общая стоимость:" + basket.calculateTotalPrice());

        System.out.println("\n---Поиск товара,который есть в корзине---");
        System.out.println("Поиск 'Сыворотка': " + basket.findProductByName("Сыворотка"));

        System.out.println("\n---Поиск товара,которого нет в корзине---");
        System.out.println("Поиск 'Лосьон': " + basket.findProductByName("Лосьон"));

        System.out.println("\n---Очистка корзины---");
        basket.clear();

        System.out.println("\n---Печать содержимого пустой корзины---");
        basket.printBasket();

        System.out.println("\n---Получение стоимости пустой корзины---");
        System.out.println("Общая стоимость: " + basket.calculateTotalPrice());

        System.out.println("\n---Поиск товара по имени в пустой корзине---");
        System.out.println("Поиск 'Крем для рук': " + basket.findProductByName("Тоник"));
    }
}














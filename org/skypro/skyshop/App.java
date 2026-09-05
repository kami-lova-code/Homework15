package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;




public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();


        basket.addProduct(new SimpleProduct("Хлеб", 50.0));
        basket.addProduct(new DiscountedProduct("Молоко", 100.0, 20));
        basket.addProduct(new FixPriceProduct("Книга"));
        basket.addProduct(new SimpleProduct("Сахар", 70.0));
        basket.addProduct(new DiscountedProduct("Шоколад", 200.0, 50));


        basket.printBasket();
    }
}

















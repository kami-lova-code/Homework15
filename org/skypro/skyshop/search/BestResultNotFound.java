package org.skypro.skyshop.search;

public class BestResultNotFound extends Exception {
    public BestResultNotFound(String search) {
        System.out.println("Не найдено подходящего результата для запроса: " + search);
    }
}

package org.skypro.skyshop.search;

public class SearchEngine {

   private final Searchable[] items;
   private int size = 0;

    public SearchEngine(int capacity) {
        this.items = new Searchable[capacity];
    }

    public void add(Searchable item) {
        if (size < items.length) {
            items[size++] = item;
        } else {
            System.out.println("Невозможно положить: поисковой движок заполнен");
        }
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int found = 0;
        for (int i = 0; i < size && found < 5; i++) {
            if (items[i].getSearchTerm().contains(query)) {
                results[found++] = items[i];
            }
            
        }
        return results;

    }
}

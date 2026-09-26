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
            String term = items[i].getSearchTerm().toLowerCase();
            if (term.contains(query.toLowerCase())) {
                results[found++] = items[i];
            }

        }
        return results;
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {

        Searchable best = null;
        int maxCount = 0;

        for (int i = 0; i < size; i++) {
            if (items[i] == null) {
                continue;
            }
            String term = items[i].getSearchTerm();
            if (term == null) {
                continue;
            }

            String termLower = term.toLowerCase();
            String searchLower = search.toLowerCase();

            int count = 0;
            int index = 0;
            int foundIndex = termLower.indexOf(searchLower, index);

            while (foundIndex != -1) {
                count++;
                index = foundIndex + searchLower.length();
                foundIndex = termLower.indexOf(searchLower, index);
            }

            if (count > maxCount) {
                maxCount = count;
                best = items[i];
            }
        }
        if (best == null) {
            throw new BestResultNotFound(search);

        }
        return best;
    }
}










            
























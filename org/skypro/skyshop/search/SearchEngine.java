package org.skypro.skyshop.search;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class SearchEngine {

    private final List<Searchable> items;


    public SearchEngine() {
        this.items = new ArrayList<>();
    }

    public void add(Searchable item) {
        if (item == null) {
            return;
        }
        items.add(item);
    }


    public List<Searchable> search(String query) {
        List<Searchable> results = new LinkedList<>();
        if (query == null || query.isBlank()) {
            return results;
        }
        String queryLower = query.toLowerCase();
        for (Searchable item : items) {
            if (item == null) {
                continue;
            }
            String term = item.getSearchTerm();
            if (term == null) {
                continue;
            }
            if (term.toLowerCase().contains(queryLower)) {
                results.add(item);
            }
        }
        return results;
    }


    public Searchable findBestMatch(String search) throws BestResultNotFound {

        if (search == null || search.isBlank()) {
            throw new BestResultNotFound(search);
        }

        Searchable best = null;
        int maxCount = 0;


        for (Searchable item : items) {
            if (item == null) {
                continue;
            }
            String term = item.getSearchTerm();
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
                best = item;
            }
        }
        if (best == null) {
            throw new BestResultNotFound(search);

        }
        return best;
    }
}













            
























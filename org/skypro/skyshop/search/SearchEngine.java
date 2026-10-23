package org.skypro.skyshop.search;


import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;


public class SearchEngine {

    private final Set<Searchable> items;


    public SearchEngine() {
        this.items = new HashSet<>();
    }

    public void add(Searchable item) {
        if (item == null) {
            return;
        }
        items.add(item);
    }


    public Set<Searchable> search(String query) {

        if (query == null || query.isBlank()) {
            return new TreeSet<>(byNameLengthDescThenAlpha());
        }

        String queryLower = query.toLowerCase();

        Supplier<Set<Searchable>> treeSetSupplier = () -> new TreeSet<>(byNameLengthDescThenAlpha());

        return items.stream()
                .filter(item -> item != null)
                .filter(item -> {
                    String term = item.getSearchTerm();
                    return term != null && term.toLowerCase().contains(queryLower);
                })
                .collect(Collectors.toCollection(treeSetSupplier));
    }

    public static Comparator<Searchable> byNameLengthDescThenAlpha() {
        return (s1,s2) -> {
            int len1 = s1.getName().length();
            int len2 = s2.getName().length();

            int lengthCompare = Integer.compare(len2, len1);

            if (lengthCompare != 0) {
                return lengthCompare;
            }
            return s1.getName().compareTo(s2.getName());


        };
    }


    public Searchable findBestMatch(String search) throws BestResultNotFound {

        if (search == null || search.isBlank()) {
            throw new BestResultNotFound(search);
        }
        String searchLower = search.toLowerCase();
        Searchable bestItem = null;
        int bestCount = -1;


        for (Searchable item : items) {
            if (item == null) {
                continue;
            }
            String term = item.getSearchTerm();
            if (term == null) {
                continue;
            }

            String termLower = term.toLowerCase();
            int count = 0;
            int index = 0;


            while ((index = termLower.indexOf(searchLower,index)) !=-1){
                count++;
                index ++;
            }

            if (count > bestCount) {
                bestCount = count;
                bestItem = item;
            }
        }
        if (bestItem == null || bestCount == 0) {
            throw new BestResultNotFound(search);

        }
        return bestItem;
    }
}













            
























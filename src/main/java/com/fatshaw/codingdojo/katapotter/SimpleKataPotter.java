package com.fatshaw.codingdojo.katapotter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SimpleKataPotter implements KataPotter {

    private static final Map<Integer, Integer> DISCOUNTS = new HashMap<Integer, Integer>() {
        {
            put(1, 800);
            put(2, 760 * 2);
            put(3, 720 * 3);
            put(4, 640 * 4);
            put(5, 600 * 5);
        }
    };

    private Map<Integer, Integer> groupMap(Map<Integer, Integer> map) {
        Map<Integer, Integer> groupMap = new HashMap<>();
        while (map.size() > 0) {
            groupMap.put(map.size(), groupMap.getOrDefault(map.size(), 0) + 1);
            new HashSet<>(map.keySet()).forEach(i -> {
                int c = map.get(i);
                if (c == 1) {
                    map.remove(i);
                } else {
                    map.put(i, c - 1);
                }
            });
        }

        return groupMap;
    }

    public int getPrice(List<Integer> books) {

        Map<Integer, Integer> groupedBooks = groupMap(books.stream()
            .collect(Collectors.toMap(s -> s, s -> 1, (s, j) -> (s + j))));
        int min = Math.min(groupedBooks.getOrDefault(3, 0), groupedBooks.getOrDefault(5, 0));
        return groupedBooks.entrySet().stream()
            .map(kv -> DISCOUNTS.get(kv.getKey()) * kv.getValue())
            .reduce(min * -40, (s, i) -> s + i);
    }

}

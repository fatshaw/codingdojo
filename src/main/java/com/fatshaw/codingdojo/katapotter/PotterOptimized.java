package com.fatshaw.codingdojo.katapotter;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


public class PotterOptimized implements KataPotter {

    public int[] getSortedGroupMap(List<Integer> books) {
        return Arrays.copyOf(books.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).values().stream()
            .sorted((o1, o2) -> (int) (o2 - o1))
            .mapToInt(Long::intValue).toArray(), 5);
    }

    public int getPrice(List<Integer> books) {
        int[] gbooks = getSortedGroupMap(books);
        double a = gbooks[4] * 5 * 800 * 0.75 +
            (gbooks[3] - gbooks[4]) * 4 * 800 * 0.8 +
            (gbooks[2] - gbooks[3]) * 3 * 800 * 0.9 +
            (gbooks[1] - gbooks[2]) * 2 * 800 * 0.95 +
            (gbooks[0] - gbooks[1]) * 1 * 800 -
            40 * Math.min(gbooks[2] - gbooks[3], gbooks[4]);
        return (int) a;
    }

}

package com.fatshaw.codingdojo.fizzbuzz;

@FunctionalInterface
public interface Matcher<T> {
    boolean match(T value);

    static Matcher<Integer> alwaysTrue() {
        return (i -> true);
    }

}

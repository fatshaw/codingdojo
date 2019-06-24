package com.fatshaw.codingdojo.fizzbuzz;

import java.util.stream.Stream;

@FunctionalInterface
public interface Rule<R> {

    R apply(int value);

    static <R> Rule with(Matcher<Integer> matcher, Action<Integer, R> action) {
        return (value -> matcher.match(value) ? action.act(value) : null);
    }


    static <R> Rule<R> allRules(Rule<R>... rules) {
        return (value -> Stream.of(rules).map(rule -> rule.apply(value)).filter(t -> t != null).findFirst().orElseGet(null));
    }
}

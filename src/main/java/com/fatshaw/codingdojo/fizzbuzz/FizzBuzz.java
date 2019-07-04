package com.fatshaw.codingdojo.fizzbuzz;

public class FizzBuzz {
    public static final String FIZZ_BUZZ = "FizzBuzz";
    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";

    private int nextNumber = 0;

    private final static Rule<String> fizzRule = Rule.with(i -> isFizz(i), i -> FIZZ);
    private final static Rule<String> buzzRule = Rule.with(i -> isBuzz(i), i -> BUZZ);
    private final static Rule<String> fizzBuzzRule = Rule.with(i -> isBuzz(i) && isFizz(i), i -> FIZZ_BUZZ);
    private final static Rule<String> numberRule = Rule.with(Matcher.alwaysTrue(), i -> String.valueOf(i));
    private final static Rule<String> allRules = Rule.allRules(fizzBuzzRule, fizzRule, buzzRule, numberRule);

    public String getNextNumber() {
        return allRules.apply(++nextNumber);
    }

    private final static boolean isBuzz(int i) {
        return i % 5 == 0 || String.valueOf(i).contains("5");
    }

    private final static boolean isFizz(int i) {
        return i % 3 == 0 || String.valueOf(i).contains("3");
    }
}

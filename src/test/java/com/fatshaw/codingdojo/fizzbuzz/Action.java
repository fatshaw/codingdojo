package com.fatshaw.codingdojo.fizzbuzz;

@FunctionalInterface
public interface Action<T,R> {
    R act(T value);
}

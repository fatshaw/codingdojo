package com.fatshaw.codingdojo.fizzbuzz;

import org.junit.Test;

import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class FizzBuzzTest {
    @Test
    public void should_get_one_for_the_first_pupil() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        assertEquals("1", fizzBuzz.getNextNumber());
    }

    @Test
    public void should_get_two_for_the_secondary_pupil() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        fizzBuzz.getNextNumber();
        assertEquals("2", fizzBuzz.getNextNumber());
    }

    @Test
    public void should_get_fizz_for_the_third_pupil() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        fizzBuzz.getNextNumber();
        fizzBuzz.getNextNumber();
        assertEquals("Fizz", fizzBuzz.getNextNumber());
    }

    @Test
    public void should_get_four_for_the_fourth_pupil() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        fizzBuzz.getNextNumber();
        fizzBuzz.getNextNumber();
        fizzBuzz.getNextNumber();
        assertEquals("4", fizzBuzz.getNextNumber());
    }

    @Test
    public void should_get_Buzz_for_the_fifth_pupil() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        fizzBuzz.getNextNumber();
        fizzBuzz.getNextNumber();
        fizzBuzz.getNextNumber();
        fizzBuzz.getNextNumber();
        assertEquals("Buzz", fizzBuzz.getNextNumber());
    }

    @Test
    public void should_get_fizzbuzz_for_the_fifteenth_pupil() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        IntStream.range(1, 15).forEach(i -> fizzBuzz.getNextNumber());
        assertEquals("FizzBuzz", fizzBuzz.getNextNumber());
    }

    @Test
    public void should_get_fizz_when_number_can_be_devided_by_three() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        IntStream.range(1, 18).forEach(i -> fizzBuzz.getNextNumber());
        assertEquals("Fizz", fizzBuzz.getNextNumber());
    }

    @Test
    public void should_get_buzz_when_number_can_be_devided_by_five() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        IntStream.range(1, 20).forEach(i -> fizzBuzz.getNextNumber());
        assertEquals("Buzz", fizzBuzz.getNextNumber());
    }

    @Test
    public void should_get_fizzbuzz_when_number_can_be_devided_by_three_and_five() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        IntStream.range(1, 3 * 5 * (1 + new Random().nextInt(10))).forEach(i -> fizzBuzz.getNextNumber());
        assertEquals("FizzBuzz", fizzBuzz.getNextNumber());
    }

    @Test
    public void should_get_fizz_when_number_containing_three_but_not_devided_by_three() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        IntStream.range(1, 23).forEach(i -> fizzBuzz.getNextNumber());
        assertEquals("Fizz", fizzBuzz.getNextNumber());
    }

    @Test
    public void should_get_buzz_when_number_containing_five_but_not_devided_by_five() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        IntStream.range(1, 154).forEach(i -> fizzBuzz.getNextNumber());
        assertEquals("Buzz", fizzBuzz.getNextNumber());
    }

    @Test
    public void should_get_fizzbuzz_when_number_containing_five_and_devided_by_three_but_not_devided_by_five() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        IntStream.range(1, 153).forEach(i -> fizzBuzz.getNextNumber());
        assertEquals("FizzBuzz", fizzBuzz.getNextNumber());
    }
}

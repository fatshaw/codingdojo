package com.fatshaw.codingdojo.katapotter;

import static org.junit.Assert.*;

import java.util.Arrays;
import org.junit.Test;

public class PotterOptimizedTest {

    @Test
    public void one_book_should_cost_800() {
        KataPotter potter = new PotterOptimized();
        assertEquals(800, potter.getPrice(Arrays.asList(1)));
    }

    @Test
    public void two_same_book_should_cost_1600() {
        KataPotter potter = new PotterOptimized();
        assertEquals(1600, potter.getPrice(Arrays.asList(1, 1)));
    }

    @Test
    public void two_different_book_should_cost_1520() {
        KataPotter potter = new PotterOptimized();
        assertEquals(1520, potter.getPrice(Arrays.asList(1, 2)));
    }

    @Test
    public void two_bookone_and_one_booktwo_should_cost_2320() {
        KataPotter potter = new PotterOptimized();
        assertEquals(2320, potter.getPrice(Arrays.asList(1, 1, 2)));
    }

    @Test
    public void five_different_books_should_cost_3000() {
        KataPotter potter = new PotterOptimized();
        assertEquals(3000, potter.getPrice(Arrays.asList(1, 2, 3, 4, 5)));
    }

    @Test
    public void buy_5bookone_and_5booktwo_and_5bookthree_and_4bookfour_and_3bookfive_should_cost_13680() {
        KataPotter potter = new PotterOptimized();
        assertEquals((int) (2 * 800 * 5 * 0.75 + 3 * 800 * 4 * 0.8), potter.getPrice(Arrays.asList(0, 0, 0, 0, 0,
            1, 1, 1, 1, 1,
            2, 2, 2, 2,
            3, 3, 3, 3, 3,
            4, 4, 4)));
    }

    @Test
    public void buy_2bookone_and_2booktwo_and_2bookthree_and_1bookfour_and_1bookfive_should_cost_5120() {
        KataPotter potter = new PotterOptimized();
        assertEquals((int) (2 * (800 * 4 * 0.8)), potter.getPrice(Arrays.asList(1, 1, 2, 2, 3, 3, 4, 5)));
    }
}

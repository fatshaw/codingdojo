package com.fatshaw.codingdojo.exercise;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaximumSubarrayTest {

    @Test
    public void testMaximumSubarray() {
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        assertEquals(6, maximumSubarray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    @Test
    public void testMaximumSubarrayEdge() {
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        assertEquals(-1, maximumSubarray.maxSubArray(new int[]{-1,-2,-3,-4}));
    }
}
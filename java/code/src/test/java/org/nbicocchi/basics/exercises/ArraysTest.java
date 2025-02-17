package org.nbicocchi.basics.exercises;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArraysTest {

    @Test
    public void bubbleSort() {
        int[] input =  {5, 4, 6, 2, 3, 4};
        int[] output = {2, 3, 4, 4, 5, 6};
        assertArrayEquals(output, Arrays.bubbleSort(input));
    }

    @Test
    public void splitter() {
        int[] output = {2, 3, 4, 4, 5, 6};
        assertArrayEquals(output, Arrays.splitter(234456));
    }

    @Test
    public void fibonacci() {
        assertArrayEquals(new long[] {0}, Arrays.fibonacci(1));
        assertArrayEquals(new long[] {0, 1}, Arrays.fibonacci(2));
        assertArrayEquals(new long[] {0, 1, 1, 2, 3}, Arrays.fibonacci(5));
    }

    @Test
    public void moveZerosEnd() {
        assertArrayEquals(new int[] {1, 2, 3}, Arrays.moveZerosEnd(new int[] {1, 2, 3}));
        assertArrayEquals(new int[] {1, 2, 3, 0, 0}, Arrays.moveZerosEnd(new int[] {1, 2, 0, 0, 3}));
        assertArrayEquals(new int[] {1, 2, 3, 0}, Arrays.moveZerosEnd(new int[] {0, 1, 2, 3}));
    }
}
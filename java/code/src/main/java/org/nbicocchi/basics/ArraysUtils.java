package org.nbicocchi.basics;

import java.util.Random;

/**
 * Demonstration of:
 * 1. java.util.Arrays class
 * 2. System.arraycopy() method
 */
public class ArraysUtils {
    public static void main(String[] main) {
        int[] v1 = new int[8];
        int[] v2 = new int[8];
        Random rnd = new Random();

        /* fill with one random number */
        java.util.Arrays.fill(v1, rnd.nextInt(100));
        System.out.println("v1 = " + java.util.Arrays.toString(v1));

        /* fill with random numbers */
        for (int i = 0; i < v1.length; i++) {
            v1[i] = rnd.nextInt(100);
        }
        System.out.println("v1 = " + java.util.Arrays.toString(v1));

        /* sorting */
        java.util.Arrays.sort(v1);
        System.out.println("v1 = " + java.util.Arrays.toString(v1));

        /* copying (fast!) */
        System.arraycopy(v1, 0, v2, 0, 5);
        System.out.println("v2 = " + java.util.Arrays.toString(v2));
    }
}

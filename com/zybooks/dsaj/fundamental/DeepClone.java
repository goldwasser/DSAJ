package com.zybooks.dsaj.fundamental;

import java.util.Arrays;

/** Class to demonstrate a deep clone of a 2D array. */
public class DeepClone {

    /**
     * Creates a deep clone of a 2D array.
     * @param original a 2D array of integers
     * @return a new and independent 2D array of integers
     */
    public static int[][] deepClone(int[][] original) {
        int[][] backup = new int[original.length][];    // create top-level array of arrays
        for (int k=0; k < original.length; k++)
            backup[k] = original[k].clone();            // copy row k
        return backup;
    }

    public static void main(String[] args) {
        int[][] sample = { {1, 2, 3}, {4, 5, 6} };
        int[][] backup = deepClone(sample);

        System.out.println("Sample:");
        System.out.println(Arrays.deepToString(sample));
        System.out.println("Backup:");
        System.out.println(Arrays.deepToString(backup));

        for (int j=0; j < sample.length; j++)
            for (int k=0; k < sample[j].length; k++)
                sample[j][k] *= 10;

        System.out.println("Sample:");
        System.out.println(Arrays.deepToString(sample));
        System.out.println("Backup:");
        System.out.println(Arrays.deepToString(backup));

    }
}

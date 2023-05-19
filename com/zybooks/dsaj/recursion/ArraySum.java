package com.zybooks.dsaj.recursion;

/**
 * Demonstration of two recursive approaches to computing the sum of an array of integers.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class ArraySum {

    /**
     * Returns the sum of the first n integers of the given array.
     *
     * @param data  array of integers
     * @param n     how many integers from the beginning of the array to sum
     * @return the sum of the first n integers of data
     */
    public static int linearSum(int[] data, int n) {
        if (n == 0)
            return 0;
        else
            return linearSum(data, n-1) + data[n-1];
    }

    /**
     * Returns the sum of subarray data[low] through data[high] inclusive.
     *
     * @param data  array of integers
     * @param low   the index of the first integer in the range
     * @param high   the index of the second integer in the range
     * @return the sum of the integers from data[low] through data[high] inclusive
     */
    public static int binarySum(int[] data, int low, int high) {
        if (low > high)                 // zero elements in subarray
            return 0;
        else if (low == high)           // one element in subarray
            return data[low];
        else {
            int mid = (low + high) / 2;
            return binarySum(data, low, mid) + binarySum(data, mid+1, high);
        }
    }

    public static void main(String[] args) {

        for (int limit = 1; limit < 100; limit++) {
            int[] data = new int[limit];
            for (int k=0; k < limit; k++)
                data[k] = k+1;
            int answer = limit * (limit + 1) / 2;

            int linear = linearSum(data, limit);
            if (linear != answer)
                System.out.println("Problem with linear sum for n=" + limit);

            int binary = binarySum(data, 0, limit-1);
            if (binary != answer)
                System.out.println("Problem with binary sum for n=" + limit);
        }
    }
}

package com.zybooks.dsaj.recursion;

/**
 * Demonstration of recursive method for reversing an array's elements.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class ArrayReverse {

    /**
     * Reverses the contents of subarray data[low] through data[high] inclusive.
     * 
     * @param data  an array of integers
     * @param low   the index of the first element in the range to be reversed
     * @param high  the index of the last element in the range to be reversed
     */
    public static void reverseArray(int[] data, int low, int high) {
        if (low < high) {                           // if at least two elements in subarray
            int temp = data[low];                   // swap data[low] and data[high]
            data[low] = data[high];
            data[high] = temp;
            reverseArray(data, low + 1, high - 1);  // recur on the rest
        }
    }

    /**
     * Reverses the contents of the given array.
     *
     * @param data  an array of integers
     */
    public static void reverseIterative(int[] data) {
        int low = 0, high = data.length - 1;
        while (low < high) {                        // swap data[low] and data[high]
            int temp = data[low];
            data[low++] = data[high];               // post-increment of low
            data[high--] = temp;                    // post-decrement of high
        }
    }

}

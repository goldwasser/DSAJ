package com.zybooks.dsaj.analysis;

/**
 * Demonstration of algorithm for finding a given value within an array.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
class ArrayFind {

    /** Returns index j such that data[j] == val, or -1 if no such element. */
    public static int arrayFind(int[] data, int val) {
        int n = data.length;
        int j = 0;
        while (j < n) { // val is not equal to any of the first j elements of data
            if (data[j] == val)
                return j;                  // a match was found at index j
            j++;                           // continue to next index
            // val is not equal to any of the first j elements of data
        }
        return -1;                         // if we reach this, no match found
    }
}

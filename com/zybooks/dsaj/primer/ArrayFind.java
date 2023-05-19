package com.zybooks.dsaj.primer;

/**
 * Demonstration of algorithm for finding a given value within an array.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
class ArrayFind {

    /** Returns index j such that data[j] == target, or data.length if no such element. */
    public static int arrayFind(int[] data, int target) {
        int j = 0;
        while ((j < data.length) && (data[j] != target))
            j++;
        return j;                       // if we reach this, no match found
    }

}

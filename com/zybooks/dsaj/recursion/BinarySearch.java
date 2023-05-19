package com.zybooks.dsaj.recursion;

/**
 * Simple demonstration of the binary search algorithm.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class BinarySearch {

    /**
     * Returns true if the target value is found in the indicated portion of the data array.
     * This search only considers the array portion from data[low] to data[high] inclusive.
     *
     * @param data   sorted array of integers
     * @param target the query value
     * @param low    the index of the left end of the search range
     * @param high   the index of the right end of the search range
     * @return true  if the target is found, false otherwise
     */
    public static boolean binarySearch(int[] data, int target, int low, int high) {
        if (low > high)
            return false;                                             // interval empty; no match
        else {
            int mid = (low + high) / 2;
            if (target == data[mid])
                return true;                                          // found a match
            else if (target < data[mid])
                return binarySearch(data, target, low, mid - 1);      // recur left of the middle
            else
                return binarySearch(data, target, mid + 1, high);     // recur right of the middle
        }
    }

    // Demonstration of a public wrapper function with cleaner signature
    /**
     * Returns true if the target value is found in the data array.
     *
     * @param data   sorted array of integers
     * @param target the query value
     * @return true  if the target is found, false otherwise
     */
    public static boolean binarySearch(int[] data, int target) {
        return binarySearch(data, target, 0, data.length - 1);        // use parameterized version
    }


    /**
     * Returns true if the target value is found in the data array.
     *
     * @param data   sorted array of integers
     * @param target the query value
     * @return true  if the target is found, false otherwise
     */
    public static boolean binarySearchIterative(int[] data, int target) {
        int low = 0;
        int high = data.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target == data[mid])          // found a match
                return true;
            else if (target < data[mid])
                high = mid - 1;               // only consider values left of mid
            else
                low = mid + 1;                // only consider values right of mid
        }
        return false;                         // loop ended without success
    }


    /** Simple test, assuming valid integer given as command-line argument */
    public static void main(String[] args) {
        final int N = 100;
        int[] data = new int[N];
        for (int j=0; j < N; j++)
            data[j] = 1 + 2*j;

        for (int j=0; j < N; j++) {
            if (!binarySearch(data, 1 + 2*j))
                System.out.println("Recursive failure to find value " + (1+2*j));
            if (!binarySearchIterative(data, 1 + 2*j))
                System.out.println("Iterative failure to find value " + (1+2*j));
        }

        for (int j=0; j <= N; j++) {
            if (binarySearch(data, 2*j))
                System.out.println("Recursive false-positive on value " + (2*j));
            if (binarySearchIterative(data, 2*j))
                System.out.println("Iterative false-positive on value " + (2*j));
        }
    }
}

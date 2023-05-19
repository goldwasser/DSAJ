package com.zybooks.dsaj.primer;

/** Demonstration of a recursive method to find the maximum value in an array. */
public class ArrayMax {

    /**
     * Returns the maximum value within a nonempty array of doubles. 
     *
     * @param data  a nonempty array of numeric values
     * @return the maximum value among the data
     */
    public static double max(double[] data) {
        double currentMax = data[0];           // assume first is biggest (for now)
        for (int j=1; j < data.length; j++)    // consider all other entries
            if (data[j] > currentMax)          // if data[j] is biggest thus far...
                currentMax = data[j];          // record it as the current max
        return currentMax;
    }

}

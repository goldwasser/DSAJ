package com.zybooks.dsaj.design;

/** A demonstration of a generic function with a parameterized type. */
public class GenericDemo {
    public static <T> void reverse(T[] data) {
        int low = 0, high = data.length - 1;
        while (low < high) {                     // swap data[low] and data[high]
            T temp = data[low];
            data[low++] = data[high];            // post-increment of low
            data[high--] = temp;                 // post-decrement of high
        }
    }
}

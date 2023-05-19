package com.zybooks.dsaj.list;

import com.zybooks.dsaj.util.Position;

/**
 * Provides an insertion sort implementation for a PositionalList.
 */
public class InsertionSort {

    /** Insertion-sort of a positional list of integers into nondecreasing order */
    public static void insertionSort(PositionalList<Integer> list) {
        Position<Integer> marker = list.first();           // last position known to be sorted
        while (marker != list.last()) {
            Position<Integer> pivot = list.after(marker);
            int value = pivot.getElement();                // number to be placed
            if (value > marker.getElement())               // pivot is already sorted
                marker = pivot;
            else {                                         // must relocate pivot
                Position<Integer> walk = marker;           // find leftmost item greater than value
                while (walk != list.first() && list.before(walk).getElement() > value)
                    walk = list.before(walk);
                list.remove(pivot);                        // remove pivot entry and
                list.addBefore(walk, value);               // reinsert value in front of walk
            }
        }
    }

    public static void main(String[] args) {
        int[][] tests = {
            {},
            {1},
            {1, 2},
            {2, 1},
            {3, 5, 2, 4, 1, 9, 10, 12, 11, 8, 7, 6},
        };

        for (int[] raw : tests) {
            PositionalList<Integer> data = new LinkedPositionalList<>();
            for (int c : raw)
                data.addLast(c);
            System.out.println("Before: " + data);
            insertionSort(data);
            System.out.println("After:  " + data);
            System.out.println();
        }
    }
}

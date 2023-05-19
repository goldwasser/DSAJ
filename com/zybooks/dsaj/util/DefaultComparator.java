package com.zybooks.dsaj.util;

import java.util.Comparator;

/**
 * Comparator based on the compareTo method of a Comparable element type.
 *
 * @param <E> an element type
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class DefaultComparator<E> implements Comparator<E> {

    /**
     * Compares two elements.
     *
     * @param a  the first of two elements to compare
     * @param b  the second of two elements to compare
     *
     * @return a negative integer if <code>a</code> is less than <code>b</code>,
     * zero if <code>a</code> equals <code>b</code>, or a positive integer if
     * <code>a</code> is greater than <code>b</code>
     */
    @SuppressWarnings({"unchecked"})
    public int compare(E a, E b) throws ClassCastException {
        return ((Comparable<E>) a).compareTo(b);
    }
}

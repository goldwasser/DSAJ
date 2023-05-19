package com.zybooks.dsaj.list;

import java.util.Iterator;

/**
 * A simplified version of the java.util.List interface.
 *
 * @param <E> the element type
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public interface List<E> extends Iterable<E> {
    /**
     * Returns the number of elements in the list.
     * @return number of elements in the list
     */
    int size();

    /**
     * Tests whether the list is empty.
     * @return true if the list is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Returns (but does not remove) the element at index i.
     * @param  i   the index of the element to return
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is negative or greater than size()-1
     */
    E get(int i) throws IndexOutOfBoundsException;

    /**
     * Replaces the element at the specified index, and returns the element previously stored.
     * @param  i   the index of the element to replace
     * @param  e   the new element to be stored
     * @return the previously stored element
     * @throws IndexOutOfBoundsException if the index is negative or greater than size()-1
     */
    E set(int i, E e) throws IndexOutOfBoundsException;

    /**
     * Inserts the given element at the specified index of the list, shifting all
     * subsequent elements in the list one position further to make room.
     * @param  i   the index at which the new element should be stored
     * @param  e   the new element to be stored
     * @throws IndexOutOfBoundsException if the index is negative or greater than size()
     */
    void add(int i, E e) throws IndexOutOfBoundsException;

    /**
     * Removes and returns the element at the given index, shifting all subsequent
     * elements in the list one position closer to the front.
     * @param  i   the index of the element to be removed
     * @return the element that had be stored at the given index
     * @throws IndexOutOfBoundsException if the index is negative or greater than size()
     */
    E remove(int i) throws IndexOutOfBoundsException;

    /**
     * Returns an iterator of the elements stored in the list.
     * @return iterator of the list's elements
     */
    Iterator<E> iterator();
}

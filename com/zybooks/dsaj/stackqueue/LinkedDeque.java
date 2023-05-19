package com.zybooks.dsaj.stackqueue;

import com.zybooks.dsaj.fundamental.DoublyLinkedList;
    
/**
 * Realization of a double-ended queue as an adaptation of a DoublyLinkedList.
 * All operations are performed in constant time.
 *
 * @param  <E> the element type
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 * @see com.zybooks.dsaj.fundamental.DoublyLinkedList
 */
public class LinkedDeque<E> implements Deque<E> {

    /** The primary storage for elements of the queue */
    private DoublyLinkedList<E> list = new DoublyLinkedList<>();   // an empty  list

    /** Constructs an initially empty queue. */
    public LinkedDeque() { }                  // new queue relies on the initially empty list

    /**
     * Returns the number of elements in the queue.
     * @return number of elements in the queue
     */
    @Override
    public int size() { return list.size(); }

    /**
     * Tests whether the queue is empty.
     * @return true if the queue is empty, false otherwise
     */
    @Override
    public boolean isEmpty() { return list.isEmpty(); }

    /**
     * Returns, but does not remove, the first element of the queue.
     * @return the first element of the queue (or null if empty)
     */
    @Override
    public E first() { return list.first(); }

    /**
     * Returns, but does not remove, the last element of the queue.
     * @return the last element of the queue (or null if empty)
     */
    @Override
    public E last() { return list.last(); }

    /**
     * Adds an element at the front of the queue.
     * @param element  the element to be added
     */
    @Override
    public void addFirst(E element) { list.addFirst(element); }

    /**
     * Adds an element at the back of the queue.
     * @param element  the element to be added
     */
    @Override
    public void addLast(E element) { list.addLast(element); }

    /**
     * Removes and returns the first element of the queue.
     * @return element removed (or null if empty)
     */
    @Override
    public E removeFirst() { return list.removeFirst(); }

    /**
     * Removes and returns the last element of the queue.
     * @return element removed (or null if empty)
     */
    @Override
    public E removeLast() { return list.removeLast(); }

    /** Produces a string representation of the contents of the queue.
     *  (from front to back). This exists for debugging purposes only.
     */
    public String toString() {
        return list.toString();
    }
}

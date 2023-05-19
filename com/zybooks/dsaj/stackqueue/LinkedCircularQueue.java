package com.zybooks.dsaj.stackqueue;

import com.zybooks.dsaj.fundamental.CircularlyLinkedList;

/**
 * Realization of a circular FIFO queue as an adaptation of a CircularlyLinkedList.
 * This provides one additional method not part of the general Queue interface.
 * A call to rotate() is a more efficient simulation of the combination
 * enqueue(dequeue()). All operations are performed in constant time.
 *
 * @param  <E> the element type
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 * @see CircularlyLinkedList
 */
public class LinkedCircularQueue<E> implements CircularQueue<E> {

    /** The primary storage for elements of the queue */
    private CircularlyLinkedList<E> circle = new CircularlyLinkedList<>();

    /** Creates an empty queue. */
    public LinkedCircularQueue() { }

    /**
     * Returns the number of elements in the queue.
     * @return number of elements in the queue
     */
    @Override
    public int size() {
        return circle.size();
    }

    /**
     * Tests whether the queue is empty.
     * @return true if the queue is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return circle.isEmpty();
    }

    /**
     * Adds an element at the rear of the queue.
     * @param element  the element to be added
     */
    @Override
    public void enqueue(E element) {
        circle.addLast(element);
    }

    /**
     * Returns, but does not remove, the first element of the queue.
     * @return the first element of the queue (or null if empty)
     */
    @Override
    public E first() {
        return circle.first();
    }

    /**
     * Removes and returns the first element of the queue.
     * @return element removed (or null if empty)
     */
    @Override
    public E dequeue() {
        return circle.removeFirst();
    }

    /**
     * Rotates the front element of the queue to the back of the queue.
     * This is a shorthand for enqueue(dequeue()), except that it does
     * nothing if the queue is empty, and it is implemented more efficiently
     * so that no nodes are created or destroyed.
     */
    @Override
    public void rotate() {
        circle.rotate();
    }

    /** Produces a string representation of the contents of the queue.
     *  (from front to back). This exists for debugging purposes only.
     */
    public String toString() {
        return circle.toString();
    }

}

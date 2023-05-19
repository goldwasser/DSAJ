package com.zybooks.dsaj.stackqueue;

/**
 * Implementation of the queue ADT using a fixed-length array. All
 * operations are performed in constant time. An exception is thrown
 * if an enqueue operation is attempted when the size of the queue is
 * equal to the length of the array.
 *
 * @param  <E> the element type
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */

public class ArrayQueue<E> implements Queue<E> {
    // instance variables
    /** Default array capacity. */
    public static final int CAPACITY = 1000;      // default array capacity

    /** Generic array used for storage of queue elements. */
    private E[] data;                             // generic array used for storage

    /** Index of the top element of the queue in the array. */
    private int f = 0;                            // index of the front element

    /** Current number of elements in the queue. */
    private int sz = 0;                           // current number of elements

    // constructors
    /** Constructs an empty queue using the default array capacity. */
    public ArrayQueue() {this(CAPACITY);}         // constructs queue with default capacity

    /**
     * Constructs and empty queue with the given array capacity.
     * @param capacity length of the underlying array
     */
    @SuppressWarnings({"unchecked"})
    public ArrayQueue(int capacity) {             // constructs queue with given capacity
        data = (E[]) new Object[capacity];        // safe cast; compiler may give warning
    }

    // methods
    /**
     * Returns the number of elements in the queue.
     * @return number of elements in the queue
     */
    @Override
    public int size() { return sz; }

    /** Tests whether the queue is empty. */
    @Override
    public boolean isEmpty() { return (sz == 0); }

    /**
     * Adds an element at the rear of the queue.
     * This method runs in O(1) time.
     * @param e   new element to be added
     * @throws IllegalStateException if the array storing the elements is full
     */
    @Override
    public void enqueue(E e) throws IllegalStateException {
        if (sz == data.length) throw new IllegalStateException("Queue is full");
        int avail = (f + sz) % data.length;   // use modular arithmetic
        data[avail] = e;
        sz++;
    }

    /**
     * Returns, but does not remove, the first element of the queue.
     * @return the first element of the queue (or null if empty)
     */
    @Override
    public E first() {
        if (isEmpty()) return null;
        return data[f];
    }

    /**
     * Removes and returns the first element of the queue.
     * @return element removed (or null if empty)
     */
    @Override
    public E dequeue() {
        if (isEmpty()) return null;
        E answer = data[f];
        data[f] = null;                           // dereference to help garbage collection
        f = (f + 1) % data.length;
        sz--;
        return answer;
    }

    /**
     * Returns a string representation of the queue as a list of elements.
     * This method runs in O(n) time, where n is the size of the queue.
     * @return textual representation of the queue.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        int k = f;
        for (int j=0; j < sz; j++) {
            if (j > 0)
                sb.append(", ");
            sb.append(data[k]);
            k = (k + 1) % data.length;
        }
        sb.append(")");
        return sb.toString();
    }
}

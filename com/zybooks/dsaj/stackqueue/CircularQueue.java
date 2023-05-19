package com.zybooks.dsaj.stackqueue;

/**
 * This provides one additional method not part of the general Queue interface.
 * A call to Q.rotate() is logically equivalent to the combination
 * Q.enqueue(Q.dequeue()), yet may be implemented more efficiently in some realizations.
 *
 * @param <E> the element type
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public interface CircularQueue<E> extends Queue<E> {
    /**
     * Rotates the front element of the queue to the back of the queue.
     * This does nothing if the queue is empty.
     */
    void rotate();
}

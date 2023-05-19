package com.zybooks.dsaj.stackqueue;

import com.zybooks.dsaj.fundamental.SinglyLinkedList;

/**
 * Realization of a stack as an adaptation of a SinglyLinkedList.
 * All operations are performed in constant time.
 *
 * @param  <E> the element type
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 * @see SinglyLinkedList
 */
public class LinkedStack<E> implements Stack<E> {

    /** The primary storage for elements of the stack */
    private SinglyLinkedList<E> list = new SinglyLinkedList<>();   // an empty list

    /** Constructs an initially empty stack. */
    public LinkedStack() { }                   // new stack relies on the initially empty list

    /**
     * Returns the number of elements in the stack.
     * @return number of elements in the stack
     */
    @Override
    public int size() { return list.size(); }

    /**
     * Tests whether the stack is empty.
     * @return true if the stack is empty, false otherwise
     */
    @Override
    public boolean isEmpty() { return list.isEmpty(); }

    /**
     * Adds an element at the top of the stack.
     * @param element   the element to be added
     */
    @Override
    public void push(E element) { list.addFirst(element); }

    /**
     * Returns, but does not remove, the element at the top of the stack.
     * @return top element in the stack (or null if empty)
     */
    @Override
    public E top() { return list.first(); }

    /**
     * Removes and returns the top element from the stack.
     * @return element removed (or null if empty)
     */
    @Override
    public E pop() { return list.removeFirst(); }

    /** Produces a string representation of the contents of the stack.
     *  (ordered from top to bottom)
     *
     * This exists for debugging purposes only.
     *
     * @return textual representation of the stack
     */
    public String toString() {
        return list.toString();
    }
}

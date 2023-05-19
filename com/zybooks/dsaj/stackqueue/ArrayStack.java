package com.zybooks.dsaj.stackqueue;

/**
 * Implementation of the stack ADT using a fixed-length array.  All
 * operations are performed in constant time. An exception is thrown
 * if a push operation is attempted when the size of the stack is
 * equal to the length of the array.
 *
 * @param <E> the element type
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class ArrayStack<E> implements Stack<E> {
    /** Default array capacity. */
    public static final int CAPACITY=1000;   // default array capacity

    /** Generic array used for storage of stack elements. */
    private E[] data;                        // generic array used for storage

    /** Index of the top element of the stack in the array. */
    private int t = -1;                      // index of the top element in stack

    /** Constructs an empty stack using the default array capacity. */
    public ArrayStack() { this(CAPACITY); }  // constructs stack with default capacity

    /**
     * Constructs and empty stack with the given array capacity.
     * @param capacity length of the underlying array
     */
    @SuppressWarnings({"unchecked"})
    public ArrayStack(int capacity) {        // constructs stack with given capacity
        data = (E[]) new Object[capacity];   // safe cast; compiler may give warning
    }

    /**
     * Returns the number of elements in the stack.
     * @return number of elements in the stack
     */
    @Override
    public int size() { return (t + 1); }

    /**
     * Tests whether the stack is empty.
     * @return true if the stack is empty, false otherwise
     */
    @Override
    public boolean isEmpty() { return (t == -1); }

    /**
     * Adds an element at the top of the stack.
     * @param e   the element to be added
     * @throws IllegalStateException if the array storing the elements is full
     */
    @Override
    public void push(E e) throws IllegalStateException {
        if (size() == data.length) throw new IllegalStateException("Stack is full");
        data[++t] = e;                       // increment t before storing new item
    }

    /**
     * Returns, but does not remove, the element at the top of the stack.
     * @return top element in the stack (or null if empty)
     */
    @Override
    public E top() {
        if (isEmpty()) return null;
        return data[t];
    }

    /**
     * Removes and returns the top element from the stack.
     * @return element removed (or null if empty)
     */
    @Override
    public E pop() {
        if (isEmpty()) return null;
        E answer = data[t];
        data[t] = null;                      // dereference to help garbage collection
        t--;
        return answer;
    }

    /**
     * Produces a string representation of the contents of the stack.
     * (ordered from top to bottom). This exists for debugging purposes only.
      *
     * @return textual representation of the stack
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        for (int j = t; j >= 0; j--) {
            sb.append(data[j]);
            if (j > 0) sb.append(", ");
        }
        sb.append(")");
        return sb.toString();
    }

    /** Demonstrates sample usage of a stack. */
    public static void main(String[] args) {
        Stack<Integer> S = new ArrayStack<>();  // contents: ()
        S.push(5);                              // contents: (5)
        S.push(3);                              // contents: (5, 3)
        System.out.println(S.size());           // contents: (5, 3)     outputs 2
        System.out.println(S.pop());            // contents: (5)        outputs 3
        System.out.println(S.isEmpty());        // contents: (5)        outputs false
        System.out.println(S.pop());            // contents: ()         outputs 5
        System.out.println(S.isEmpty());        // contents: ()         outputs true
        System.out.println(S.pop());            // contents: ()         outputs null
        S.push(7);                              // contents: (7)
        S.push(9);                              // contents: (7, 9)
        System.out.println(S.top());            // contents: (7, 9)     outputs 9
        S.push(4);                              // contents: (7, 9, 4)
        System.out.println(S.size());           // contents: (7, 9, 4)  outputs 3
        System.out.println(S.pop());            // contents: (7, 9)     outputs 4
        S.push(6);                              // contents: (7, 9, 6)
        S.push(8);                              // contents: (7, 9, 6, 8)
        System.out.println(S.pop());            // contents: (7, 9, 6)  outputs 8
    }
}

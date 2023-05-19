package com.zybooks.dsaj.design;

@SuppressWarnings({"unchecked"})
public class Portfolio<T> {
    T[] data;
    public Portfolio(int capacity) {
        /*
        data = new T[capacity];              // illegal; compiler error
       */
        data = (T[]) new Object[capacity];   // legal, but compiler warning
    }
    public T get(int index) { return data[index]; }
    public void set(int index, T element) { data[index] = element; }
}

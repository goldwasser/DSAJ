package com.zybooks.dsaj.pq;

import com.zybooks.dsaj.util.DefaultComparator;
import com.zybooks.dsaj.util.Entry;
import java.util.Comparator;

/**
 * An abstract base class to ease the implementation of the PriorityQueue interface.
 *
 * The base class provides three means of support:
 * 1) It defines a PQEntry class as a concrete implementation of the
 *    entry interface
 * 2) It provides an instance variable for a general Comparator and a
 *    protected method, compare(a, b), that makes use of the comparator.
 * 3) It provides an isEmpty implementation based upon the abstract size() method.
 *
 * @param <K> The key type (keys must be unique and comparable)
 * @param <V> The value type stored with each entry
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public abstract class AbstractPriorityQueue<K,V> implements PriorityQueue<K,V> {
    //---------------- nested PQEntry class ----------------
    /**
     * A concrete implementation of the Entry interface to be used within
     * a PriorityQueue implementation.
     *
     * @param <K> The key type (keys must be unique and comparable)
     * @param <V> The value type stored with each entry
     */
    protected static class PQEntry<K,V> implements Entry<K,V> {
        private K k;  // key
        private V v;  // value

        /**
         * Creates a new PQEntry
         *
         * @param key  The new entry's key
         * @param value  The new entry's value
         */
        public PQEntry(K key, V value) {
            k = key;
            v = value;
        }

        // methods of the Entry interface

        /**
         * Return the entry's key
         *
         * @return the entry's key
         */
        public K getKey() { return k; }
        
        /**
         * Return the entry's value
         *
         * @return the entry's value
         */
        public V getValue() { return v; }

        // utilities not exposed as part of the Entry interface

        /**
         * Set the entry's key
         *
         * @param key   the new key
         */
        protected void setKey(K key) { k = key; }

        /**
         * Set the entry's value
         *
         * @param value   the new value
         */
        protected void setValue(V value) { v = value; }

    } //----------- end of nested PQEntry class -----------

    /**
     * Factory function to create an entry storing key,value.
     *
     * @param key the key
     * @param value the value
     * @return the new PQEntry
     */
    protected PQEntry<K,V> createEntry(K key, V value) {
        return new PQEntry<K,V>(key,value);
    }

    // instance variable for an AbstractPriorityQueue
    /** The comparator defining the ordering of keys in the priority queue. */
    private Comparator<K> comp;

    /**
     * Creates an empty priority queue using the given comparator to order keys.
     * @param c comparator defining the order of keys in the priority queue
     */
    protected AbstractPriorityQueue(Comparator<K> c) { comp = c; }

    /** Creates an empty priority queue based on the natural ordering of its keys. */
    protected AbstractPriorityQueue() { this(new DefaultComparator<K>()); }

    /** 
     * Method for comparing two entries according to key 
     * 
     * @param a   the first entry to be compared
     * @param b   the second entry to be compared
     * @return a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
     */
    protected int compare(Entry<K,V> a, Entry<K,V> b) {
        return comp.compare(a.getKey(), b.getKey());
    }

    /**
     * Tests whether the priority queue is empty.
     * @return true if the priority queue is empty, false otherwise
     */
    @Override
    public boolean isEmpty() { return size() == 0; }
}

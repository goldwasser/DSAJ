package com.zybooks.dsaj.pq;

import com.zybooks.dsaj.util.Entry;

/**
 * Interface for the priority queue ADT.
 *
 * @param <K> The key type (keys must be unique and comparable)
 * @param <V> The value type stored with each entry
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public interface PriorityQueue<K,V> {

    /**
     * Returns the number of items in the priority queue.
     * @return number of items
     */
    int size();

    /**
     * Tests whether the priority queue is empty.
     * @return true if the priority queue is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Inserts a key-value pair and returns the entry created.
     * @param key     the key of the new entry
     * @param value   the associated value of the new entry
     * @return the entry storing the new key-value pair
     */
    Entry<K,V> insert(K key, V value);

    /**
     * Returns (but does not remove) an entry with minimal key.
     * @return entry having a minimal key (or null if empty)
     */
    Entry<K,V> min();

    /**
     * Removes and returns an entry with minimal key.
     * @return the removed entry (or null if empty)
     */
    Entry<K,V> removeMin();
}

package com.zybooks.dsaj.pq;

import com.zybooks.dsaj.util.Entry;
import com.zybooks.dsaj.util.Position;
import com.zybooks.dsaj.list.PositionalList;
import com.zybooks.dsaj.list.LinkedPositionalList;
import java.util.Comparator;

/**
 * An implementation of a priority queue with an unsorted list.
 *
 * @param <K> The key type (keys must be unique and comparable)
 * @param <V> The value type stored with each entry
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class UnsortedPriorityQueue<K,V> extends AbstractPriorityQueue<K,V> {
    /** primary collection of priority queue entries */
    private PositionalList<Entry<K,V>> list = new LinkedPositionalList<>();

    /** Creates an empty priority queue based on the natural ordering of its keys. */
    public UnsortedPriorityQueue() { super(); }

    /**
     * Creates an empty priority queue using the given comparator to order keys.
     *
     * @param comp comparator defining the order of keys in the priority queue
     */
    public UnsortedPriorityQueue(Comparator<K> comp) { super(comp); }

    /**
     * Returns the Position of an entry having minimal key.
     *
     * This should only be called on a nonempty priority queue
     * @return Position of entry with minimal key
     */
    private Position<Entry<K,V>> findMin() {    // only called when nonempty
        Position<Entry<K,V>> small = list.first();
        for (Position<Entry<K,V>> walk : list.positions())
            if (compare(walk.getElement(), small.getElement()) < 0)
                small = walk;                   // found an even smaller key
        return small;
    }

    /**
     * Inserts a key-value pair and returns the entry created.
     *
     * @param key     the key of the new entry
     * @param value   the associated value of the new entry
     * @return the entry storing the new key-value pair
     */
    @Override
    public Entry<K,V> insert(K key, V value) {
        Entry<K,V> newest = createEntry(key, value);
        list.addLast(newest);
        return newest;
    }

    /**
     * Returns (but does not remove) an entry with minimal key.
     *
     * @return entry having a minimal key (or null if empty)
     */
    @Override
    public Entry<K,V> min() {
        if (list.isEmpty()) return null;
        return findMin().getElement();
    }

    /**
     * Removes and returns an entry with minimal key.
     *
     * @return the removed entry (or null if empty)
     */
    @Override
    public Entry<K,V> removeMin() {
        if (list.isEmpty()) return null;
        return list.remove(findMin());
    }

    /**
     * Returns the number of items in the priority queue.
     *
     * @return number of items
     */
    @Override
    public int size() { return list.size(); }
}

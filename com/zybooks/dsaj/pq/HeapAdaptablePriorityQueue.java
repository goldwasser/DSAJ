package com.zybooks.dsaj.pq;

import com.zybooks.dsaj.util.Entry;
import java.util.Comparator;

/**
 * An implementation of an adaptable priority queue using an array-based heap.
 *
 * @param <K> The key type (keys must be unique and comparable)
 * @param <V> The value type stored with each entry
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class HeapAdaptablePriorityQueue<K,V> extends HeapPriorityQueue<K,V> implements AdaptablePriorityQueue<K,V> {

    //---------------- nested AdaptablePQEntry class ----------------
    /** 
     * Extension of the PQEntry to include location information. 
     *
     * @param <K> The key type (keys must be unique and comparable)
     * @param <V> The value type stored with each entry
     */
    protected static class AdaptablePQEntry<K,V> extends PQEntry<K,V> {
        private int index;                                // entry's current index within the heap
        public AdaptablePQEntry(K key, V value, int j) {
            super(key, value);                            // this sets the key and value
            index = j;                                    // this sets the new field
        }
        public int getIndex() { return index; }
        public void setIndex(int j) { index = j; }
    } //----------- end of nested AdaptablePQEntry class -----------

    /** Factory function to create an entry storing key,value. */
    @Override
    protected PQEntry<K,V> createEntry(K key, V value) {
        return new AdaptablePQEntry<K,V>(key,value,heap.size());  // new entry will always start in last position
    }
    
    /** Creates an empty adaptable priority queue using natural ordering of keys. */
    public HeapAdaptablePriorityQueue() { super(); }

    /**
     * Creates an empty adaptable priority queue using the given comparator to order keys.
     * @param comp comparator defining the order of keys in the priority queue
     */
    public HeapAdaptablePriorityQueue(Comparator<K> comp) { super(comp);}

    // ------------ protected utilities  ------------ 

    /**
     * Validates an entry to ensure it is location-aware.
     * @param entry an entry instance
     * @return the entry cast as an AdaptablePQEntry instance
     * @throws IllegalArgumentException if the given entry was not valid
     */
    protected AdaptablePQEntry<K,V> validate(Entry<K,V> entry) throws IllegalArgumentException {
        if (!(entry instanceof AdaptablePQEntry))
            throw new IllegalArgumentException("Invalid entry");
        AdaptablePQEntry<K,V> locator = (AdaptablePQEntry<K,V>) entry;   // safe
        int j = locator.getIndex();
        if (j >= heap.size() || heap.get(j) != locator)
            throw new IllegalArgumentException("Invalid entry");
        return locator;
    }

    /** Exchanges the entries at indices i and j of the array list. */
    @Override
    protected void swap(int i, int j) {
        super.swap(i,j);                                        // perform the swap
        ((AdaptablePQEntry<K,V>) heap.get(i)).setIndex(i);      // reset entry's index
        ((AdaptablePQEntry<K,V>) heap.get(j)).setIndex(j);      // reset entry's index
    }

    /** Restores the heap property by moving the entry at index j upward/downward.*/
    protected void bubble(int j) {
        if (j > 0 && compare(heap.get(j), heap.get(parent(j))) < 0)
            upheap(j);
        else
            downheap(j);                   // although it might not need to move
    }

    // ------------ public methods  ------------ 

    /**
     * Removes the given entry from the priority queue.
     *
     * @param entry  an entry of this priority queue
     * @throws IllegalArgumentException if e is not a valid entry for the priority queue.
     */
    @Override
    public void remove(Entry<K,V> entry) throws IllegalArgumentException {
        AdaptablePQEntry<K,V> locator = validate(entry);
        int j = locator.getIndex();
        if (j == heap.size() - 1)          // entry is at last position
            heap.remove(heap.size() - 1);  // so just remove it
        else {
            swap(j, heap.size() - 1);      // swap entry to last position
            heap.remove(heap.size() - 1);  // then remove it
            bubble(j);                     // and fix entry displaced by the swap
        }
    }

    /**
     * Replaces the key of an entry.
     *
     * @param entry  an entry of this priority queue
     * @param key    the new key
     */
    @Override
    public void replaceKey(Entry<K,V> entry, K key) throws IllegalArgumentException {
        AdaptablePQEntry<K,V> locator = validate(entry);
        locator.setKey(key);               // method inherited from PQEntry
        bubble(locator.getIndex());        // with new key, may need to move entry
    }

    /**
     * Replaces the value of an entry.
     *
     * @param entry  an entry of this priority queue
     * @param value  the new value
     * @throws IllegalArgumentException if e is not a valid entry for the priority queue.
     */
    @Override
    public void replaceValue(Entry<K,V> entry, V value) throws IllegalArgumentException {
        AdaptablePQEntry<K,V> locator = validate(entry);
        locator.setValue(value);           // method inherited from PQEntry
    }
}

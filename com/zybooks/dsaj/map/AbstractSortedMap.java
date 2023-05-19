package com.zybooks.dsaj.map;

import com.zybooks.dsaj.util.Entry;
import com.zybooks.dsaj.util.DefaultComparator;
import java.util.Comparator;

/**
 * An abstract base class to ease the implementation of the SortedMap interface.
 *
 * The base class provides the following means of support:
 *
 * 1) It defines a PQEntry class as a concrete implementation of the
 *    entry interface
 *
 * 2) It provides an instance variable for a general Comparator and
 *    protected methods, compare(a, b), that can perform key-key, entry-entry,
 *    or key-entry comparisons using the comparator.
 *
 * @param <K> The key type (keys must be unique and comparable)
 * @param <V> The value type
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public abstract class AbstractSortedMap<K,V>
    extends AbstractMap<K,V> implements SortedMap<K,V> {

    // instance variable for an AbstractSortedMap
    /** The comparator defining the ordering of keys in the map. */
    private Comparator<K> comp;

    /**
     * Initializes the comparator for the map.
     * @param c comparator defining the order of keys in the map
     */
    protected AbstractSortedMap(Comparator<K> c) {
        comp = c;
    }

    /** Initializes the map with a default comparator. */
    protected AbstractSortedMap() {
        this(new DefaultComparator<K>());    // default comparator uses natural ordering
    }

    
    /** 
     * Compares two entries according to their keys.
     *
     * @param a  the first entry to be compared
     * @param b  the second entry to be compared
     * @return a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
     */
    protected int compare(Entry<K,V> a, Entry<K,V> b) {
        return comp.compare(a.getKey(), b.getKey());
    }

    /** 
     * Compares a raw key and an entry's key.
     *
     * @param a  the key to be compared
     * @param b  the entry whose key should be compared
     * @return a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the key of the second argument.
     */
    protected int compare(K a, Entry<K,V> b) {
        return comp.compare(a, b.getKey());
    }

    /** 
     * Compares an entry's key and a raw key
     *
     * @param a  the entry whose key should be compared
     * @param b  the key to be compared
     * @return a negative integer, zero, or a positive integer as the first argument's key is less than, equal to, or greater than the second argument.
     */
    protected int compare(Entry<K,V> a, K b) {
        return comp.compare(a.getKey(), b);
    }

    /** 
     * Compares two raw keys
     *
     * @param a  the first key to be compared
     * @param b  the second key to be compared
     * @return a negative integer, zero, or a positive integer as the first key is less than, equal to, or greater than the second key.
     */
    protected int compare(K a, K b) {
        return comp.compare(a, b);
    }
}

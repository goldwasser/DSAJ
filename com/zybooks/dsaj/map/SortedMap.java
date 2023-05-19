package com.zybooks.dsaj.map;

import com.zybooks.dsaj.util.Entry;

/**
 * A map with additional support for keys from a total ordering.
 *
 * The total ordering is the natural ordering of keys, by default,
 * or it can be defined by providing an optional Comparator.
 *
 * All iterations will be in sorted order relative to the keys,
 * and additional methods provide for non-exact searches.
 * This interface is a simple variant that blends features of
 * java.util.SortedMap and java.util.NavigableMap.
 *
 * @param <K> The key type (keys must be unique and comparable)
 * @param <V> The value type
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public interface SortedMap<K,V> extends Map<K,V>{

    /**
     * Returns the entry having the least key (or null if map is empty).
     * @return entry with least key (or null if map is empty)
     */
    Entry<K,V> firstEntry();

    /**
     * Returns the entry having the greatest key (or null if map is empty).
     * @return entry with greatest key (or null if map is empty)
     */
    Entry<K,V> lastEntry();

    /**
     * Returns the entry with least key greater than or equal to given key
     * (or null if no such key exists).
     * @param key  the target key
     * @return entry with least key greater than or equal to given (or null if no such entry)
     * @throws IllegalArgumentException if the key is not compatible with the map
     */
    Entry<K,V> ceilingEntry(K key) throws IllegalArgumentException;

    /**
     * Returns the entry with greatest key less than or equal to given key
     * (or null if no such key exists).
     * @param key  the target key
     * @return entry with greatest key less than or equal to given (or null if no such entry)
     * @throws IllegalArgumentException if the key is not compatible with the map
     */
    Entry<K,V> floorEntry(K key) throws IllegalArgumentException;

    /**
     * Returns the entry with greatest key strictly less than given key
     * (or null if no such key exists).
     * @param key  the target key
     * @return entry with greatest key strictly less than given (or null if no such entry)
     * @throws IllegalArgumentException if the key is not compatible with the map
     */
    Entry<K,V> lowerEntry(K key) throws IllegalArgumentException;

    /**
     * Returns the entry with least key strictly greater than given key
     * (or null if no such key exists).
     * @param key  the target key
     * @return entry with least key strictly greater than given (or null if no such entry)
     * @throws IllegalArgumentException if the key is not compatible with the map
     */
    Entry<K,V> higherEntry(K key) throws IllegalArgumentException;

    /**
     * Returns an iterable containing all keys in the range from
     * <code>fromKey</code> inclusive to <code>toKey</code> exclusive.
     *
     * @param fromKey the lowest key allowed in the desired range
     * @param toKey the highest key allowed in the desired range
     * @return iterable with keys in desired range
     * @throws IllegalArgumentException if <code>fromKey</code> or <code>toKey</code> is not compatible with the map
     */
    Iterable<Entry<K,V>> subMap(K fromKey, K toKey) throws IllegalArgumentException;
}

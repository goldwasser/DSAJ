package com.zybooks.dsaj.map;

import com.zybooks.dsaj.util.Entry;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * An implementation of a map using a sorted table. All accessors run
 * in O(log n) worst-case time, other than subMap, which runs in O(s + log n)
 * where s is the size of the resulting submap, and the complete iterations
 * that run in O(n) time.
 *
 * @param <K> The key type (keys must be unique and comparable)
 * @param <V> The value type
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class SortedTableMap<K,V> extends AbstractSortedMap<K,V> {

    private ArrayList<MapEntry<K,V>> table = new ArrayList<>();

    /** Constructs an empty map using the natural ordering of keys. */
    public SortedTableMap() { super(); }

    /**
     * Constructs an empty map using the given comparator to order keys.
     * @param comp comparator defining the order of keys in the map
     */
    public SortedTableMap(Comparator<K> comp) { super(comp); }

    //  ---------------- private utilities ----------------
    
    /** Returns the index of target key, if found, else the index where target could be inserted. */
    private int ceilingIndex(K target) {
        int low = 0, high = table.size()-1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int comp = compare(target, table.get(mid));
            if (comp == 0)              // target was found
                return mid;             //   at table[mid]
            else if (comp < 0)          // target is smaller than table[mid]
                high = mid-1;           //   so continue searching left of mid
            else                        // target is larger than table[mid]
                low = mid+1;            //   so continue searching right of mid
        }
        return low;                     // low = 1+high in unsuccessful search
    }
    
    /** Utility returns the entry at index j, or else null if j is out of bounds. */
    private Entry<K,V> safeEntry(int j) {
        if (j < 0 || j >= table.size()) return null;
        return table.get(j);
    }

    //  ---------------- public methods ----------------

    /**
     * Returns the number of entries in the map.
     *
     * @return number of entries in the map
     */
    @Override
    public int size() { return table.size(); }

    /**
     * Returns the value associated with the specified key, or null if no such entry exists.
     *
     * @param key  the key whose associated value is to be returned
     * @return the associated value, or null if no such entry exists
     */
    @Override
    public V get(K key) {
        int j = ceilingIndex(key);
        if (j == size() || compare(key, table.get(j)) != 0) return null;   // no match
        return table.get(j).getValue();
    }

    /**
     * Associates the given value with the given key. If an entry with
     * the key was already in the map, this replaced the previous value
     * with the new one and returns the old value. Otherwise, a new
     * entry is added and null is returned.
     *
     * @param key    key with which the specified value is to be associated
     * @param value  value to be associated with the specified key
     * @return the previous value associated with the key (or null, if no such entry)
     */
    @Override
    public V put(K key, V value) {
        int j = ceilingIndex(key);
        if (j < size() && compare(key, table.get(j)) == 0)                 // match exists
            return table.get(j).setValue(value);
        table.add(j, new MapEntry<K,V>(key,value));                        // otherwise new
        return null;
    }

    /**
     * Removes the entry with the specified key, if present, and returns
     * its associated value. Otherwise does nothing and returns null.
     *
     * @param key  the key whose entry is to be removed from the map
     * @return the previous value associated with the removed key, or null if no such entry exists
     */
    @Override
    public V remove(K key) {
        int j = ceilingIndex(key);
        if (j == size() || compare(key, table.get(j)) != 0) return null;  // no match
        return table.remove(j).getValue();
    }

    /**
     * Returns the entry having the least key (or null if map is empty).
     * @return entry with least key (or null if map is empty)
     *
     */
    @Override
    public Entry<K,V> firstEntry() { return safeEntry(0); }

    /**
     * Returns the entry having the greatest key (or null if map is empty).
     *
     * @return entry with greatest key (or null if map is empty)
     */
    @Override
    public Entry<K,V> lastEntry() { return safeEntry(table.size()-1); }

    /**
     * Returns the entry with least key greater than or equal to given key
     * (or null if no such key exists).
     *
     * @param key the target key
     * @return entry with least key greater than or equal to given (or null if no such entry)
     */
    @Override
    public Entry<K,V> ceilingEntry(K key) {
        return safeEntry(ceilingIndex(key));
    }

    /**
     * Returns the entry with greatest key less than or equal to given key
     * (or null if no such key exists).
     *
     * @param key the target key
     * @return entry with greatest key less than or equal to given (or null if no such entry)
     */
    @Override
    public Entry<K,V> floorEntry(K key) {
        int j = ceilingIndex(key);
        if (j == size() || ! key.equals(table.get(j).getKey()))
            j--;    // look one earlier (unless we had found a perfect match)
        return safeEntry(j);
    }

    /**
     * Returns the entry with greatest key strictly less than given key
     * (or null if no such key exists).
     *
     * @param key the target key
     * @return entry with greatest key strictly less than given (or null if no such entry)
     */
    @Override
    public Entry<K,V> lowerEntry(K key) {
        return safeEntry(ceilingIndex(key) - 1);   // go strictly before the ceiling entry
    }

    /**
     * Returns the entry with least key strictly greater than given key
     * (or null if no such key exists).
     *
     * @param key the target key
     * @return entry with least key strictly greater than given (or null if no such entry)
     */
    @Override
    public Entry<K,V> higherEntry(K key) {
        int j = ceilingIndex(key);
        if (j < size() && key.equals(table.get(j).getKey()))
            j++;    // go past exact match
        return safeEntry(j);
    }

    //  ------- support for snapshot iterators for entrySet() and subMap() follow -------
    private Iterable<Entry<K,V>> snapshot(int startIndex, K stop) {
        ArrayList<Entry<K,V>> buffer = new ArrayList<>();
        int j = startIndex;
        while (j < table.size() && (stop == null || compare(stop, table.get(j)) > 0))
            buffer.add(table.get(j++));
        return buffer;
    }

    /**
     * Returns an iterable collection of all key-value entries of the map.
     *
     * @return iterable collection of the map's entries
     */
    @Override
    public Iterable<Entry<K,V>> entrySet() { return snapshot(0, null); }

    /**
     * Returns an iterable containing all keys in the range from
     *
     * <code>fromKey</code> inclusive to <code>toKey</code> exclusive.
     * @param fromKey  the low end of the submap
     * @param toKey  the high end of the submap
     * @return iterable with keys in desired range
     */
    @Override
    public Iterable<Entry<K,V>> subMap(K fromKey, K toKey) {
        return snapshot(ceilingIndex(fromKey), toKey);
    }
}

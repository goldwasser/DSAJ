package com.zybooks.dsaj.map;

import com.zybooks.dsaj.util.Entry;
import com.zybooks.dsaj.util.DefaultComparator;
import java.util.Iterator;

/**
 * An abstract base class to ease the implementation of the Map interface.
 *
 * The base class provides three means of support:
 * 1) It defines a protected MapEntry class as a concrete implementation of the
 *    entry interface
 * 2) It provides an isEmpty implementation based upon the abstract size() method.
 * 3) It provides implemenations of the keySet and values methods, based upon use
 *    of a presumed implementation of the entrySet method.
 *
 * @param <K> The key type (keys must be unique)
 * @param <V> The value type
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public abstract class AbstractMap<K,V> implements Map<K,V> {

    //---------------- nested MapEntry class ----------------
    /**
     * A concrete implementation of the Entry interface to be used
     * within a Map implementation.
     *
     * @param <K> The key type (keys must be unique)
     * @param <V> The value type
     */
    protected static class MapEntry<K,V> implements Entry<K,V> {
        private K k;  // key
        private V v;  // value

        /**
         * Creates a new entry
         *
         * @param key   the key to be stored
         * @param value the associate value to be stored
         */
        public MapEntry(K key, V value) {
            k = key;
            v = value;
        }

        // public methods of the Entry interface

        /**
         * Returns the entry's key
         * @return the entry's key
         */
        public K getKey() { return k; }
        
        /**
         * Returns the entry's value
         * @return the entry's value
         */
        public V getValue() { return v; }

        // utilities not exposed as part of the Entry interface

        /**
         * Sets the entry's key
         * @param key the new key
         */
        protected void setKey(K key) { k = key; }

        /**
         * Sets the entry's value
         * @param value   the new value
         * @return the old value
         */
        protected V setValue(V value) {
            V old = v;
            v = value;
            return old;
        }

        /** 
         * Returns string representation (for debugging only)
         * @return string representation (for debugging only)
         */
        public String toString() { return "<" + k + ", " + v + ">"; }
    } //----------- end of nested MapEntry class -----------

    /**
     * Tests whether the map is empty.
     * @return true if the map is empty, false otherwise
     */
    @Override
    public boolean isEmpty() { return size() == 0; }         // presumes concrete implementation of size()

    // Provides support for keySet() and values() methods, based upon
    // the entrySet() method that must be provided by subclasses

    //---------------- nested KeyIterator class ----------------
    private class KeyIterator implements Iterator<K> {
        private Iterator<Entry<K,V>> entries = entrySet().iterator();   // reuse entrySet
        public boolean hasNext() { return entries.hasNext(); }
        public K next() { return entries.next().getKey(); }             // return key!
        public void remove() { entries.remove(); }
    } //----------- end of nested KeyIterator class -----------

    //---------------- nested KeyIterable class ----------------
    private class KeyIterable implements Iterable<K> {
        public Iterator<K> iterator() { return new KeyIterator(); }
    } //----------- end of nested KeyIterable class -----------

    /**
     * Returns an iterable collection of the keys contained in the map.
      *
     * @return iterable collection of the map's keys
     */
    @Override
    public Iterable<K> keySet() { return new KeyIterable(); }

    //---------------- nested ValueIterator class ----------------
    private class ValueIterator implements Iterator<V> {
        private Iterator<Entry<K,V>> entries = entrySet().iterator();   // reuse entrySet
        public boolean hasNext() { return entries.hasNext(); }
        public V next() { return entries.next().getValue(); }           // return value!
        public void remove() { entries.remove(); }
    } //----------- end of nested ValueIterator class -----------

    //---------------- nested ValueIterable class ----------------
    private class ValueIterable implements Iterable<V> {
        public Iterator<V> iterator() { return new ValueIterator(); }
    } //----------- end of nested ValueIterable class -----------

    /**
     * Returns an iterable collection of the values contained in the map.
     * Note that the same value will be given multiple times in the result
     * if it is associated with multiple keys.
      *
     * @return iterable collection of the map's values
     */
    @Override
    public Iterable<V> values() { return new ValueIterable(); }
}

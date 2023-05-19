package com.zybooks.dsaj.util;

/**
 * Interface for a key-value pair.
 *
 * @param <K> the key type
 * @param <V> the value type
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public interface Entry<K,V> {
    /**
     * Returns the key stored in this entry.
     * @return the entry's key
     */
    K getKey();

    /**
     * Returns the value stored in this entry.
     * @return the entry's value
     */
    V getValue();
}

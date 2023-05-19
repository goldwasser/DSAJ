package com.zybooks.dsaj.map;

import java.util.AbstractMap;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/** An adaptation of a map into a multimap, by mapping to a list of values. */
public class HashMultimap<K,V> {
    Map<K,List<V>> map = new HashMap<>();     // the primary map
    int total = 0;                            // total number of entries in the multimap

    /** Constructs an empty multimap. */
    public HashMultimap() { }

    /** Returns the total number of entries in the multimap. */
    public int size() { return total; }

    /** Returns whether the multimap is empty. */
    public boolean isEmpty() { return (total == 0); }

    /** Returns a (possibly empty) iteration of all values associated with the key. */
    Iterable<V> get(K key) {
        List<V> secondary = map.get(key);
        if (secondary != null)
            return secondary;
        return new ArrayList<>();             // return an empty list of values
    }

    /** Adds a new entry associating key with value. */
    void put(K key, V value) {
        List<V> secondary = map.get(key);
        if (secondary == null) {
            secondary = new ArrayList<>();
            map.put(key, secondary);          // begin using new list as secondary structure
        }
        secondary.add(value);
        total++;
    }

    /** Removes the (key,value) entry, if it exists. */
    boolean remove(K key, V value) {
        boolean wasRemoved = false;
        List<V> secondary = map.get(key);
        if (secondary != null) {
            wasRemoved = secondary.remove(value);
            if (wasRemoved) {
                total--;
                if (secondary.isEmpty())
                    map.remove(key);          // remove secondary structure from primary map
            }
        }
        return wasRemoved;
    }

    /** Removes all entries with the given key. */
    Iterable<V> removeAll(K key) {
        List<V> secondary = map.get(key);
        if (secondary != null) {
            total -= secondary.size();
            map.remove(key);
        } else
            secondary = new ArrayList<>();    // return empty list of removed values
        return secondary;
    }

    /** Returns an iteration of all entries in the multimap. */
    Iterable<Map.Entry<K,V>> entries() {
        List<Map.Entry<K,V>> result = new ArrayList<>();
        for (Map.Entry<K,List<V>> secondary : map.entrySet()) {
            K key = secondary.getKey();
            for (V value : secondary.getValue())
                result.add(new AbstractMap.SimpleEntry<K,V>(key,value));
        }
        return result;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<K,V> e : entries())
            sb.append(String.format(" (%s, %s)", e.getKey(), e.getValue()));
        return sb.toString();
    }

    public static void main(String[] args) {

        HashMultimap<Integer,String> mm = new HashMultimap<>();
        System.out.println("Size: " + mm.size() + ";" + mm);

        mm.put(5,"maroon");
        System.out.println("Size: " + mm.size() + ";" + mm);

        mm.put(4,"fab");
        System.out.println("Size: " + mm.size() + ";" + mm);

        mm.put(5,"jackson");
        System.out.println("Size: " + mm.size() + ";" + mm);

        mm.put(5,"for fighting");
        System.out.println("Size: " + mm.size() + ";" + mm);

        System.out.println("get(3): " + mm.get(3));
        System.out.println("get(4): " + mm.get(4));
        System.out.println("get(5): " + mm.get(5));

        mm.remove(5,"jackson");
        System.out.println("Size: " + mm.size() + ";" + mm);

        mm.remove(4,"fab");
        System.out.println("Size: " + mm.size() + ";" + mm);

        mm.remove(3,"blind mice");
        System.out.println("Size: " + mm.size() + ";" + mm);

        mm.removeAll(3);
        System.out.println("Size: " + mm.size() + ";" + mm);

        mm.removeAll(5);
        System.out.println("Size: " + mm.size() + ";" + mm);

    }

}

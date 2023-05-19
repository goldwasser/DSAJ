package com.zybooks.dsaj.searchtree;

import com.zybooks.dsaj.util.Entry;
import com.zybooks.dsaj.util.Position;
import java.util.Comparator;

/**
 * An implementation of a sorted map using a splay tree.
 *
 * @param <K> The key type (keys must be unique and comparable)
 * @param <V> The value type
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class SplayTreeMap<K,V> extends TreeMap<K,V> {

    /** Constructs an empty map using the natural ordering of keys. */
    public SplayTreeMap() { super(); }

    /**
     * Constructs an empty map using the given comparator to order keys.
     * @param comp comparator defining the order of keys in the map
     */
    public SplayTreeMap(Comparator<K> comp) { super(comp); }

    /** Utility used to rebalance after a map operation. */
    private void splay(Position<Entry<K,V>> p) {
        while (!isRoot(p)) {
            Position<Entry<K,V>> parent = parent(p);
            Position<Entry<K,V>> grand = parent(parent);
            if (grand == null)                                          // zig case
                rotate(p);
            else if ((parent == left(grand)) == (p == left(parent))) {  // zig-zig case
                rotate(parent);      // move PARENT upward
                rotate(p);           // then move p upward
            } else {                                                    // zig-zag case
                rotate(p);           // move p upward
                rotate(p);           // move p upward again
            }
        }
    }

    /** Overrides the TreeMap rebalancing hook that is called after a node access. */
    @Override
    protected void rebalanceAccess(Position<Entry<K,V>> p) {
        if (isExternal(p)) p = parent(p);
        if (p != null) splay(p);
    }

    /** Overrides the TreeMap rebalancing hook that is called after an insertion. */
    @Override
    protected void rebalanceInsert(Position<Entry<K,V>> p) {
        splay(p);
    }

    /** Overrides the TreeMap rebalancing hook that is called after a deletion. */
    @Override
    protected void rebalanceDelete(Position<Entry<K,V>> p) {
        if (!isRoot(p)) splay(parent(p));
    }
}

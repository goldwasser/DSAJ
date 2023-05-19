package com.zybooks.dsaj.graph;

import com.zybooks.dsaj.util.Position;

/**
 * A Union-Find structure for maintaining disjoint sets.
 *
 * @param <E> the element type
 */
public class Partition<E> {

    //--------------- nested Locator class -------------
    private class Locator<E> implements Position<E> {
        public E element;
        public int size;
        public Locator<E> parent;
        public Locator(E elem) {
            element = elem;
            size = 1;
            parent = this;          // convention for a cluster leader
        }

        public E getElement() { return element; }

        private boolean validate(Partition<E> universe) {
            return Partition.this == universe;
        }
    } //--------- end of nested Locator class ---------

    /** Validates a Position and returns it cast as a Locator. */
    private Locator<E> validate(Position<E> pos) {
        if (!(pos instanceof Locator)) throw new IllegalArgumentException("Invalid position");
        Locator<E> loc = (Locator<E>) pos;
        if (!loc.validate(this))
            throw new IllegalArgumentException("Position does not belong to this structure");
        return loc;
    }

    /** Makes a new cluster containing element e and returns its position. */
    public Position<E> makeCluster(E e) {
        return new Locator<E>(e);
    }

    /**
     * Finds the cluster containing the element identified by Position p
     * and returns the Position of the cluster's leader.
     */
    public Position<E> find(Position<E> p) {
        Locator<E> loc = validate(p);
        if (loc.parent != loc)
            loc.parent = (Locator<E>) find(loc.parent);   // overwrite parent after recursion
        return loc.parent;
    }

    /** Merges the clusters containing elements with positions p and q (if distinct). */
    public void union(Position<E> p, Position<E> q) {
        Locator<E> a = (Locator<E>) find(p);
        Locator<E> b = (Locator<E>) find(q);
        if (a != b)
            if (a.size > b.size) {
                b.parent = a;
                a.size += b.size;
            } else {
                a.parent = b;
                b.size += a.size;
            }
    }
}

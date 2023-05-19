package com.zybooks.dsaj.graph;

/**
 * An edge of a graph.
 *
 * @param <E> type for associated element stored with edge
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public interface Edge<E> {
    /** Returns the element associated with the edge. */
    E getElement();
}

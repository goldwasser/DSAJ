package com.zybooks.dsaj.graph;

/**
 * A vertex of a graph.
 *
 * @param <V> type for associated element stored with edge
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public interface Vertex<V> {
    /** Returns the element associated with the vertex. */
    V getElement();
}

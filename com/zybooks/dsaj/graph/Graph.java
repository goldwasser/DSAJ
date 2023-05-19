package com.zybooks.dsaj.graph;

/**
 * An interface for a graph structure. A graph can be declared as either directed or undirected.
 * In the case of an undirected graph, methods outgoingEdges and incomingEdges return the same collection,
 * and outDegree and inDegree return the same value.
 *
 * @param <V>  type for associated element stored at each vertex
 * @param <E>  type for associated element stored at each edge
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public interface Graph<V,E> {

    /**
     * Returns the number of vertices of the graph.
     * @return the number of vertices of the graph
     */
    int numVertices();

    /**
     * Returns the number of edges of the graph.
     * @return the number of edges of the graph
     */
    int numEdges();

    /** 
     * Returns the vertices of the graph as an iterable collection.
     * @return the vertices of the graph as an iterable collection
     */
    Iterable<Vertex<V>> vertices();

    /**
     * Returns the edges of the graph as an iterable collection.
     * @return the edges of the graph as an iterable collection
     */
    Iterable<Edge<E>> edges();

    /**
     * Returns the number of edges leaving vertex v.
     * Note that for an undirected graph, this is the same result
     * returned by inDegree
     *
     * @param v the vertex
     * @return the number of edges leaving vertex v
     * @throws IllegalArgumentException if v is not a valid vertex
     */
    int outDegree(Vertex<V> v) throws IllegalArgumentException;

    /**
     * Returns the number of edges for which vertex v is the destination.
     * Note that for an undirected graph, this is the same result
     * returned by outDegree
     *
     * @param v the vertex
     * @return the number of edges for which vertex v is the destination
     * @throws IllegalArgumentException if v is not a valid vertex
     */
    int inDegree(Vertex<V> v) throws IllegalArgumentException;

    /**
     * Returns an iterable collection of edges for which vertex v is the origin.
     * Note that for an undirected graph, this is the same result
     * returned by incomingEdges.
     *
     * @param v the vertex
     * @return an iterable collection of edges for which vertex v is the origin
     * @throws IllegalArgumentException if v is not a valid vertex
     */
    Iterable<Edge<E>> outgoingEdges(Vertex<V> v) throws IllegalArgumentException;

    /**
     * Returns an iterable collection of edges for which vertex v is the destination.
     * Note that for an undirected graph, this is the same result
     * returned by outgoingEdges.
     *
     * @param v the vertex
     * @return an iterable collection of edges for which vertex v is the destination
     * @throws IllegalArgumentException if v is not a valid vertex
     */
    Iterable<Edge<E>> incomingEdges(Vertex<V> v) throws IllegalArgumentException;

    /**
     * Returns the edge from u to v, or null if they are not adjacent.
     *
     * @param u origin vertex
     * @param v destination vertex
     * @return the edge from u to v, or null if they are not adjacent.
     */
    Edge<E> getEdge(Vertex<V> u, Vertex<V> v) throws IllegalArgumentException;

    /**
     * Returns the vertices of edge e as an array of length two.
     * If the graph is directed, the first vertex is the origin, and
     * the second is the destination.  If the graph is undirected, the
     * order is arbitrary.
     *
     * @param e edge
     * @return an array of length two containing the vertices of edge e
     */
    Vertex<V>[] endVertices(Edge<E> e) throws IllegalArgumentException;

    /**
     * Returns the vertex that is opposite to vertex v on edge e. 
     *
     * @param v an incident vertex to edge e
     * @param e an edge incident to vertex v
     * @return the vertex that is opposite to vertex v on edge e
     */
    Vertex<V> opposite(Vertex<V> v, Edge<E> e) throws IllegalArgumentException;

    /**
     * Inserts and returns a new vertex with the given element.
     *
     * @param element   data to be stored at newly created vertex
     * @return newly created Vertex instance
     */
    Vertex<V> insertVertex(V element);

    /**
     * Inserts and returns a new edge between vertices u and v, storing given element.
     *
     * @param u         origin of new edge
     * @param v         destination of new edge
     * @param element   data to be stored at newly created edge
     * @return newly created Edge instance
     * @throws IllegalArgumentException if u or v are invalid vertices, or if an edge already exists between u and v.
     */
    Edge<E> insertEdge(Vertex<V> u, Vertex<V> v, E element) throws IllegalArgumentException;

    /**
     * Removes a vertex and all its incident edges from the graph. 
     *
     * @param v  the vertex to remove
     */
    void removeVertex(Vertex<V> v) throws IllegalArgumentException;

    /**
     * Removes an edge from the graph. 
     *
     * @param e   the edge to remove
     */
    void removeEdge(Edge<E> e) throws IllegalArgumentException;
}

package com.zybooks.dsaj.tree;

import com.zybooks.dsaj.util.Position;
import java.util.Iterator;

/**
 * An interface for a tree where nodes can have an arbitrary number of children.
 *
 * @param <E> Element to be stored at each position of the tree.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public interface Tree<E> extends Iterable<E> {

    /**
     * Returns the root Position of the tree (or null if tree is empty).
     * @return root Position of the tree (or null if tree is empty)
     */
    Position<E> root();

    /**
     * Returns the Position of p's parent (or null if p is root).
      *
     * @param p    A valid Position within the tree
     * @return Position of p's parent (or null if p is root)
     * @throws IllegalArgumentException if p is not a valid Position for this tree.
     */
    Position<E> parent(Position<E> p) throws IllegalArgumentException;

    /**
     * Returns an iterable collection of the Positions representing p's children.
      *
     * @param p    A valid Position within the tree
     * @return iterable collection of the Positions of p's children
     * @throws IllegalArgumentException if p is not a valid Position for this tree.
     */
    Iterable<Position<E>> children(Position<E> p)
                                   throws IllegalArgumentException;

    /**
     * Returns the number of children of Position p.
      *
     * @param p    A valid Position within the tree
     * @return number of children of Position p
     * @throws IllegalArgumentException if p is not a valid Position for this tree.
     */
    int numChildren(Position<E> p) throws IllegalArgumentException;

    /**
     * Returns true if Position p has one or more children.
      *
     * @param p    A valid Position within the tree
     * @return true if p has at least one child, false otherwise
     * @throws IllegalArgumentException if p is not a valid Position for this tree.
     */
    boolean isInternal(Position<E> p) throws IllegalArgumentException;

    /**
     * Returns true if Position p does not have any children.
      *
     * @param p    A valid Position within the tree
     * @return true if p has zero children, false otherwise
     * @throws IllegalArgumentException if p is not a valid Position for this tree.
     */
    boolean isExternal(Position<E> p) throws IllegalArgumentException;

    /**
     * Returns true if Position p represents the root of the tree.
      *
     * @param p    A valid Position within the tree
     * @return true if p is the root of the tree, false otherwise
     * @throws IllegalArgumentException if p is not a valid Position for this tree.
     */
    boolean isRoot(Position<E> p) throws IllegalArgumentException;

    /**
     * Returns the number of nodes in the tree.
     * @return number of nodes in the tree
     */
    int size();

    /**
     * Tests whether the tree is empty.
     * @return true if the tree is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Returns an iterator of the elements stored in the tree.
     * @return iterator of the tree's elements
     */
    Iterator<E> iterator();

    /**
     * Returns an iterable collection of the positions of the tree.
     * @return iterable collection of the tree's positions
     */
    Iterable<Position<E>> positions();
}

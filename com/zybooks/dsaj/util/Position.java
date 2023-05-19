package com.zybooks.dsaj.util;

/**
 * An interface for a position which is an abstraction for the
 * location at which a single element is stored in a positional
 * container.
 *
 * @param <E> the element type stored at a position
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public interface Position<E> {
    /**
     * Returns the element stored at this position.
      *
     * @return the stored element
     * @throws IllegalStateException if position no longer valid
     */
    E getElement() throws IllegalStateException;
}

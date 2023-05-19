package com.zybooks.dsaj.list;

import com.zybooks.dsaj.util.Position;

/**
   A list of elements, ordered from most recently to least recently accessed.
   @param <E> The element type
 */
public class FavoritesListMTF<E> extends FavoritesList<E> {

    /** Moves accessed item at Position p to the front of the list. */
    @Override
    protected void moveUp(Position<Item<E>> p) {
        if (p != list.first())
            list.addFirst(list.remove(p));     // remove/reinsert item
    }

    /** Returns an iterable collection of the k most frequently accessed elements. */
    @Override
    public Iterable<E> getFavorites(int k) throws IllegalArgumentException {
        if (k < 0 || k > size())
            throw new IllegalArgumentException("Invalid k");

        // we begin by making a copy of the original list
        PositionalList<Item<E>> temp = new LinkedPositionalList<>();
        for (Item<E> item : list)
            temp.addLast(item);

        // we repeated find, report, and remove element with largest count
        PositionalList<E> result = new LinkedPositionalList<>();
        for (int j=0; j < k; j++) {
            Position<Item<E>> highPos = temp.first();
            Position<Item<E>> walk = temp.after(highPos);
            while (walk != null) {
                if (count(walk) > count(highPos))
                    highPos = walk;
                walk = temp.after(walk);
            }
            // we have now found element with highest count
            result.addLast(value(highPos));
            temp.remove(highPos);
        }
        return result;
    }

    // test usage
    public static void main(String[] args) {
        test(new FavoritesListMTF<Character>());
    }
}

package com.zybooks.dsaj.analysis;

/**
 * Demonstration of algorithms for testing three-way set disjointness.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
class DisjointSet {

    /** Returns true if there is no element common to all three arrays. */
    public static boolean disjoint1(int[] groupA, int[] groupB, int[] groupC) {
        for (int a : groupA)
            for (int b : groupB)
                for (int c : groupC)
                    if ((a == b) && (b == c))
                        return false;           // we found a common value
        return true;                            // if we reach this, sets are disjoint
    }

    /** Returns true if there is no element common to all three arrays. */
    public static boolean disjoint2(int[] groupA, int[] groupB, int[] groupC) {
        for (int a : groupA)
            for (int b : groupB)
                if (a == b)                     // only check C when we find match from A and B
                    for (int c : groupC)
                        if (a == c)             // and thus b == c as well
                            return false;       // we found a common value
        return true;                            // if we reach this, sets are disjoint
    }

}

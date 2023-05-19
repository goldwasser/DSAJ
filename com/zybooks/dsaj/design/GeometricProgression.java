package com.zybooks.dsaj.design;

/** A class producing a geometric progression of the form start, start*factor, start*factor*factor, ... */
public class GeometricProgression extends Progression {

    protected long base;

    /** Constructs progression 1, 2, 4, 8, 16, ... */
    public GeometricProgression() { this(2, 1); }        // start at 1 with base of 2

    /**
     * Constructs progression 1, b, b^2, b^3, b^4, ... for base b.
     *
     * @param b   the base of the geometric progression
     */
    public GeometricProgression(long b) { this(b, 1); }  // start at 1

    /**
     * Constructs geometric progression with arbitrary base and start.
     *
     * @param b       the base of the geometric progression
     * @param start   the first value of the progression
     */
    public GeometricProgression(long b, long start) {
        super(start);
        base = b;
    }

    /** Multiplies the current value by the geometric base. */
    protected void advance() {
        current *= base;                                 // multiply current by the geometric base
    }
}

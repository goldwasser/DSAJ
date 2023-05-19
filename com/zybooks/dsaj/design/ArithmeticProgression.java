package com.zybooks.dsaj.design;

/** A class producing an arithmetic progression of the form start, start+step, start+2*step, ... */
public class ArithmeticProgression extends Progression {

    /** The increment between consecutive values of the progression */
    protected long increment;

    /** Constructs progression 0, 1, 2, ... */
    public ArithmeticProgression() { this(1, 0); }  // start at 0 with increment of 1

    /**
     * Constructs progression 0, stepsize, 2*stepsize, ... 
     *
     * @param stepsize the step size for the progression
     */
    public ArithmeticProgression(long stepsize) { this(stepsize, 0); }  // start at 0

    /**
     * Constructs arithmetic progression with arbitrary start and increment. 
     *
     * @param stepsize the step size for the progression
     * @param start the first value of the progression
     */
    public ArithmeticProgression(long stepsize, long start) {
        super(start);
        increment = stepsize;
    }

    /** Adds the arithmetic increment to the current value. */
    protected void advance() {
        current += increment;
    }
}

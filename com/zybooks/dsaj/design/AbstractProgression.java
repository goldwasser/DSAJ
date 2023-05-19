package com.zybooks.dsaj.design;

/** Generates a simple progression. By default: 0, 1, 2, ... */
public abstract class AbstractProgression {

    // instance variable

    /** The value that will be reported by a call to nextValue(). */
    protected long current;

    /** Constructs a progression starting at zero. */
    public AbstractProgression() { this(0); }

    /**
     * Constructs a progression with given start value.
     *
     * @param start  the first value in the progression
     */
    public AbstractProgression(long start) { current = start; }

    /**
     * Returns the next value of the progression.
     *
     * @return the next value in the progression
     */
    public long nextValue() {                         // this is a concrete method
        long answer = current;
        advance();    // this protected call is responsible for advancing the current value
        return answer;
    }

    /** 
     * Utility that prints the next n values of the progression.
     *
     * @param n the number of value to print
     */
    public void printProgression(int n) {             // this is a concrete method
        System.out.print(nextValue());                // print first value without leading space
        for (int j=1; j < n; j++)
            System.out.print(" " + nextValue());      // print leading space before others
        System.out.println();                         // end the line
    }

    /** Advances the current value to the next value of the progression. */
    protected abstract void advance();                // notice the lack of a method body
}

package com.zybooks.dsaj.design;

/** Generates a simple progression. By default: 0, 1, 2, ... */
public class Progression {

    // instance variable
    protected long current;

    /** Constructs a progression starting at zero. */
    public Progression() { this(0); }

    /**
     * Constructs a progression with given start value.
     *
     * @param start  the first value of the progression 
     */
    public Progression(long start) { current = start; }

    /**
     * Returns the next value of the progression. 
     * @return the next value of the progression
     */
    public long nextValue() {
        long answer = current;
        advance();    // this protected call is responsible for advancing the current value
        return answer;
    }

    /** Advances the current value to the next value of the progression. */
    protected void advance() {
        current++;
    }

    /**
     * Prints the next n values of the progression, separated by spaces.
     *
     * @param n  number of terms to print
     */
    public void printProgression(int n) {
        System.out.print(nextValue());            // print first value without leading space
        for (int j=1; j < n; j++)
            System.out.print(" " + nextValue());  // print leading space before others
        System.out.println();                     // end the line
    }
}

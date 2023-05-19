package com.zybooks.dsaj.recursion;

/**
 * Demonstration of recursive factorial function.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class Factorial {

    /** Computes the factorial of the given (nonnegative) integer) */
    public static int factorial(int n) throws IllegalArgumentException {
        if (n < 0)
            throw new IllegalArgumentException();     // argument must be nonnegative
        else if (n == 0)
            return 1;                                 // base case
        else
            return n * factorial(n-1);                // recursive case
    }

    /** Simple test, assuming valid integer given as command-line argument */
    public static void main(String[] args) {
        if (args.length > 0) {
            int n = Integer.parseInt(args[0]);
            try { System.out.println("factorial("+n+") = " + factorial(n)); }
            catch (IllegalArgumentException e) {
                System.out.println("Error: the factorial function is undefined for negative integers"); }
        }
    }

}

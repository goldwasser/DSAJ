package com.zybooks.dsaj.recursion;

/**
 * Demonstration of two recursive approaches to computing Fibonacci numbers.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class Fibonacci {

    /** Returns the nth Fibonacci number (inefficiently). */
    public static long fibonacciBad(int n) {
        if (n <= 1)
            return n;
        else
            return fibonacciBad(n-2) + fibonacciBad(n-1);
    }

    /** Returns array containing the pair of Fibonacci numbers, F(n) and F(n-1). */
    public static long[] fibonacciGood(int n) {
        if (n <= 1) {
            long[] answer = {n, 0};
            return answer;
        } else {
            long[] temp = fibonacciGood(n - 1);            // returns { F(n-1), F(n-2) }
            long[] answer = {temp[0] + temp[1], temp[0]};  // we want { F(n), F(n-1) }
            return answer;
        }
    }

    /** Don't call this (infinite) version. */
    public static int fibonacci(int n) {
        return fibonacci(n);      // After all F(n) does equal F(n)
    }

    public static void main(String[] args) {
        final int limit = 50;

        System.out.println("The good...");
        for (int n = 0; n < limit; n++)
            System.out.println(n + ": " + fibonacciGood(n)[0]);

        System.out.println();
        System.out.println("The bad...");
        for (int n = 0; n < limit; n++)
            System.out.println(n + ": " + fibonacciBad(n));

        // Even worse...
        fibonacci(10); // the infinite one
    }

}

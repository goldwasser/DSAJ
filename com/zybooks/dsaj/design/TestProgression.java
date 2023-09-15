package com.zybooks.dsaj.design;

/** Test program for the progression hierarchy. */
public class TestProgression {
    public static void main(String[] args) {
        Progression prog;
        // test ArithmeticProgression
        System.out.print("Arithmetic progression with default increment: ");
        prog = new ArithmeticProgression();
        prog.printProgression(10);
        System.out.print("Arithmetic progression with increment 5: ");
        prog = new ArithmeticProgression(5);
        prog.printProgression(10);
        System.out.print("Arithmetic progression with increment 5 and start 2: ");
        prog = new ArithmeticProgression(5, 2);
        prog.printProgression(10);
        // test GeometricProgression
        System.out.print("Geometric progression with default base: ");
        prog = new GeometricProgression();
        prog.printProgression(10);
        System.out.print("Geometric progression with base 3: ");
        prog = new GeometricProgression(3);
        prog.printProgression(10);
        // test FibonacciProgression
        System.out.print("Fibonacci progression with default start values: ");
        prog = new FibonacciProgression();
        prog.printProgression(10);
        System.out.print("Fibonacci progression with start values 4 and 6: ");
        prog = new FibonacciProgression(4, 6);
        prog.printProgression(8);
    }
}

/*
Output from main method:

Arithmetic progression with default increment: 0 1 2 3 4 5 6 7 8 9
Arithmetic progression with increment 5: 0 5 10 15 20 25 30 35 40 45
Arithmetic progression with increment 5 and start 2: 2 7 12 17 22 27 32 37 42 47
Geometric progression with default base: 1 2 4 8 16 32 64 128 256 512
Geometric progression with base 3: 1 3 9 27 81 243 729 2187 6561 19683
Fibonacci progression with default start values: 0 1 1 2 3 5 8 13 21 34
Fibonacci progression with start values 4 and 6: 4 6 10 16 26 42 68 110

*/

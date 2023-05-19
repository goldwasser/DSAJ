package com.zybooks.dsaj.design;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/** A demonstration of a try-catch structure. */
public class ExceptionDemo {

    static final int DEFAULT = 100;

    public static void main(String[] args) {
        int n = DEFAULT;
        try {
            n = Integer.parseInt(args[0]);
            if (n <= 0) {
                System.out.println("n must be positive. Using default.");
                n = DEFAULT;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("No argument specified for n. Using default.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid integer argument. Using default.");
        }
        System.out.println("n has value: " + n);
    }


    public void ensurePositive(int n) {
        if (n < 0)
            throw new IllegalArgumentException("That's not positive!");
        // ...
    }
}

package com.zybooks.dsaj.recursion;

import java.util.Scanner;
import java.io.File;

/**
 * Supports the computation of the total disk space usage within a file system.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class DiskSpace {

    /**
     * Calculates the total disk usage (in bytes) of the portion of the file system rooted
     * at the given path, while printing a summary akin to the standard 'du' Unix tool.
     *
     * @param root designates a location in the file system
     * @return total number of bytes used by the designated portion of the file system
     */
    public static long diskUsage(File root) {
        long total = root.length();                          // start with direct disk usage
        if (root.isDirectory()) {                            // and if this is a directory,
            for (String childname : root.list()) {           // then for each child
                File child = new File(root, childname);      // compose full path to child
                total += diskUsage(child);                   // add child's usage to total
            }
        }
        System.out.println(total + "\t" + root);             // descriptive output
        return total;                                        // return the grand total
    }

    /**
     * Computes disk usage of the path given as a command line argument.
     * Sample usage:  java DiskSpace C:\Users\Michael
     */
    public static void main(String[] args) {
        String start;
        if (args.length > 0) {
            start = args[0];
        } else {
            System.out.print("Enter the starting location: ");
            start = new Scanner(System.in).next();
        }
        diskUsage(new File(start));
    }

}

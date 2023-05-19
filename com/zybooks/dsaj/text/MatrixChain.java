package com.zybooks.dsaj.text;

/** Demonstration of dynamic programming. */
public class MatrixChain {
    /**
     * Returns an n-by-n matrix such that N[i][j] represents the minimum number of
     * multiplications to compute the product of matrix chain product Ai through Aj inclusive.
     *
     * The parameter d is an array of n+1 numbers, such that the size of the kth
     * matrix is d[k]-by-d[k+1].
     */
    public static int[][] matrixChain(int[] d) {
        int n = d.length - 1;                      // number of matrices
        int[][] N = new int[n][n];                 // n-by-n matrix; initially zeros
        for (int b=1; b < n; b++)                  // number of products in subchain
            for (int i=0; i < n - b; i++) {        // start of subchain
                int j = i + b;                     // end of subchain
                N[i][j] = Integer.MAX_VALUE;       // used as 'infinity'
                for (int k=i; k < j; k++)
                    N[i][j] = Math.min(N[i][j], N[i][k] + N[k+1][j] + d[i]*d[k+1]*d[j+1]);
            }
        return N;
    }
}

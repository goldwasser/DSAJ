package com.zybooks.dsaj.text;

import java.util.ArrayList;

/** Algorithms for computing the longest common subsequence of two character sequences. */
public class LCS {

    /** Returns table such that L[j][k] is length of LCS for X[0..j-1] and Y[0..k-1]. */
    public static int[][] LCS(char[] X, char[] Y) {
        int n = X.length;
        int m = Y.length;
        int[][] L = new int[n+1][m+1];
        for (int j=0; j < n; j++)
            for (int k=0; k < m; k++)
                if (X[j] == Y[k])                // align this match
                    L[j+1][k+1] = L[j][k] + 1;
                else                             // choose to ignore one character
                    L[j+1][k+1] = Math.max(L[j][k+1], L[j+1][k]);
        return L;
    }

    /** Returns the longest common substring of X and Y, given LCS table L. */
    public static char[] reconstructLCS(char[] X, char[] Y, int[][] L) {
        StringBuilder solution = new StringBuilder();
        int j = X.length;
        int k = Y.length;
        while (L[j][k] > 0)                      // common characters remain
            if (X[j-1] == Y[k-1]) {
                solution.append(X[j-1]);
                j--;
                k--;
            } else if (L[j-1][k] >= L[j][k-1])
                j--;
            else
                k--;
        // return left-to-right version, as char array
        return solution.reverse().toString().toCharArray();
    }

}

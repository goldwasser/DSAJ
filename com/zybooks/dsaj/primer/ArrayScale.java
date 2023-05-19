package com.zybooks.dsaj.primer;

/**
 * Example of valid and invalid method for scaling a numeric array.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class ArrayScale {

    public static void scaleBad(double[] data, double factor) {
        for (double val : data)
            val *= factor;                      // changes local variable only
    }


    public static void scaleGood(double[] data, double factor) {
        for (int j=0; j < data.length; j++)
            data[j] *= factor;                  // overwrites cell of the array
    }

    public static void print(double[] data) {
        StringBuilder sb = new StringBuilder();
        for (double val : data)
            sb.append(" " + val);
        System.out.println(sb);
    }

    public static void main(String[] args) {
        double[] sample = {1.0, 2.0, 3.0, 4.0};
        print(sample);
        scaleBad(sample, 2);
        print(sample);
        scaleGood(sample, 3);
        print(sample);
    }

}

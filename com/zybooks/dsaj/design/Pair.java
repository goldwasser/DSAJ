package com.zybooks.dsaj.design;

@SuppressWarnings({"unchecked"})
public class Pair<A,B> {
    A first;
    B second;
    public Pair(A a, B b) {                            // constructor
        first = a;
        second = b;
    }
    public A getFirst() { return first; }
    public B getSecond() { return second;}
    public String toString() {
        return "[" + first + ", " + second + "]";
    }

    public static void main(String[] args) {
        Pair<String,Double> bid;
        bid = new Pair<>("ORCL", 32.07);               // rely on type inference

        // using Java6 style without type inference:
        bid = new Pair<String,Double>("ORCL", 32.07);  // give explicit types

        // using classic style without generics
        bid = new Pair("ORCL", 32.07);                 // classic style
        String stock = bid.getFirst();
        double price = bid.getSecond();

        Pair<String,Double>[] holdings;
        /*
        holdings = new Pair<String,Double>[25];        // illegal; compile error
        */
        holdings = new Pair[25];   // correct, but warning about unchecked cast
        holdings[0] = new Pair<>("ORCL", 32.07);       // valid element assignment
    }
}

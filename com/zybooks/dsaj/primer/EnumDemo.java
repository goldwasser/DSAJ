package com.zybooks.dsaj.primer;

/**
 * An example that uses an enumerated type.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class EnumDemo {
    /** An enumerated type for days of the week. */
    public enum Day {MON, TUE, WED, THU, FRI, SAT, SUN};

    public static void main(String[] args) {
        Day d = Day.MON;
        System.out.println("Initially d is " + d);  // enum is printed as "MON"
        d = Day.WED;
        System.out.println("Then it is " + d);
        for (Day a : Day.values()) {
            System.out.println("Day " + a);
            switchDemo(a);
        }
    }

    /**
     * Demonstrates the use of a switch statement based on the day.
     * @param d  one of the days of the week
     */
    public static void switchDemo(Day d) {
        switch (d) {
            case MON:
                System.out.println("This is tough.");
                break;
            case TUE:
                System.out.println("This is getting better.");
                break;
            case WED:
                System.out.println("Half way there.");
                break;
            case THU:
                System.out.println("I can see the light.");
                break;
            case FRI:
                System.out.println("Now we are talking.");
                break;
            default:
                System.out.println("Day off!");
        }
    }

}

/*
Output of main:

Initially d is MON
Then it is WED
I say d an t are the same: true
*/

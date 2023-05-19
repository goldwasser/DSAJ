package com.zybooks.dsaj.primer;

import java.util.Scanner;                  // loads Scanner definition for our use

public class InputExample {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your age in years: ");
        double age = input.nextDouble();
        System.out.print("Enter your maximum heart rate: ");
        double rate = input.nextDouble();
        double fb = (rate - age) * 0.65;
        System.out.println("Your ideal fat-burning heart rate is " + fb);
    }

    public static int getInt() {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter an integer: ");
        while (!input.hasNextInt()) {
            input.nextLine();
            System.out.print("Invalid integer; please enter an integer: ");
        }
        int i = input.nextInt();
        return i;
    }

}

/*
Sample user session
-------------------

Enter your age in years: 21
Enter your maximum heart rate: 220
Your target fat-burning heart rate is 129.35
*/

package com.myproject;

import com.myproject.longdivision.LongDivision;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {

            System.out.println("Type a dividend:");
            int dividend = Integer.parseInt(scanner.nextLine());

            System.out.println("Type a divisor:");
            int divisor = Integer.parseInt(scanner.nextLine());

            System.out.println("Result: \n" +
                    new LongDivision().divide(dividend, divisor));

        } catch (NumberFormatException e) {
            System.out.println("Error! Invalid input");
        }

    }
}

package com.pluralsight;

import java.util.Scanner;

public class PayrollCalculator {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("This is the Payroll Calculator");

        // User input name, hours worked, pay rate
        String name = promptName(myScanner);
        float hours = promptFloat(myScanner, "hours worked");
        float payRate = promptFloat(myScanner, "pay rate");

        // Calculate gross pay and print
        System.out.println(name + ", your paycheck is $" + String.format("%.2f", calculatePay(hours, payRate)));
    }

    public static String promptName(Scanner scanner) {
        System.out.print("Enter your name: ");
        return scanner.nextLine();
    }

    public static float promptFloat(Scanner scanner, String floatPrompt) {
        System.out.print("Enter your " + floatPrompt + ": ");
        float num = -1f;
        while (num < 0) {
            // If user inputs valid number
            if (scanner.hasNextFloat()) {
                num = scanner.nextFloat();
                if (num < 0) {
                    System.out.println("Please enter a positive number");
                }
                // If user did not input a valid number
            }  else {
                System.out.println("Please enter a valid number");
                // Eats the invalid input
                scanner.next();
            }
        }

        return num;
    }

    public static float calculatePay(float hours, float payRate) {
        float grossPay = 0;
        if  (hours > 40) {
            float overtime = hours - 40;
            grossPay = (payRate * 40) + (payRate * 1.5f * overtime);
        } else {
            grossPay = hours * payRate;
        }
        return grossPay;
    }
}
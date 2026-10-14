package com.pluralsight;

import java.util.Scanner;

public class PayrollCalculator {
    static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("This is the Payroll Calculator");

        // User input name, hours worked, pay rate
        System.out.print("Enter your name: ");
        String name = myScanner.nextLine();
        System.out.print("Enter your hours worked: ");
        float hours = myScanner.nextFloat();
        System.out.print("Enter your pay rate: ");
        float payRate = myScanner.nextFloat();

        // Calculate gross pay and output
        float grossPay = 0;
        if  (hours > 40) {
            float overtime = hours - 40;
            grossPay = (payRate * 40) + (payRate * 1.5f * overtime);
        } else {
            grossPay = hours * payRate;
        }
        System.out.println("Your paycheck: $" + String.format("%.2f", grossPay));
    }
}

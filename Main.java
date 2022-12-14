/*
 * Adam Rosas
 * CSC 300 - Homework 1
 * 09/22/2022
 */

/*
 * Mortgage = Principal * (interestRate (1 + interestRate)^n) / ((1
 * +interestRate)^n - 1)
 */

// import java.text.NumberFormat
import java.text.NumberFormat;
// import java.util.Scanner
import java.util.Scanner;
// import java.text.DecimalFormat
import java.text.DecimalFormat;

// Main Class
class Main {

    // Main Method
    public static void main(String[] args) {
        // create principal variable with prompt, and lower and upper bounds
        int principal = (int) readNumber("Please enter amount of principal: ", 1_000, 1_000_000);
        // create annual interest variable with prompt, and lower and upper bounds
        float annualInterest = (float) readNumber("Please enter the amount of annual interest rate: ", 1, 30);
        // create years variable with prompt, and lower and upper bounds
        byte years = (byte) readNumber("Please enter the amount of years: ", 1, 30);
        // calculate mortgage
        double mortgage = calculateMortgage(principal, annualInterest, years);
        // print out mortgage to screen in proper decimal place format
        System.out.println("\nYour Mortgage Is Approximately: " + NumberFormat.getCurrencyInstance().format(mortgage));

    }

    // public static calculateMortgage method returns double
    public static double calculateMortgage(int principal, float annualInterest, byte years) {
        // define constants 12 and 100
        final float percentage = 100;
        final byte numMonths = 12;
        // find the number of payments
        short numOfPayments = (short) (years * numMonths);
        // find the monthly interest payments
        float monthlyInterest = (annualInterest / percentage) / numMonths;
        /*
         * with the new values we found with the previous statements, find the mortgage
         * using the given formula
         */
        double mortgage = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numOfPayments));
        return mortgage;
    }

    // public static readNumber method returns double
    public static double readNumber(String prompt, double MIN, double MAX) {
        Scanner scanny = new Scanner(System.in);
        // create decimal format instance
        DecimalFormat decFormaty = new DecimalFormat("0.#");
        double userInput;
        // keep looping as long as the input is invalid
        while (!false) {
            System.out.println(prompt);
            userInput = scanny.nextDouble();
            // if value of input is valid then break from the loop
            if (userInput >= MIN || userInput <= MAX) {
                break;
            }
            System.out.printf("Enter a value between %s and %s", decFormaty.format(MIN), decFormaty.format(MAX));
        }
        return userInput;
    }
}
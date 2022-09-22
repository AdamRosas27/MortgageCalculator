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
        // create scanner instance
        Scanner scanny = new Scanner(System.in);
        // create decimal format instance
        // instantiate varibal to keep track of input
        // keep looping as long as the input is invalid
        // if value of input is valid then break from the loop
        // error message if input given is invalid

    }

}
/**
 * This program takes in the prices of smartphones and then determines
 * and prints the most expensive and cheapest phones.
 *
 * @author Bill Mullen
 * @version 2-6-2020
 */

package edu.cscc;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        final int PRICES_SIZE = 10;
        int[] prices = new int[PRICES_SIZE];   // Array of smartphone prices

        getPrices(prices);      // Get all 10 prices from the user, fill array

        Arrays.sort(prices);    // Sort the list of smartphones from low to high price

        // Print the 3 most expensive phones in order of decreasing price
        int n = 3;              // Variable for the number of smartphone prices to be displayed
        System.out.println("Three Most Expensive Phones:");
        System.out.println("----------------------------");
        printExpensive(prices, n);
        System.out.println();

        // Print the 3 least expensive phones in order of increasing price
        System.out.println("Three Cheapest Phones:");
        System.out.println("----------------------");
        printCheapest(prices, n);
        System.out.println();

        input.close();
    }

    /**
     * Takes the prices array and fills it with integers provided by the user.
     * Each value is validated before it is assigned to the array.
     * @param prices - the array of prices to be assigned values
     */
    public static void getPrices(int[] prices) {
        System.out.print("Enter all smartphone prices: ");
        // Loop to get all the prices for each smartphone
        for (int i = 0; i < prices.length; i++) {
            isValidInteger(input);
            prices[i] = input.nextInt();
        }
    }

    /**
     * Validates the input as a valid integer. If the input is not an integer, there is an
     * error message output and asks for another value.
     * @param in Scanner instance passed to the method
     */
    public static void isValidInteger(Scanner in) {
        boolean isValid;
        do {
            // Validate that the next input is an int
            if (input.hasNextInt()) {
                isValid = true;
            } else {
                isValid = false;
                String word = input.next();     // clears the invalid input
                System.err.print(word + " is not an integer. Please replace this value: ");
            }
        } while (!isValid);
    }

    /**
     * Prints a number of the most expensive smartphones from a sorted array based on given parameters.
     * @param prices SORTED array passed to the method
     * @param n the number of prices to be displayed
     */
    public static void printExpensive(int[] prices, int n) {
        for (int i = prices.length - 1; i >= prices.length - n; i--) {
            System.out.println(prices[i]);
        }
    }

    /**
     * Prints a number of the cheapest smartphones from a sorted array based on given parameters.
     * @param prices SORTED array passed to the method
     * @param n the number of prices to be displayed
     */
    public static void printCheapest(int[] prices, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(prices[i]);
        }
    }
}

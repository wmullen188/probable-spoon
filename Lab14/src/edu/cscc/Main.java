package edu.cscc;

import java.io.IOException;
import java.util.Arrays;

/**
 * This is a program that compares the time it takes to do a bubble sort versus the time it takes
 * for the Java built-in sort method to sort 2 sets of data, one big and one small
 * @author Bill Mullen
 * @version 4-22-20
 */
public class Main {

    private static final String SERFNAME = "bigsurnames.ser";

    public static void main(String[] args) {

        String[] surnames;

        // Use a try-catch block in case the file cannot be found
        try {
            // Read in the data from file
            surnames = CensusData.deserialize(SERFNAME);
            // Print out the top 5 names on the list to show that it is unsorted
            System.out.println("Unsorted array of " + surnames.length + " names");
            top5names(surnames);
            System.out.println("=========================");

            // Use a bubble sort to sort the data
            System.out.println("Sort array with Bubble Sort");
            long start = System.currentTimeMillis(); // Start time in milliseconds
            BubbleSort.sort(surnames);
            long stop = System.currentTimeMillis(); // End time in milliseconds
            // Print out the elapsed time using the start and stop times
            System.out.println("Elapsed time: " + (stop - start) + " milliseconds");
            // Print out the top 5 names again to prove that it has been sorted properly
            top5names(surnames);
            System.out.println("=========================");

            // Read in the unsorted array again to start the process over
            surnames = CensusData.deserialize(SERFNAME);
            // Use Java's built-in sort method to sort the data
            System.out.println("Sort array with Java built-in sort");
            start = System.currentTimeMillis(); // Start time in milliseconds
            Arrays.sort(surnames);
            stop = System.currentTimeMillis(); // End time in milliseconds
            // Print out the elapsed time using the start and stop times
            System.out.println("Elapsed time: " + (stop - start) + " milliseconds");
            // Print out the top 5 names to prove that it has been sorted properly
            top5names(surnames);
        } catch (IOException | ClassNotFoundException ex) {
            // Catch exception, if thrown, and print out to the console what happened
            System.out.println("Cannot read file " + SERFNAME);
        }
    }

    /**
     * Prints out the top 5 names in an array of Strings to console
     * @param names the array of Strings to be printed out
     */
    public static void top5names(String[] names) {
        System.out.println("Top 5 names in list");
        for (int i = 0; i < 5; ++i) {
            System.out.println(names[i]);
        }
    }
}

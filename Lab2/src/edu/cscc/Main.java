package edu.cscc;

import java.util.Scanner;

/*
@author Bill Mullen
1-17-2020

This program accepts wind speed from the user and outputs the classification of hurricane
 */
public class Main {

    public static Scanner input = new Scanner(System.in);

    /*
    Determines whether input from the user is valid and not garbage. Returns true if valid,
    false otherwise.

    @param userInput - String input read in from the user
    @return boolean value that is true if valid input, false otherwise
     */
    public static boolean validLong(String userInput) {
        boolean isValid = true;
        // Check for empty string
        if (userInput.length() == 0) {
            isValid = false;
        } else {
            // Check to make sure every char is a digit
            for (int i = 0; i < userInput.length(); i++) {
                char ch = userInput.charAt(i);
                if (!Character.isDigit(ch)) {
                    isValid = false;
                }
            }
        }
        return isValid;
    }

    public static void main(String[] args) {
        long speed;
        String classification;
        // Get the user's input value
        System.out.print("Enter the wind speed (mph): ");
        String speedStr = input.nextLine();
        // Validate the input
        // Output error message if invalid and then ask again
        while (!validLong(speedStr)) {
            System.out.println("Error! Invalid input.");
            System.out.print("Enter the wind speed (mph): ");
            speedStr = input.nextLine();
        }
        // Parse the validated input
        speed = Long.parseLong(speedStr);
        // Check to make sure it is a positive number
        if (speed < 0) {
            classification = "Invalid input";
        } else {
            // Determine the classification
            if (speed > 156) {
                classification = "Category Five Hurricane";
            } else if (speed > 129) {
                classification = "Category Four Hurricane";
            } else if (speed > 110) {
                classification = "Category Three Hurricane";
            } else if (speed > 95) {
                classification = "Category Two Hurricane";
            } else if (speed > 73) {
                classification = "Category One Hurricane";
            } else if (speed > 38) {
                classification = "Tropical Storm";
            } else {
                classification = "Not in scale";
            }
        }
        // Output the classification
        System.out.println("Classification: " + classification);
    }
}


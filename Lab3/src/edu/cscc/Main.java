package edu.cscc;

import java.util.Scanner;
import java.lang.Math;

/**
 * @author Bill Mullen
 * 1-23-20
 * This program takes input from the user and caluculates BMI and then classifies the
 * calculated BMI and reports both to the user.
 */
public class Main {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        double lbs, inches, meters, kgs, bmi;
        String lbsStr, inchesStr, classification;

        System.out.println("Calculate BMI");
        // Ask user for weight in lbs
        String msg = "weight";
        String units = "lbs";

        // Validate the input as a positive value, error message and ask again if invalid
        lbsStr = validation(input, msg, units);

        lbs = Double.parseDouble(lbsStr);   // Parse the input
        kgs = convertToKilograms(lbs);      // Convert from lbs to kgs

        // Ask user for height in inches
        msg = "height";
        units = "inches";

        // Validate the input as a positive value, error message and ask again if invalid
        inchesStr = validation(input, msg, units);

        inches = Double.parseDouble(inchesStr);     // Parse the input
        meters = convertToMeters(inches);           // Convert from inches to meters
        bmi = calcBMI(kgs, meters);                 // Calculate BMI using the inputs from user
        classification = bmiClassification(bmi);    // Classify the calculated BMI
        System.out.println("Your BMI is " + bmi);
        System.out.println("Your BMI classification is " + classification + ".");
        input.close();
    }

    public static String validation(Scanner input, String msg, String units) {
        System.out.print("Enter " + msg + " (" + units + "): ");
        String inputStr = input.nextLine();
        while (!isValidDouble(inputStr)) {
            System.out.println("Error! Invalid input.");
            System.out.print("Enter " + msg + " (" + units + "): ");
            inputStr = input.nextLine();
        }
        return inputStr;
    }

    /**
     * Determines whether input from the user is valid and not garbage. Returns true if valid,
     * false otherwise.
     *
     * @param userInput - String input read in from the user
     * @return boolean value that is true if valid input, false otherwise
     */
    public static boolean isValidDouble(String userInput) {
        boolean isValid = true;
        // Check for empty string (null)
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

    /**
     * Converts from lbs to kilograms
     *
     * @param lbs - pounds to be converted
     * @return double, converted to kilograms
     */
    public static double convertToKilograms(double lbs) {
        double kgs;
        final double LBS_PER_KG = 2.2046;

        kgs = lbs / LBS_PER_KG;
        return kgs;
    }

    /**
     * Converts from inches to meters
     *
     * @param inches - height in inches
     * @return double, converted to meters
     */
    public static double convertToMeters(double inches) {
        double meters;
        final double INCHES_PER_METER = 39.37;

        meters = inches / INCHES_PER_METER;
        return meters;
    }

    /**
     * Takes the parameters weight, in kilograms, and height, in meters, and calculates
     * the BMI
     *
     * @param kgs    - weight in kilograms
     * @param meters - height in meters
     * @return double, BMI calculated
     */
    public static double calcBMI(double kgs, double meters) {
        double bmi;
        try {
            bmi = kgs / Math.pow(meters, 2.0);
            if (bmi == Double.POSITIVE_INFINITY || bmi == Double.NEGATIVE_INFINITY || Double.isNaN(bmi)) {
                throw new ArithmeticException();
            }
        } catch (ArithmeticException ae) {
            System.err.println("Error! Arithmetic exception.");
            return 0.0;
        }
        return bmi;
    }

    /**
     * Classifies the BMI parameter as a String
     *
     * @param bmi - BMI to be classified
     * @return String of associated classification
     */
    public static String bmiClassification(double bmi) {
        String classification;
        if (bmi >= 30.0) {
            classification = "Obese";
        } else if (bmi >= 25.0) {
            classification = "Overweight";
        } else if (bmi >= 18.5) {
            classification = "Normal";
        } else if (bmi > 0.0) {
            classification = "Underweight";
        } else {
            classification = "Error";
        }
        return classification;
    }
}

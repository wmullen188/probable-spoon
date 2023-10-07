package edu.cscc;

import java.util.Scanner;

/**
 *
 */
public class BMI {

    private static Scanner input = new Scanner(System.in);
    private static final String INPUT_ERROR = "Input is not valid, try again.";

    /**
     * Returns the double of the weight input, in lbs, that was validated as a positive number.
     * @return a double of the weight, in lbs
     */
    public static double inputWeight() {
        String inputStr = "";
        do {
            // If input String is not empty, error message is triggered
            if (inputStr.length() != 0) {
                System.out.println(INPUT_ERROR);
            }
            // Prompt user to input weight in lbs
            System.out.print("Enter weight (lbs): ");
            // Take in input as a String
            inputStr = input.nextLine();
        } while (!isValidDouble(inputStr));
        // Parse the input String as a double
        return Double.parseDouble(inputStr);
    }

    /**
     * Returns the double of the height input, in inches, that was validated as a positive number.
     * @return a double of the height, in inches
     */
    public static double inputHeight() {
        String inputStr = "";
        do {
            // If input String is not empty, error message is triggered
            if (inputStr.length() != 0) {
                System.out.println(INPUT_ERROR);
            }
            // Prompt user to input weight in lbs
            System.out.print("Enter height (inches): ");
            // Take in input as a String
            inputStr = input.nextLine();
        } while (!isValidDouble(inputStr));
        // Parse the input String as a double
        return Double.parseDouble(inputStr);
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
                    return false;

                }
            }
            // Only all number inputs will get to this point of the validation
            // Check to make sure input is not negative or zero
            if (Double.parseDouble(userInput) <= 0) {
                isValid = false;
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

package edu.cscc;

import java.util.Scanner;

/**
 * This is a BMI calculator, it validates all inputs as positive numbers.
 *
 * @author Bill Mullen
 * @version 2-18-2020
 */
public class Main {

    public static void main(String[] args) {
        double lbs, inches, meters, kgs, bmi;
        String classification;

        System.out.println("Calculate BMI");
        // Ask user for weight in lbs
        // Validate the input as a positive value, error message and ask again if invalid
        lbs = BMI.inputWeight();

        // Ask user for height in inches
        // Validate the input as a positive value, error message and ask again if invalid
        inches = BMI.inputHeight();

        kgs = BMI.convertToKilograms(lbs);              // Convert from lbs to kgs
        meters = BMI.convertToMeters(inches);           // Convert from inches to meters
        bmi = BMI.calcBMI(kgs, meters);                 // Calculate BMI using the inputs from user

        classification = BMI.bmiClassification(bmi);    // Classify the calculated BMI

        System.out.println("Your BMI is " + bmi);
        System.out.println("Your BMI classification is " + classification + ".");

    }
}


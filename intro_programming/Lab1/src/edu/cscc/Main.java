package edu.cscc;

import java.lang.Math;
import java.util.Scanner;

/*
@author Bill Mullen
1-16-2020

This is a simple program used to find the volume of a cylinder using user input
 */
public class Main {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        double radius, height, volume;
        // Get the radius from the user
        System.out.print("Enter the radius of the cylinder: ");
        radius = Double.parseDouble(input.nextLine());
        // Get the height from the user
        System.out.print("Enter the height of the cylinder: ");
        height = Double.parseDouble(input.nextLine());

        // Find the volume of the cylinder
        volume = Math.PI * Math.pow(radius, 2.0) * height;

        // Output the volume of the cylinder
        System.out.println("The volume of the cylinder is: " + volume);

        input.close();
    }
}


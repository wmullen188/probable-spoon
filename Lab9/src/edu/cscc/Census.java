package edu.cscc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Census {
    public static Surname[] loadCensusData(String fname) {
        int line = 0; // Keep track of line number in input file
        Surname[] namelist = new Surname[100];
        File file = new File(fname);

        try (Scanner reader = new Scanner(file);) {

            // Scan in the first 100 surnames
            while (line < 100) {
                // Use Scanner to read in the first line
                String str = reader.nextLine();
                // Use split to make an array of Strings
                String[] data = str.split(",");
                // Assign each corresponding data to a variable, parse if necessary
                String name = data[0];
                int rank = Integer.parseInt(data[1]);
                int count = Integer.parseInt(data[2]);
                double proportion = Double.parseDouble(data[3]);
                // Create Surname object with parsed data
                Surname surname = new Surname(name, rank, count, proportion);
                namelist[line] = surname;       // Add to namelist array of Surnames
                line++;                         // Update line number
            }
        } catch (FileNotFoundException ex) {
            // If an error occurs opening the file, a description is printed to the console
            System.err.println("I/O Exception occurred: " + ex);
        }
        return namelist;
    }
}
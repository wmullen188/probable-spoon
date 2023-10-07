package edu.cscc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Census {
    public static Map<String, Surname> loadCensusData(String fname) {
        HashMap<String, Surname> surnameMap = new HashMap<>();
        File file = new File(fname);

        try (Scanner reader = new Scanner(file)) {

            // Scan in the surnames
            while (reader.hasNext()) {
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
                surnameMap.put(name, surname);       // Put in Surnames HashMap
            }
        } catch (FileNotFoundException ex) {
            // If an error occurs opening the file, a description is printed to the console
            System.err.println("I/O Exception occurred: " + ex.getMessage());
        } catch (NumberFormatException ex) {
            System.err.println("Number Format Exception occurred: " + ex.getMessage());
        }
        return surnameMap;
    }
}
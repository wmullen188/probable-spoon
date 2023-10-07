package edu.cscc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Utility to process a document to into sorted set of unique words
 * @author student name
 */
public class UniqueWords {
    /**
     * Read file one line at a time
     * Break input String into words
     * Store unique words sorted into alphabetic order
     * @param myfile input file
     * @return sorted set of unique words
     */
    public static Set<String> processDocument(File myfile) {
        TreeSet<String> uniques = new TreeSet<>();

        // Use a try-with-resources to open and read the file one line at a time
        try (Scanner lineReader = new Scanner(myfile)) {
            // Go through the file until reaching the end
            while(lineReader.hasNextLine()) {
                // Read in the line
                String str = lineReader.nextLine();
                if (!str.isEmpty()) {
                    // Tokenize the line if it's not empty
                    String[] tokens = tokenize(str);
                    // Add the words to uniques tree set
                    uniques.addAll(Arrays.asList(tokens));
                }
            }
        } catch(FileNotFoundException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
        return uniques;
    }

    /**
     * Remove all punctuation and numbers from String
     * Tokenize - break into individual words
     * Convert all words to lower case
     * @param str initial non-null String
     * @return array of words from initial String
     */
    public static String[] tokenize(String str) {
        str = str.replaceAll("[^a-zA-Z \n]"," ");
        String[] tok = str.split(" ");
        for (int i=0; i<tok.length; ++i) {
            tok[i] = tok[i].toLowerCase();
        }
        return tok;
    }
}

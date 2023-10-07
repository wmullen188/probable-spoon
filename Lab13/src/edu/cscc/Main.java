package edu.cscc;

import java.util.Map;
import java.util.Scanner;

public class Main {
    private final static String CENSUSDATAFNAME = "Surnames_2010Census.csv";
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        Map<String, Surname> surnameMap = Census.loadCensusData(CENSUSDATAFNAME);

        if (surnameMap != null) {
            String inputStr;
            do {
                System.out.print("Enter a surname (or quit to end): ");
                inputStr = input.nextLine().toUpperCase();
                if (surnameMap.containsKey(inputStr)) {
                    String name = surnameMap.get(inputStr).getName();
                    int rank = surnameMap.get(inputStr).getRank();
                    int count = surnameMap.get(inputStr).getCount();
                    double proportion = surnameMap.get(inputStr).getProportion();
                    String format = "Surname: %s rank: %d count: %d proportion: %.2f \n";
                    System.out.printf(format, name, rank, count, proportion);
                } else if (!surnameMap.containsKey(inputStr.toUpperCase()) && !("quit".equalsIgnoreCase(inputStr))) {
                    System.out.println("Surname: " + inputStr.toLowerCase() + " not found");
                }
            } while (!"quit".equalsIgnoreCase(inputStr));
        }
    }
}
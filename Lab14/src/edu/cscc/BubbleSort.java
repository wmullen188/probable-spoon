package edu.cscc;

public class BubbleSort {
    /**
     * A sorting algorithm that uses the bubble sort method of sorting
     * @param list the String array that is to be sorted
     */
    public static void sort(String[] list) {
        boolean changed = true;
        // Begin bubble sort
        do {
            changed = false;
            // Loop through the list of Strings
            for (int j = 0; j <= list.length - 2; j++)
                // If the comparison comes back positive then they must be switched
                if (list[j].compareToIgnoreCase(list[j + 1]) > 0) {
                    //swap list[j] with list[j+1]
                    String temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    changed = true; // If switch occurred, then changed is true
                }
        } while (changed);
    }
}

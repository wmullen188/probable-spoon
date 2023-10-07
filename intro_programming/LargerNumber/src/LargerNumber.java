/**
 * This program takes an input seed from the user and outputs a random
 * number which is compared to a guessed number by the user
 * @author Bill Mullen
 * @version 20190909 
 */

import java.util.Scanner;
import java.util.Random;

public class LargerNumber {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter a random seed: ");
        int seed = keyboard.nextInt();
        Random rnd = new Random(seed);
        int computerNum = rnd.nextInt(10) + 1;  // computerNum will be between 1 and 10

        // Take in a guess between 1-10
        System.out.println("I'm thinking of a number between 1 and 10");
        System.out.print("What is your guess?: ");
        int guessNum = keyboard.nextInt();
        
        // Compare the guess to the randomly generated number
        // Output whether the number was greater or not
        System.out.println("My number was: " + computerNum);
        if (guessNum > computerNum) {
        	System.out.println("Your number was larger!");
        }
        else {
        	System.out.println("Your number was not larger!");
        }

        keyboard.close();

	}

}

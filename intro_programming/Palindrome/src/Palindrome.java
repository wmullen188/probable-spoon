/**
 * A program that reads in an input and determines if it is a palindrome
 * @author Bill Mullen
 * @version 20190923
 */

import java.util.Scanner;
import java.util.Arrays;

public class Palindrome {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		final int NUM_ELEMENTS = 100;
		char[] forwards = new char[NUM_ELEMENTS];
		char[] backwards = new char[NUM_ELEMENTS];
		int forwardsSize = 0;
		int backwardsSize = 0;
		String inputStr;		// input string from user
		int i;					// index variable
		char ch;			// char variable for backwards array
		
		// while loop until empty string input
		System.out.print("Enter a string: ");		// input a string to start
		inputStr = keyboard.nextLine();  		
		while (inputStr.length() != 0) {			// check for empty string
			
			for (i = 0; i < inputStr.length(); ++i) {	// forwards array
				ch = inputStr.charAt(i);
				forwards[i] = ch;
				++forwardsSize;
			}
			
			for (i = 0; i < inputStr.length(); ++i) {	// backwards array
				ch = inputStr.charAt(i);
				backwards[inputStr.length() - 1 - i] = ch;
				++backwardsSize;
			}
			
			if (Arrays.equals(forwards, backwards)) {	// compare arrays
				System.out.println(inputStr + " is a palindrome.");
			}
			
			else {
				System.out.println(inputStr + " is NOT a palindrome.");
			}
			System.out.println("");
			System.out.print("Enter a string: ");		// input a string
			inputStr = keyboard.nextLine();
		}
		System.out.println("Empty line read - Goodbye!");
		keyboard.close();

	}

}

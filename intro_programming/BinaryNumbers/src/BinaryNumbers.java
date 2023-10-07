
/**
 * This program takes in an integer and then does either an integer
 * to binary, or vice versa, conversion and reports the converted value
 * @author Bill Mullen
 * @version 20191024
 */
import java.util.Scanner;

public class BinaryNumbers {

	/**
	 * Given a Scanner as input, prompt the user to enter an integer value. Use the
	 * function validInteger below to make sure that the value entered is actually a
	 * decimal value and not junk. Then return the value entered by the user as an
	 * integer to the calling method.
	 *
	 * @param input A scanner to take user input from
	 * @return a valid integer value read from the user
	 */
	public static int promptForInteger(Scanner input) {
		System.out.print("Enter a positive integer value: ");
		String val = input.nextLine();
		while (!validInteger(val)) {
			System.out.println("ERROR - value must contain only digits");
			System.out.print("Enter a positive integer value: ");
			val = input.nextLine();
		}
		return Integer.parseInt(val);
	}

	/**
	 * Given a Scanner as input, prompt the user to enter a binary value. Use the
	 * function validBinary below to make sure that the value entered is actually a
	 * binary value and not junk. Then return the value entered by the user as an
	 * String to the calling method.
	 *
	 * @param input A scanner to take user input from
	 * @return a String representing a binary value read from the user
	 */
	public static String promptForBinary(Scanner input) {
		System.out.print("Enter a binary value: ");
		String val = input.nextLine();
		while (!validBinary(val)) {
			System.out.println("ERROR - value must contain only 1 and 0");
			System.out.print("Enter a binary value: ");
			val = input.nextLine();
		}
		return val;
	}

	/**
	 * Given a String as input, return true if the String represents a valid
	 * non-negative integer value (i.e. contains only digits). Returns false if the
	 * String does not represent a non-negative integer value.
	 *
	 * Note that you must NOT use Exception Handling to implement this. If you
	 * search on the net for solutions, that is what you will find but you should
	 * not use it here - you can solve this using only what we have discussed in
	 * class.
	 *
	 * Note too that your code does not need to worry about the number represented
	 * being too large or too small (more than Integer.MAX_VALUE or less than
	 * Integer.MIN_VALUE. Just worry about the constraints given above for now (but
	 * for a challenge, try to figure out how to do it using only what you have
	 * learned so far in class - it is not a simple problem to solve.)
	 *
	 * @param value A String value that may contain an integer input
	 * @return true if the String value contains an integer input, false otherwise
	 */
	public static boolean validInteger(String value) {
		// Determine if the string value is a valid integer
		boolean isValid = true;
		if (value.length() == 0) {
			isValid = false;
		}
		for (int i = 0; i < value.length(); ++i) {
			char c = value.charAt(i);
			if (!Character.isDigit(c)) {
				isValid = false;
			} else if (c != '0' && c != '1') {
				isValid = false;
			}
		}
		return isValid;
	}

	/**
	 * Given a String as input, return true if the String represents a valid binary
	 * value (i.e. contains only the digits 1 and 0). Returns false if the String
	 * does not represent a binary value.
	 *
	 * @param value A String value that may contain a binary value
	 * @return true if the String value contains a binary value, false otherwise
	 */
	public static boolean validBinary(String value) {
		// Determine if valid binary string input
		boolean isValid = true;
		if (value.length() == 0) {
			isValid = false;
		}
		for (int i = 0; i < value.length(); ++i) {
			char c = value.charAt(i);
			int digit = Character.getNumericValue(c);
			if (digit != 0 && digit != 1) {
				isValid = false;
			}
		}
		return isValid;
	}

	/**
	 * Given a binary value, return an int value that is the base 10 representation
	 * of that value. Your implementation must use the algorithm described in the
	 * Project write-up. Other algorithms will receive no credit. Note that this
	 * method assume the String value will be a String containing only 1s and 0s and
	 * its behavior is undefined for other String values.
	 *
	 * @param value A String containing a binary value to convert to integer with
	 *              only character '0' and '1' in it
	 * @return The base 10 integer value of that binary in the String
	 */
	public static int binaryToInt(String value) {
		int decimal = 0; // initialize decimal value to 0
		int pow = 1; // initialize power value to 1
		// loop through each character of the string from right to left
		for (int i = value.length() - 1; i >= 0; --i) {
			char c = value.charAt(i);
			int digit = Character.getNumericValue(c);
			int result = digit * pow;
			decimal = decimal + result;
			pow = pow * 2;
		}
		return decimal;
	}

	/**
	 * Given an integer value, return a String that is the binary representation of
	 * that value. Your implementation must use the algorithm described in the
	 * Project write-up. Other algorithms will receive no credit. Note that this
	 * method assumes that the integer parameter value will have a non-negative
	 * value, and the behavior of this method is undefined for negative values.
	 *
	 * @param value A non-negative integer value to convert to binary
	 * @return A String containing the binary representation of value
	 */
	public static String intToBinary(int value) {
		// if the decimal value is 0 the binary value is 0
		String binary = "";
		if (value == 0) {
			binary = "0";
		}
		// Otherwise use this algorithm
		else {
			while (value != 0) {
				int result = value % 2;
				binary = result + binary;
				value = value / 2;
			}
		}
		return binary;
	}

	/**
	 * Procedure to display a simple menu to the screen.
	 */
	public static void displayMenu() {
		System.out.println("Please make a choice: ");
		System.out.println("1 - Integer to Binary Conversion");
		System.out.println("2 - Binary to Integer Conversion");
		System.out.println("3 - Quit");
	}

	public static void main(String[] args) {
		// Set up the scanner
		Scanner keyboard = new Scanner(System.in);
		// Display the menu and get the user choice
		displayMenu();
		int choice = promptForInteger(keyboard);

		// Loop until the user chooses to quit
		while (choice != 3) {
			if (choice == 1) {
				// User has chosen integer to binary
				int value = promptForInteger(keyboard);
				String binary = intToBinary(value);
				System.out.print("The integer value " + value);
				System.out.println(" is the binary value " + binary);
			} else if (choice == 2) {
				// User has chosen binary to integer
				String binary = promptForBinary(keyboard);
				int value = binaryToInt(binary);
				System.out.print("The binary value " + binary);
				System.out.println(" is the integer value " + value);
			} else {
				// User has chosen an invalid choice
				System.out.println("ERROR - Valid choices are 1, 2 or 3.");
			}
			System.out.println();
			// Display the menu again and get a new choice
			displayMenu();
			choice = promptForInteger(keyboard);
		}
		System.out.println();
		System.out.println("Goodbye!");
		keyboard.close();
	}

}
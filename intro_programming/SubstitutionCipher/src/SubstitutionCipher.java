
/**
 * This program takes an input file and encodes or decodes the file
 * into a new file based on input from the user
 * @author Bill Mullen
 * @version 20191114
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SubstitutionCipher {

	/**
	 * Private constants used to shift characters for the substitution cipher.
	 */
	private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";

	/**
	 * Constructs a new String where each letter in the String input is shifted by
	 * the amount shift to the right, preserving whether the original character was
	 * uppercase or lowercase. For example, the String "ABC" with shift 3 would
	 * cause this method to return "DEF". A negative value should shift to the left.
	 * For example, the String "ABC" with shift -3 would cause this method to return
	 * "XYZ". Punctuation, numbers, whitespace and other non-letter characters
	 * should be left unchanged. NOTE: For full credit you are REQUIRED to use a
	 * StringBuilder to build the String in this method rather than using String
	 * concatenation.
	 *
	 * @param input String to be encrypted
	 * @param shift Amount to shift each character of input to the right
	 * @return the encrypted String as outlined above
	 */
	public static String shift(String input, int shift) {
		// Declare StringBuilder
		StringBuilder sb = new StringBuilder();
		// Loop through the input string
		for (int i = 0; i < input.length(); ++i) {
			char currentChar = input.charAt(i);
			// Test for upper case and lower case characters separately
			if (Character.isLetter(currentChar) && Character.isUpperCase(currentChar)) {
				int idxCurrChar = UPPERCASE.indexOf(currentChar);
				int idxCodedChar = (idxCurrChar + shift + 26) % 26;
				currentChar = UPPERCASE.charAt(idxCodedChar);
			} else if (Character.isLetter(currentChar) && Character.isLowerCase(currentChar)) {
				int idxCurrChar = LOWERCASE.indexOf(currentChar);
				int idxCodedChar = (idxCurrChar + shift + 26) % 26;
				currentChar = LOWERCASE.charAt(idxCodedChar);
			}
			// Append the current character to the end of the stringbuilder
			sb.append(currentChar);
		}
		return sb.toString();
	}

	/**
	 * Displays the message "promptMsg" to the user and reads the next full line
	 * that the user enters. If the user enters an empty string, reports the error
	 * message "ERROR! Empty Input Not Allowed!" and then loops, repeatedly
	 * prompting them with "promptMsg" to enter a new string until the user enters a
	 * non-empty String
	 *
	 * @param in        Scanner to read user input from
	 * @param promptMsg Message to display to user to prompt them for input
	 * @return the String entered by the user
	 */
	public static String promptForString(Scanner in, String promptMsg) {
		System.out.print(promptMsg);
		String input = in.nextLine();
		while (input.length() == 0) {
			System.out.println("ERROR! Empty Input Not Allowed!");
			System.out.print(promptMsg);
			input = in.nextLine();
		}
		return input;
	}

	/**
	 * Opens the file inFile for reading and the file outFile for writing, reading
	 * one line at a time from inFile, shifting it the number of characters given by
	 * "shift" and writing that line to outFile. If an exception occurs, must report
	 * the error message: "ERROR! File inFile not found or cannot write to outFile"
	 * where "inFile" and "outFile" are the filenames given as parameters.
	 *
	 * @param inFile  the file to be transformed
	 * @param outFile the file to write the transformed output to
	 * @param shift   the amount to shift the characters from inFile by
	 * @return false if an exception occurs and the error message is written,
	 *         otherwise true
	 */
	public static boolean transformFile(String inFile, String outFile, int shift) {
		boolean fileTransformed = false;
		try {
			File textFile = new File(inFile);
			Scanner textScanner = new Scanner(textFile);

			File outTextFile = new File(outFile);
			PrintWriter textWriter = new PrintWriter(outTextFile);

			// Loop until there is nothing next
			while (textScanner.hasNext()) {
				String str = textScanner.nextLine();
				str = shift(str, shift);
				textWriter.println(str);
			}
			fileTransformed = true;
			textScanner.close();
			textWriter.close();
		} catch (FileNotFoundException ex) {
			System.out.println("ERROR! File " + inFile + " not found or cannot write to " + outFile + ".");
		}
		return fileTransformed;
	}

	/**
	 * Prompts the user to enter a single character choice. The only allowable
	 * values are 'E', 'D' or 'Q'. All other values are invalid, including all
	 * values longer than one character in length, however the user is allowed to
	 * enter values in either lower or upper case. If the user enters an invalid
	 * value, the method displays the error message "ERROR! Enter a valid value!"
	 * and then prompts the user repeatedly until a valid value is entered. Returns
	 * a single uppercase character representing the user's choice.
	 *
	 * @param in Scanner to read user choices from
	 * @return the user's choice as an uppercase character
	 */
	public static char getChoice(Scanner in) {
		System.out.print("Enter your choice: ");
		String input = in.nextLine().toUpperCase();
		while (!validCharacter(input)) {
			System.out.println("ERROR! Enter a valid value!");
			System.out.print("Enter your choice: ");
			input = in.nextLine().toUpperCase();
		}
		return input.charAt(0);
	}

	/**
	 * Determines whether an input from the user is valid and not garbage. Returns
	 * true if valid, false otherwise.
	 * 
	 * @param input - String input read in from the user
	 * @return boolean value true if valid input, false otherwise
	 */
	public static boolean validCharacter(String input) {
		boolean isValid = true;
		if (input.length() == 0) {
			isValid = false;
		} else if (input.length() != 1) {
			isValid = false;
		} else {
			char ch = input.toUpperCase().charAt(0);
			if (!(ch == 'E' || ch == 'D' || ch == 'Q')) {
				isValid = false;
			}
		}
		return isValid;
	}

	/**
	 * Displays the menu of choices to the user.
	 */
	public static void displayMenu() {
		System.out.println("[E]ncode a file");
		System.out.println("[D]ecode a file");
		System.out.println("[Q]uit");
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		displayMenu();
		char choice = getChoice(in);
		while (choice != 'Q') {
			if (choice == 'E') {
				// Get input filename from user
				String msg = "Enter an input file: ";
				String inFile = promptForString(in, msg);
				// Get output filename from user
				msg = "Enter an output file: ";
				String outFile = promptForString(in, msg);
				// Get shift amount from user
				System.out.print("Enter a shift amount: ");
				int shift = Integer.parseInt(in.nextLine());
				// Transform the file with the shift desired
				if (transformFile(inFile, outFile, shift)) {
					System.out.println("Finished writing to file.");
				} else {
					System.out.println("Encoding failed.");
				}
				System.out.println();
				// Display menu and get choice from user
				displayMenu();
				choice = getChoice(in);
			} else if (choice == 'D') {
				String msg = "Enter an input file: ";
				String inFile = promptForString(in, msg);
				msg = "Enter an output file: ";
				String outFile = promptForString(in, msg);
				System.out.print("Enter a shift amount: ");
				int shift = -Integer.parseInt(in.nextLine());
				if (transformFile(inFile, outFile, shift)) {
					System.out.println("Finished writing to file.");
				} else {
					System.out.println("Decoding failed.");
				}
				System.out.println();
				displayMenu();
				choice = getChoice(in);
			}
		}
		System.out.println();
		System.out.println("Goodbye!");
		in.close();
	}
}

/**
 * This is a simple program to encode an input message
 *
 * @author Bill Mullen
 * @version 20191104
 */
import java.util.Scanner;

public class EncodingLab {

	public static final String CAPITALS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	/**
	 * Method that returns a string that is rot13 encoded from the input string.
	 *
	 * @param input The string to encode
	 * @return The input string with the rot13 algorithm applied to it
	 */
	public static String rot13(String input) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length(); ++i) {
			char ch = input.charAt(i);
			if (Character.isLetter(ch) && Character.isUpperCase(ch)) {
				int capitalsIndex = CAPITALS.indexOf(ch);
				int rot13Index = (capitalsIndex + 13) % 26;
				ch = CAPITALS.charAt(rot13Index);
			}
			sb.append(ch);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter a string to encode: ");
		String input = keyboard.nextLine();
		String encoded = rot13(input);
		System.out.println("Your string encoded is  : " + encoded);
		keyboard.close();
	}

}
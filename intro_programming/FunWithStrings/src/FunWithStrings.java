/**
 * A simple program to have fun with strings
 * depending on variable inputs
 * 
 * @author Bill Mullen
 * @version 20190912
 */
import java.util.Scanner;

public class FunWithStrings {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String longStr;
		String subStr;
		String beforeStr;
		String afterStr;
		String indexIn;
		int lengthStr;
		int index;
		char charAt;
		
		// Takes a long string input
		System.out.print("Enter a long string: ");
		longStr = input.nextLine();
		
		// Takes a substring input
		System.out.print("Enter a substring: ");
		subStr = input.nextLine();
		
		// Length of string and substring
		lengthStr = longStr.length();
		System.out.println("Length of your string: " + lengthStr);
		lengthStr = subStr.length();
		System.out.println("Length of your substring: " + lengthStr);
		
		// Position of the substring
		System.out.println("Starting position of your substring: " + longStr.indexOf(subStr));
		
		// String before and after substring
		index = longStr.indexOf(subStr);
		beforeStr = longStr.substring(0, index);
		System.out.println("String before your substring: " + beforeStr);
		afterStr = longStr.substring(index + subStr.length(), longStr.length());
		System.out.println("String after your substring: " + afterStr);
		
		// Takes an integer input for index in a range (0 - (length-1))
		index = longStr.length() - 1;
		System.out.print("Enter a position between 0 and " + index + ": ");
		indexIn = input.nextLine();
		index = Integer.parseInt(indexIn);
		charAt = longStr.charAt(index);     // Character at index
		System.out.println("The character at position " + index + " is " + charAt);
		
		// Takes in a replacement string for the substring
		System.out.print("Enter a replacement string: ");
		String replaceStr = input.nextLine();
		longStr = longStr.replace(subStr, replaceStr);
		// Outputs the new string
		System.out.println("Your new string is: " + longStr);
		
		// Goodbye, close scanner
		input.close();
		System.out.println("Goodbye!");

	}

}

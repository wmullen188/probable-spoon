import java.util.Scanner;

/**
 * This program performs a Hailstone Series until 1 is found
 * @author Bill Mullen
 * @version 20190916
 *
 */

public class HailstoneSeries {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		// Prompt user to enter starting value
		System.out.print("Enter a starting value: ");
		String startingValStr = keyboard.nextLine();
		int startingVal = Integer.parseInt(startingValStr);
		
		// Hailstone Series begins
		int x = startingVal;
		while (x != 1) {
			if (x % 2 == 0) {
				System.out.print(x + ", "); // Print starting value and comma
				x = x / 2; // definition of Hailstone Series
			}
			else if (x % 2 == 1) {
				System.out.print(x + ", "); // Print starting value and comma
				x = (3*x) + 1;  // definition of Hailstone Series
			}
		}
		System.out.print(x + " ");
		
        keyboard.close();

	}

}

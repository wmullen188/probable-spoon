/**
 * A program that plays a game to guess a number
 * @author Bill Mullen
 * @version 20190926
 * 
 */

import java.util.Random;
import java.util.Scanner;

public class GuessANumber {
	
	/**
	 * takes in an input string and parses it into an integer
	 * @param a string, usually an input from the user
	 * @return integer number
	 */
	public static int getUserNum(String numStr) {		
		int num;
		
		num = Integer.parseInt(numStr);
		return num;
		
	}
	
	/**
	 *  conditional responses based on number of guesses
	 *  @param integer counter (for number of guesses)
	 *  
	 */
	public static void conditionalMessage(int counter) {
			if (counter == 1) {			// one iteration for correct guess
				System.out.println("That was impossible!");
			}
				
			else if (counter < 4) {  	// 2-3 guesses
				System.out.println("You're pretty lucky!");
			}
			
			else if (counter < 8) { 		// 4-7 guesses
				System.out.println("Not bad, not bad...");
			}
			
			else if (counter == 8) {					// 8 guesses
				System.out.println("That was not very impressive.");
			}
				
			else if (counter < 11) {		// 9-10 guesses					
				System.out.println("Are you having fun at all?");
			}
				
			else if (counter >= 11) {					// 11+ guesses
				System.out.println("Maybe you should play something else.");
			}
			return;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int seed;		// random number seed
		int x;			// random number
		int guess;		// guessed number from user
		int counter;	// counts number of guesses
		
		// Ask for a random number seed
		System.out.print("Enter a random seed: ");
		seed = getUserNum(input.nextLine());
		Random rnd = new Random(seed); // RNG declared
		
		x = rnd.nextInt(200) + 1;  // random integer 1-200
		
		// Prompt for a guess between 1-200
		System.out.print("Enter a guess between 1 and 200: ");
		guess = getUserNum(input.nextLine());
		
		counter = 1;
		while (guess != x) {
			
			++counter;       		// add to counter for guessing
			if (guess < x) {		// conditional for too low
				
				if (guess < 1) { // if out of range, print error message
					System.out.println("Your guess is out of range. "
							+ " Pick a number between 1 and 200."
							);
				}
				System.out.println("Your guess was too low - try again.");
				System.out.println("");
				System.out.print("Enter a guess between 1 and 200: ");
				guess = getUserNum(input.nextLine()); // update guess
			}
			
			else if (guess > x) {  			// conditional for too high
				
				if (guess > 200) { // if out of range, print error message
					System.out.println("Your guess is out of range. "
							+ " Pick a number between 1 and 200."
							);
				}
				System.out.println("Your guess was too high - try again.");
				System.out.println("");
				System.out.print("Enter a guess between 1 and 200: ");
				guess = getUserNum(input.nextLine());	// update guess
			}
		}
		System.out.println("Congratulations!  Your guess was correct!");
		System.out.println("");
		System.out.println("I had chosen " + x + " as the target number.");
		System.out.println("You guessed it in " + counter + " tries.");
		conditionalMessage(counter);
		
		input.close();
	}

}

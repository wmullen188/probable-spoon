/**
 * A simple program that asks a series of arithmetic problems
 * and determines the percent correctly solved
 * @author Bill Mullen
 * @version 20190919
 *
 */

import java.util.Scanner;
import java.util.Random;

public class FunWithBranching {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String seedStr;
		String name;
		String answerStr;
		int seed;
		int answer;
		
		// Ask for a random number seed
		System.out.print("Enter a random number seed: ");
		seedStr = input.nextLine();
		seed = Integer.parseInt(seedStr);
		Random rnd = new Random(seed); // RNG declared
		
		// Ask for name, introduce questions
		System.out.print("Enter your name: ");
		name = input.nextLine();
		System.out.println("Hello " + name + "!");
		System.out.println("Please answer the following questions:");
		System.out.println("");  // space before first question
		
		// generate random numbers
		int x = rnd.nextInt(20) + 1; // x will be integer 1-20
		int y = rnd.nextInt(20) + 1; // y will be integer 1-20
		
		// start asking questions, getting inputs
		System.out.print(x + " + " + y + " = ");
		answerStr = input.nextLine();
		answer = Integer.parseInt(answerStr);
		
		// Determine if correct, print outcome
		int correctCount = 0;  // initializing count
		// question 1 (+)
		if (answer == x + y) {
			System.out.println("Correct!");
			System.out.println("");
			correctCount += 1;
		}
		else {
			System.out.println("Wrong!");
			System.out.println("The correct answer is: " + (x + y));
			System.out.println("");
		}
		// question 2 (-)
		System.out.print(x + " - " + y + " = ");
		answerStr = input.nextLine();
		answer = Integer.parseInt(answerStr);
		
		if (answer == x - y) {
			System.out.println("Correct!");
			System.out.println("");
			correctCount += 1;
		}
		else {
			System.out.println("Wrong!");
			System.out.println("The correct answer is: " + (x - y));
			System.out.println("");
		}
		
		// question 3 (*)
		System.out.print(x + " * " + y + " = ");
		answerStr = input.nextLine();
		answer = Integer.parseInt(answerStr);
		
		if (answer == x * y) {
			System.out.println("Correct!");
			System.out.println("");
			correctCount += 1;
		}
		else {
			System.out.println("Wrong!");
			System.out.println("The correct answer is: " + (x * y));
			System.out.println("");
		}
		
		// question 4 (/)
		System.out.print(x + " / " + y + " = ");
		answerStr = input.nextLine();
		answer = Integer.parseInt(answerStr);
		
		if (answer == x / y) {
			System.out.println("Correct!");
			System.out.println("");
			correctCount += 1;
		}
		else {
			System.out.println("Wrong!");
			System.out.println("The correct answer is: " + (x / y));
			System.out.println("");
		}
		
		// question 5 (%)
		System.out.print(x + " % " + y + " = ");
		answerStr = input.nextLine();
		answer = Integer.parseInt(answerStr);
		
		if (answer == x % y) {
			System.out.println("Correct!");
			System.out.println("");
			correctCount += 1;
		}
		else {
			System.out.println("Wrong!");
			System.out.println("The correct answer is: " + (x % y));
			System.out.println("");
		}
		
		// Display num of correct answers
		System.out.println("You got " + correctCount + " correct answers!");
		int numerator = correctCount;
		double denominator = 5.0;
		double quotient = numerator/denominator;
		double percent = quotient * 100; 
		System.out.println("That's " + percent + "%!");
		// Display percentage
		// close input Scanner object
		input.close();
	}

}

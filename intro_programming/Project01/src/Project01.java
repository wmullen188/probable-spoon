/**
 * 
 * @author Bill Mullen
 * @version	20190905
 */
import java.util.Scanner; // need scanner for inputs

public class Project01 {

	public static void main(String[] args) {
		String number; // input variable
		int num1; // first number
		int num2; // second number
		int total; // total after the operation
		int average; // average of the numbers
		
		// Scan in inputs from user, parseInt, and assign to variable
		Scanner scnr = new Scanner(System.in);
		System.out.print("Enter the first number: ");
		number = scnr.nextLine();
		num1 = Integer.parseInt(number); 
		System.out.print("Enter the second number: ");
		number = scnr.nextLine();
		num2 = Integer.parseInt(number);
		
		// perform operations and output total
		total = num1 + num2;
		System.out.println(num1 + " + " + num2 + " = " + total);
		total = num1 - num2;
		System.out.println(num1 + " - " + num2 + " = " + total);
		total = num1 * num2;
		System.out.println(num1 + " * " + num2 + " = " + total);
		total = num1 / num2;
		System.out.println(num1 + " / " + num2 + " = " + total);
		total = num1 % num2; 
		System.out.println(num1 + " % " + num2 + " = " + total);
		
		// get average and output
		average = (num1 + num2) / 2;  // equation for average of 2 numbers
		System.out.println("The average of your two numbers is: " + average);
		
		// close scanner
		scnr.close(); 
	}

}

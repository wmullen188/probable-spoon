
 /**
  *  a program that performs the Luhn Algorithm to check the check digit of a credit card
  *  @author Bill Mullen
  *  @version 20191003
  *  
  **/


import java.util.Scanner;

public class LuhnAlgorithm {
  public static void main (String[] args) {
    Scanner keyboard = new Scanner(System.in);
    String inputStr;  // string variable for input
    char digit; // character variable for parsing digits
    int i;  // index variable
    int value; // for Luhn Algorithm values
    int firstDigit; // variable for first digit of sum
    int checkDigit;	// variable for check digit
    
    // take an input string of 16 digits
    System.out.print("Enter a credit card number (enter a blank line to quit): ");
    inputStr = keyboard.nextLine();
    while (inputStr.length() != 0) {
      
      if (inputStr.length() == 16) {     
        
    	// Luhn Algorithm to check last digit  
    	int sum = 0;
        for (i = inputStr.length() - 2; i >= 0; --i) {
          digit = inputStr.charAt(i);
          value = Character.getNumericValue(digit);
          
          if (i % 2 == 0) {
            value = value * 2;
            
            if (value >= 10) {
              value = value - 9;
            }
            sum += value;
          }
          
          else {
            // pass to the sum
            sum += value;
          }
        }
        
        firstDigit = sum % 10;
        if (firstDigit != 0) {
          
          // get check digit
          checkDigit = 10 - firstDigit;
          digit = inputStr.charAt(inputStr.length() - 1);
          value = Character.getNumericValue(digit);
          if (checkDigit == value) {
            System.out.println("Check digit should be: " + checkDigit);
            System.out.println("Check digit is: " + value);
            System.out.println("Number is valid.");
          }
          
          else {
            System.out.println("Check digit should be: " + checkDigit);
            System.out.println("Check digit is: " + value);
            System.out.println("Number is not valid.");
          }
        }
        
        else {
          
          // check against check digit
          checkDigit = 0;
          digit = inputStr.charAt(inputStr.length() - 1);
          value = Character.getNumericValue(digit);
          if (checkDigit == value) {
            System.out.println("Check digit should be: " + checkDigit);
            System.out.println("Check digit is: " + value);
            System.out.println("Number is valid.");
          }
          
          else {
            System.out.println("Check digit should be: " + checkDigit);
            System.out.println("Check digit is: " + value);
            System.out.println("Number is not valid.");
          }
        }
      }
      
      else {      // error if it is not 16 digits
        System.out.println("ERROR! Number MUST have exactly 16 digits.");
      }
      // prompt for another 16 digits
      System.out.println("");
      System.out.print("Enter a credit card number (enter a blank line to quit): ");
      inputStr = keyboard.nextLine();     // update input or quit
    }
    System.out.println("Goodbye!");
    keyboard.close();
  }
}
/**
 * This program takes in a list of player names and scores and
 * displays a visual representation of those scores as a bar chart
 * 
 * @author Bill Mullen
 * @version 20191010 
 */

import java.util.Scanner;

public class BarChartScoreboard {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String inputStr;
		String name;
		String max;
		int numPlayers;
		int maxScore;
		int numStars;
		int score;
		int i;
		int pos;
		
		// prompt for number of players
		System.out.print("Enter the number of players: ");
		inputStr = in.nextLine();
		numPlayers = Integer.parseInt(inputStr);
		
		// if number of players not 0 proceed
		if (numPlayers != 0) {
			// declare parallel arrays of size numPlayers
			String[] playerNames = new String[numPlayers];
			int[] playerScores = new int[numPlayers];
			
			// prompt user to fill parallel arrays
			for (i = 0; i < numPlayers; ++i) {
				System.out.print("Enter a player name: ");
				inputStr = in.nextLine();
				playerNames[i] = inputStr;
				
				System.out.print("Enter the score for " 
								+ playerNames[i] + ": ");
				inputStr = in.nextLine();
				score = Integer.parseInt(inputStr);
				playerScores[i] = score;
				System.out.println();
			}
			
			// format the output
			// find longest name 
			// call it max
			max = playerNames[0];
			for (i = 0; i < numPlayers; ++i) {
				name = playerNames[i];
				if (name.length() > max.length()) {
					max = name;
				}
			}
			
			// append spaces to names until all the same length
			for (i = 0; i < numPlayers; ++i) {
				name = playerNames[i];
				while (name.length() != max.length()) {
					name = name + " ";
				}
				playerNames[i] = name;
			}
			
			// find highest score
			// call it maxScore
			maxScore = playerScores[0];
			for (i = 0; i < numPlayers; ++i) {
				score = playerScores[i];
				if (score > maxScore) {
					maxScore = score;
				}
			}
			
			// display scoreboard header
			System.out.println("Current Scoreboard");
			System.out.println("------------------");
			// display formatted names and bars
			for (i = 0; i < numPlayers; ++i) {
				System.out.print(playerNames[i] + " ");
				try {
					numStars = (playerScores[i] * 50) / maxScore;
				}
				catch (ArithmeticException ex) {
					numStars = 0;
				}
				pos = 0;
				while (pos < numStars) {
					System.out.print("*");
					++pos;
				}
				System.out.println();
			}
		}
		// if number of players is 0 exit program
		else {
			System.out.println("No players to display?  Goodbye!");
		}
		in.close();
	}

}

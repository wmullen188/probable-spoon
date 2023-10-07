import java.util.Scanner;

public class Exam2B {
	
	private static String longest(String[] array) {
		String max = array[0];
		for (int i = 0; i < array.length; ++i) {
			if (array[i].length() > max.length()) {
				max = array[i];
			}
		}
		return max;
		
	}
	
	private static int[] zeroOdds(int[] array) {
		for (int i = 0; i < array.length; ++i) {
			if (array[i] % 2 == 1) {
				array[i] = 0;
			}
		}
		return array;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter an integer: ");
		int input = Integer.parseInt(in.nextLine());
		while (input > 0) {
			for (int i = 1; i <= input; ++i) {
				for (int j = 1; j <= i; ++j) {
					System.out.print(input);
				}
				System.out.println();
			}
			System.out.print("Enter an integer: ");
			input = Integer.parseInt(in.nextLine());
		}
		System.out.println("Goodbye!");
		in.close();
	}

}

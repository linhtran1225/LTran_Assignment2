/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: RNG generates random number and input validation. RandomNumberGuesser displays the prompts and asks user for inputs.
 * Due: 02/27/2023
 * Platform/compiler: Eclipse Window 10
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Linh Tran
*/

import java.util.*;
public class RandomNumberGuesser {
	public static void main(String[] args) {
		String answer = "yes";
		int guess, minGuess, maxGuess;
		boolean inputCheck = true;
		Scanner scan = new Scanner(System.in);
		while (answer.equalsIgnoreCase("yes")) {
			minGuess = 1;
			maxGuess = 100;
			int randNum = RNG.rand();
			System.out.println("This application generates a random integer between 0 and 100");
			System.out.println(" and asks the user to guess repeatedly until they guess correctly.");
			System.out.println();
			System.out.println("Enter your first guess: ");
			guess = scan.nextInt();
			if (guess == randNum) {
				System.out.println("Congratulations, you guessed correctly");
			}
			else {
				while (inputCheck) {
					do {
						inputCheck = RNG.inputValidation(guess, minGuess, maxGuess);
						if (inputCheck) {
							break;
						}
						guess = scan.nextInt();
					} while (!inputCheck);
					if (guess < randNum) {
						minGuess = guess + 1;
						System.out.println("Your guess is too low");
					}
					else if (guess > randNum) {
						maxGuess = guess - 1;
						System.out.println("Your guess is too high");
					}
					else {
						System.out.println("Congratulations, you guessed correctly");
						break;
					}
					if (RNG.getCount() == 7) {
						System.out.println("You have exceeded the maximum number of guesses, " + RNG.getCount() + ". Try again.");
						System.exit(0); 
					}
					System.out.println("Number of guesses is: " + RNG.getCount());
					System.out.println("Enter your next guess between " + minGuess + " and " + maxGuess);
					guess = scan.nextInt();
				}
				
			}
			System.out.println("Try again? (yes or no) ");
			scan.nextLine(); 
			answer = scan.nextLine();
			if (!(answer.equalsIgnoreCase("no"))){
				RNG.resetCount();
			}
		}
		System.out.println("Thanks for playing...");
		System.out.println();
		System.out.println("Programmer name: Linh Tran.");
		scan.close();
	}
	
}


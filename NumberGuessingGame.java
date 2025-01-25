import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int totalRounds = 0;
        int totalScore = 0;

        while (true) {
            int attempts = 0;
            int maxAttempts = 10;             int targetNumber = random.nextInt(100) + 1; 
            boolean guessedCorrectly = false;

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I have generated a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

                 while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > targetNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You've guessed the number.");
                    guessedCorrectly = true;
                    break;
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all " + maxAttempts + " attempts. The correct number was " + targetNumber + ".");
            }

            totalRounds++;
            if (guessedCorrectly) {
                totalScore += (maxAttempts - attempts + 1); // Score based on remaining attempts
            }

            // Asking the user if they want to play again
            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain = scanner.next();

            if (playAgain.equalsIgnoreCase("no")) {
                break;
            }
        }

        // Displaying total rounds and score
        System.out.println("\nGame Over!");
        System.out.println("Total Rounds Played: " + totalRounds);
        System.out.println("Your Total Score: " + totalScore);
        scanner.close();
    }
}

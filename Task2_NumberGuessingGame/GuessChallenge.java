import java.util.Random;
import java.util.Scanner;

public class GuessChallenge {

    // Method to start and control the game
    public static void playGame(Scanner input) {

        // Variable to check whether player wants another round
        char playAgain;

        // Stores total score of all rounds
        int totalScore = 0;

        do {

            // Random object for generating random numbers
            Random randomValue = new Random();

            // Random number between 1 and 100
            int secretNumber = randomValue.nextInt(100) + 1;

            // Stores number of attempts used
            int attemptsUsed = 0;

            // Maximum attempts allowed
            int maximumAttempts = 5;

            System.out.println("\n===== NEW ROUND =====");
            System.out.println("All the best!");
            System.out.println("Guess the number between 1 and 100");

            // Checks whether player guessed correctly
            boolean guessedCorrectly = false;

            // Loop continues until attempts are over
            while (attemptsUsed < maximumAttempts) {

                System.out.print("Enter your guess: ");

                // Taking user guess input
                int guessedNumber = input.nextInt();

                // Increasing attempt count
                attemptsUsed++;

                // Condition for correct guess
                if (guessedNumber == secretNumber) {

                    guessedCorrectly = true;

                    System.out.println("Correct Guess!");
                    System.out.println("Attempts Taken: " + attemptsUsed);

                    // Score calculation
                    int roundScore =
                            (maximumAttempts - attemptsUsed + 1) * 20;

                    // Adding round score to total score
                    totalScore += roundScore;

                    System.out.println("Round Score: " + roundScore);
                    System.out.println("Total Score: " + totalScore);
                    System.out.println("----------------------");

                    break;
                }

                // Hint if guessed number is larger
                else if (guessedNumber > secretNumber) {

                    System.out.println("Too High");
                }

                // Hint if guessed number is smaller
                else {

                    System.out.println("Too Low");
                }

                // Display remaining attempts
                System.out.println("Attempts Left: " +
                        (maximumAttempts - attemptsUsed));
            }

            // Executes if player fails all attempts
            if (!guessedCorrectly) {

                System.out.println("Round Over");
                System.out.println("Correct Number was: " +
                        secretNumber);

                System.out.println("Round Score: 0");
                System.out.println("Total Score: " + totalScore);
                System.out.println("----------------------");
            
                System.out.println("Nice Try!");
            }

            // Asking user whether to continue game
            System.out.print("\nPlay another round? (Y/N): ");

            playAgain = input.next().charAt(0);

        } while (playAgain == 'Y' || playAgain == 'y');
    }

    // Method to display game rules
    public static void displayRules() {

        System.out.println("\n===== GAME RULES =====");
        System.out.println("1. Guess a number between 1 and 100");
        System.out.println("2. You have only 5 chances");
        System.out.println("3. Hints will be displayed");
        System.out.println("4. Score depends on attempts used");
        System.out.println("5. Multiple rounds are allowed");
    }

    public static void main(String[] args) {

        // Scanner object for user input
        Scanner input = new Scanner(System.in);

        // Infinite loop for menu system
        while (true) {

            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1. Start Game");
            System.out.println("2. View Rules");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");

            // Taking menu choice input
            int option = input.nextInt();

            // Starts game
            if (option == 1) {
                

                playGame(input);
            }

            // Displays rules
            else if (option == 2) {

                displayRules();
            }

            // Exits program
            else if (option == 3) {

                System.out.println("Exiting Program...");
                break;
            }

            // Executes for invalid menu input
            else {

                System.out.println("Invalid Choice");
            }
        }

        // Closing scanner object
        input.close();
    }
}

Create GuessChallenge.java

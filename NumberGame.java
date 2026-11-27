import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        char playAgain;

        System.out.println("Welcome to Number Guessing Game!");

        do {
            int number = random.nextInt(100) + 1;
            int guess;
            int attempts = 0;
            int maxAttempts = 7;
            boolean won = false;

            System.out.println("\nGuess a number between 1 and 100.");
            System.out.println("You have 7 attempts.");

            while (attempts < maxAttempts) {

                System.out.print("Enter your guess: ");
                guess = sc.nextInt();
                attempts++;

                if (guess == number) {
                    System.out.println("Correct! You guessed the number.");
                    won = true;
                    break;
                }
                else if (guess > number) {
                    System.out.println("Too high! Try again.");
                }
                else {
                    System.out.println("Too low! Try again.");
                }

                System.out.println("Attempts left: " +
                                   (maxAttempts - attempts));
            }

            if (won) {
                int score = 100 - (attempts - 1) * 10;
                totalScore += score;

                System.out.println("Round Score: " + score);
            }
            else {
                System.out.println("Game Over!");
                System.out.println("The number was: " + number);
                System.out.println("Round Score: 0");
            }

            System.out.println("Total Score: " + totalScore);

            System.out.print("Do you want to play again? (Y/N): ");
            playAgain = sc.next().charAt(0);

        } while (playAgain == 'Y' || playAgain == 'y');

        System.out.println("\nThanks for playing!");
        System.out.println("Final Score: " + totalScore);

        sc.close();
    }
}
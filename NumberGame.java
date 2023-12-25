import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalScore = 0;

        while (playAgain) {
            int minimumlimit = 1;
            int higherlimit = 100;
            int targetNumber = random.nextInt(higherlimit - minimumlimit + 1) + minimumlimit;
            int maxAttempts = 5;
            int attempts = 0;
            int roundScore = 0;

            System.out.println("Welcome to the Number Game!");
            System.out.println("I've chosen a number between " + minimumlimit + " and " + higherlimit + ". Try to guess it.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    roundScore = maxAttempts - attempts + 1;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (roundScore == 0) {
                System.out.println("Sorry, you've run out of attempts. The correct number was: " + targetNumber);
            }

            totalScore += roundScore;

            System.out.println("Your current round score is: " + roundScore);
            System.out.println("Your total score is: " + totalScore);

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next().toLowerCase();
            playAgain = playAgainResponse.equals("yes");
        }

        System.out.println("Thanks for playing! Your final total score is: " + totalScore);
        scanner.close();
    }
}

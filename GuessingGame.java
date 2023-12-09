import java.util.Random;
import java.util.Scanner;
import java.util.NoSuchElementException;

class GuessingGame {
    int getInput(Scanner scnr) { // returns 0 for lower, 1 for higher, 2 for correct, -1 for illegal error
        try {
            String line = scnr.nextLine();
            System.out.println("Line is: " + line);
            if (line.equals("lower")) {
                return 0;
            } else if (line.equals("higher")) {
                return 1;
            } else if (line.equals("correct")) {
                return 2;
            } else {
                System.out.println("Invalid input: please enter 'lower' or 'higher' or 'correct'.");
                return getInput(scnr);
            }
        } catch (NoSuchElementException e) {
            System.out.println("There was an error getting your input: please enter 'lower' or 'higher' or 'correct'.");
            return getInput(scnr);
        } catch (IllegalStateException e) {
            System.out.println("Something is very wrong. Please restart the program.");
            return -1;
        }
    }

    public void guessNumber(int lowVal, int highVal, Scanner scnr, int numGuesses, int lastGuess) {
        numGuesses += 1;
        System.out.println("### Debug: guess #:" + numGuesses + "; Range: " + lowVal + "," + highVal);
        int guess = (lowVal + highVal) / 2;
        System.out.println("Guess No. " + numGuesses + ". My guess is: " + guess);
        System.out.println("Tell me, should I go 'higher', 'lower', or is the guess 'correct'?");
        if (guess == lastGuess) { // base case no. 1, the player made a mistake.
            System.out.println("Sorry, I think there's a mistake. I can't guess it.");
            return;
        } else {
            int inputInt = getInput(scnr);

            if (inputInt == 2) { // base case no. 2, the guess is correct.
                System.out.println("Yay, I got it right in " + numGuesses + " guesses!");
                return;
            } else if (inputInt == 0) { // recursive cases, guess with midpoint
                guessNumber(lowVal, guess, scnr, numGuesses, guess);
            } else if (inputInt == 1) {
                guessNumber(guess, highVal, scnr, numGuesses, guess);
            } else {
                return;
            }
        }
    }

    // Method to start the game
    public void startGame() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        // Generate a random number between 0 and 100
        int secretNumber = random.nextInt(101);
        System.out.println("The secret number is " + secretNumber + ".");
        guessNumber(0, 100, scanner, 0, 0);
        scanner.close();
    }

    public static void main(String[] args) {
        GuessingGame game = new GuessingGame();
        game.startGame();
    }

}
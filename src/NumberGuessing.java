import java.util.Random;
import java.util.Scanner;

public class NumberGuessing {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Random rand = new Random();
            System.out.println("Welcome to the Number Guessing Game!");
            boolean play = true;
            while (play) {
                int target = rand.nextInt(100) + 1;
                int attempts = 0;
                System.out.println("I have chosen a number between 1 and 100. Try to guess it!");
                while (true) {
                    System.out.print("Enter your guess: ");
                    String line = sc.nextLine();
                    if (line.trim().isEmpty()) {
                        System.out.println("Please enter a number.");
                        continue;
                    }
                    int guess;
                    try {
                        guess = Integer.parseInt(line.trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a number only.");
                        continue;
                    }
                    attempts++;
                    if (guess < target) System.out.println("Higher!");
                    else if (guess > target) System.out.println("Lower!");
                    else {
                        System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                        break;
                    }
                }
                System.out.print("Do you want to play again? (y/n): ");
                String ans = sc.nextLine().trim().toLowerCase();
                play = ans.startsWith("y");
            }
            System.out.println("Thanks for playing. Goodbye!");
        }
    }
}

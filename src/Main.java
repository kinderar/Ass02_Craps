import java.util.Scanner;
import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        Random rnd = new Random();
        char playAgain;
        int die1 = 0;
        int die2 = 0;
        int sum = 0;

        do {
            // Initial roll
            die1 = rnd.nextInt(6) + 1;
            die2 = rnd.nextInt(6) + 1;
            sum = die1 + die2;

            System.out.println("Rolling the dice...");
            System.out.println("You rolled: " + die1 + " + " + die2 + " = " + sum);

            // Check initial roll result
            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You rolled " + sum + ". You lose!");
            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural! You rolled " + sum + ". You win!");
            } else {
                System.out.println("Point is set to " + sum);
                int point = sum;

                // Subsequent rolls
                while (true) {
                    die1 = rnd.nextInt(6) + 1;
                    die2 = rnd.nextInt(6) + 1;
                    sum = die1 + die2;

                    System.out.println("Rolling the dice again...");
                    System.out.println("You rolled: " + die1 + " + " + die2 + " = " + sum);

                    if (sum == point) {
                        System.out.println("You made your point! You win!");
                        break;
                    } else if (sum == 7) {
                        System.out.println("Oh no! You rolled a 7. You lose!");
                        break;
                    }
                }
            }

            System.out.print("Do you want to play again? (Y/N)");
            playAgain = in.next().charAt(0);
        } while (playAgain == 'Y' || playAgain == 'y');

        System.out.println("Thanks for playing Craps!");
    }
}
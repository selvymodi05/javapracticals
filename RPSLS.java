import java.util.Random;
import java.util.Scanner;

public class RPSLS {

    enum Move {
        ROCK, PAPER, SCISSORS, LIZARD, SPOCK
    }

    static int winner(Move a, Move b) {

        if (a == b)
            return 0;

        return switch (a) {
            case SCISSORS -> (b == Move.PAPER || b == Move.LIZARD) ? 1 : -1;
            case PAPER -> (b == Move.ROCK || b == Move.SPOCK) ? 1 : -1;
            case ROCK -> (b == Move.SCISSORS || b == Move.LIZARD) ? 1 : -1;
            case LIZARD -> (b == Move.SPOCK || b == Move.PAPER) ? 1 : -1;
            case SPOCK -> (b == Move.SCISSORS || b == Move.ROCK) ? 1 : -1;
        };
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int playerScore = 0;
        int computerScore = 0;

        for (int round = 1; round <= 5; round++) {

            Move computer = Move.values()[random.nextInt(5)];

            System.out.println("\nRound " + round);
            System.out.print("Enter your move (ROCK, PAPER, SCISSORS, LIZARD, SPOCK): ");

            String input = sc.nextLine().toUpperCase();

            Move player;

            try {
                player = Move.valueOf(input);
            } catch (Exception e) {
                System.out.println("Invalid move! Try again.");
                round--;
                continue;
            }

            int result = winner(player, computer);

            System.out.println("You played: " + player);
            System.out.println("Computer played: " + computer);

            if (result == 1) {
                System.out.println("Round winner: You");
                playerScore++;
            } else if (result == -1) {
                System.out.println("Round winner: Computer");
                computerScore++;
            } else {
                System.out.println("Round winner: Tie");
            }
        }

        System.out.println("\n--- Final Result ---");
        System.out.println("Your score: " + playerScore);
        System.out.println("Computer score: " + computerScore);

        if (playerScore > computerScore)
            System.out.println("You win " + playerScore + "-" + computerScore);
        else if (computerScore > playerScore)
            System.out.println("Computer wins " + computerScore + "-" + playerScore);
        else
            System.out.println("It's a tie: " + playerScore + "-" + computerScore);

        sc.close();
    }
}
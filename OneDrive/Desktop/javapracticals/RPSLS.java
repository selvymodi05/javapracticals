import java.util.*;

public class RPSLS {

    enum Move {
        ROCK, PAPER, SCISSORS, LIZARD, SPOCK
    }

    static int winner(Move a, Move b) {
        return switch (a) {
            case ROCK -> switch (b) {
                case SCISSORS, LIZARD -> 1;
                case PAPER, SPOCK -> -1;
                case ROCK -> 0;
            };
            case PAPER -> switch (b) {
                case ROCK, SPOCK -> 1;
                case SCISSORS, LIZARD -> -1;
                case PAPER -> 0;
            };
            case SCISSORS -> switch (b) {
                case PAPER, LIZARD -> 1;
                case ROCK, SPOCK -> -1;
                case SCISSORS -> 0;
            };
            case LIZARD -> switch (b) {
                case SPOCK, PAPER -> 1;
                case ROCK, SCISSORS -> -1;
                case LIZARD -> 0;
            };
            case SPOCK -> switch (b) {
                case SCISSORS, ROCK -> 1;
                case PAPER, LIZARD -> -1;
                case SPOCK -> 0;
            };
        };
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int playerScore = 0;
        int computerScore = 0;

        for (int round = 1; round <= 5; round++) {

            Move computer = Move.values()[random.nextInt(5)];

            System.out.print("Round " + round + " - Enter your move: ");
            String input = sc.nextLine().toUpperCase();

            Move player;

            try {
                player = Move.valueOf(input);
            } catch (Exception e) {
                System.out.println("Invalid move. Try again.");
                round--;
                continue;
            }

            int result = winner(player, computer);

            System.out.println("You: " + player);
            System.out.println("Computer: " + computer);

            if (result == 1) {
                System.out.println("Round winner: You");
                playerScore++;
            } else if (result == -1) {
                System.out.println("Round winner: Computer");
                computerScore++;
            } else {
                System.out.println("Round winner: Tie");
            }

            System.out.println();
        }

        if (playerScore > computerScore)
            System.out.println("You win " + playerScore + "–" + computerScore);
        else if (computerScore > playerScore)
            System.out.println("Computer wins " + computerScore + "–" + playerScore);
        else
            System.out.println("Tie " + playerScore + "–" + computerScore);

        sc.close();
    }
}
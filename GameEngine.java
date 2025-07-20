import java.util.List;
import java.util.Scanner;

public class GameEngine {
    private List<Player> players;
    private Dice dice;
    private Scanner sc;
    private int round;

    public GameEngine(List<Player> players, Scanner sc) {
        this.players = players;
        this.dice = new Dice();
        this.sc = sc;
        this.round = 1;
    }

    public void startGame() {
        boolean keepPlaying = true;

        while (keepPlaying) {
            System.out.println("\n=== Round " + round + " ===");

            int highestRoll = 0;
            Player roundWinner = null;

            for (Player player : players) {
                int roll = dice.roll();
                System.out.println(player.getName() + " rolled a " + roll);

                if (roll > highestRoll) {
                    highestRoll = roll;
                    roundWinner = player;
                } else if (roll == highestRoll && roundWinner != null) {
                    roundWinner = null; // It's a tie for now
                }
            }

            if (roundWinner != null) {
                System.out.println(roundWinner.getName() + " wins round " + round + "!");
                roundWinner.addScore(1);
            } else {
                System.out.println("It's a tie in round " + round + "! No points awarded.");
            }

            round++;

            // Ask user whether to continue or see results
            System.out.print("\nType 'r' to view results, or any other key to play next round: ");
            String choice = sc.next();

            if (choice.equalsIgnoreCase("r")) {
                displayResults();
                keepPlaying = false;
            }
        }
    }

    private void displayResults() {
        System.out.println("\n=== Final Scores ===");
        for (Player player : players) {
            System.out.println(player.getName() + ": " + player.getScore() + " point(s)");
        }

        // Determine winner(s)
        int maxScore = 0;
        for (Player player : players) {
            if (player.getScore() > maxScore) {
                maxScore = player.getScore();
            }
        }

        System.out.print("Winner(s): ");
        boolean first = true;
        for (Player player : players) {
            if (player.getScore() == maxScore) {
                if (!first) System.out.print(", ");
                System.out.print(player.getName());
                first = false;
            }
        }
        System.out.println(" with " + maxScore + " point(s)!");
    }
}

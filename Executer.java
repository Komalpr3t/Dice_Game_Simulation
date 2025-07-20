import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Executer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of players: ");
        int numPlayers = sc.nextInt();
        sc.nextLine(); // Consume leftover newline

        List<Player> players = new ArrayList<>();

        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter name for Player " + (i + 1) + ": ");
            String name = sc.nextLine();
            players.add(new Player(name));
        }

        GameEngine engine = new GameEngine(players, sc);
        engine.startGame();

        sc.close(); // Clean up
    }
}

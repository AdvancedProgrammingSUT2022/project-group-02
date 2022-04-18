package view;
import controller.GameController;
import enums.RegexEnums;
import model.User;

import java.util.*;
import java.util.regex.*;
public class PlayGame {
    private ArrayList<User> players;
    private GameController gameController;
    private Matcher matcher;
    public PlayGame (ArrayList<User> players) {
        this.players = players;
        gameController = new GameController(players, 1);
    }
    public void run(Scanner scanner) {
        String input;
        int role = 0;
        while (players.get(role).getTurns() > 0) {
            input = scanner.nextLine();
            if (input.equals("game exit"))
                return;
            //cheat code for increasing turn
            else if ((matcher = RegexEnums.getMatcher(input, RegexEnums.INCREASE_TURN1)) != null ||
                     (matcher = RegexEnums.getMatcher(input, RegexEnums.INCREASE_TURN2)) != null) {
                int amount = Integer.parseInt(matcher.group("amount"));
                if (amount > 0) {
                    gameController.increaseTurn(amount, players.get(role));
                    System.out.println("turn increased successfully!");
                }
                else
                    System.out.println("invalid number");
            }
            //cheat code for increasing gold
            else if ((matcher = RegexEnums.getMatcher(input, RegexEnums.INCREASE_GOLD1)) != null ||
                    (matcher = RegexEnums.getMatcher(input, RegexEnums.INCREASE_GOLD2)) != null) {
                int amount = Integer.parseInt(matcher.group("amount"));
                if (amount > 0) {
                    gameController.increaseGold(amount, players.get(role));
                    System.out.println("gold increased successfully!");
                }
                else
                    System.out.println("invalid command");
            }
            else
                System.out.println("invalid command");
        }
    }
}

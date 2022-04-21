package view;
import controller.GameController;
import enums.RegexEnums;
import model.Maps;
import model.Tile;
import model.Unit;
import model.User;

import java.util.*;
import java.util.regex.*;
public class PlayGame {
    private ArrayList<User> players;
    private GameController gameController;
    private Maps map;
    private Matcher matcher;
    private int mapSize;
    public PlayGame (ArrayList<User> players, int mapSize) {
        this.players = players;
        this.mapSize = mapSize;
        map = new Maps(mapSize);
        gameController = new GameController(players, 1, map, mapSize);
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

            else if ((matcher = RegexEnums.getMatcher(input, RegexEnums.SELECT_TILE)) != null) {
                int xOrigin = Integer.parseInt(matcher.group("x"));
                int yOrigin = Integer.parseInt(matcher.group("y"));
                // valid coordinates
                if (xOrigin >= 0 && yOrigin >= 0) {
                    Tile origin = gameController.findTile(xOrigin, yOrigin);
                    if (origin != null) {
                        selectedTile(scanner, origin, xOrigin, yOrigin);
                    }
                    else
                        System.out.println("invalid tile");
                }
                else
                    System.out.println("invalid coordinates");
            }

            else
                System.out.println("invalid command");
        }
    }
    public void selectedTile(Scanner scanner, Tile origin, int xOrigin, int yOrigin) {
        boolean focusOnTile = true;
        String tileInput;
        while (focusOnTile) {
            tileInput = scanner.nextLine();
            if (tileInput.equals("tile exit"))
                focusOnTile = false;
            else if ((matcher = RegexEnums.getMatcher(tileInput, RegexEnums.MOVE)) != null) {
                // move the unit to the destination
                int xDestination = Integer.parseInt(matcher.group("x"));
                int yDestination = Integer.parseInt(matcher.group("y"));
                if (xDestination >= 0 && yDestination >= 0) {
                    Tile destination = gameController.findTile(xDestination, yDestination);
                    if (destination != null) {
                        // call the function to move the unit
                        moveUnit(scanner, origin, destination, xOrigin, yOrigin, xDestination, yDestination);
                    }
                    else
                        System.out.println("invalid tile");
                }
                else
                    System.out.println("invalid coordinates");
            }
        }
    }
    public void moveUnit(Scanner scanner, Tile origin, Tile destination, int xOrigin, int yOrigin, int xDestination, int yDestination) {
        // TODO first check all the possibilities and move the unit
        double distance = Math.sqrt(Math.pow((xDestination - xOrigin), 2) + Math.pow((yDestination - yOrigin), 2));
        
    }
}

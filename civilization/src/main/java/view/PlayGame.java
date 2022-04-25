package view;
import controller.GameController;
import controller.MapController;
import enums.RegexEnums;
import model.*;

import java.util.*;
import java.util.regex.*;
public class PlayGame {
    private ArrayList<User> players;
    private GameController gameController;
    private Maps map;
    private Matcher matcher;
    private MapController mapController;
    private int role;
    private int height;
    private int width;

    public PlayGame (ArrayList<User> players, int height, int width) {
        this.players = players;
        this.map = new Maps(height, width);
        gameController = new GameController(players, 1, map, height, width);
        this.mapController = new MapController(map, height, width);
        this.height = height;
        this.width = width;
    }
    public void run(Scanner scanner) {
        String input;
        int role = 0;


        // TODO fill the map first


        // assign all the neighbors to each tile
        for (int i = 0; i < map.getHeight(); i++)
            for (int j = 0; j < map.getWidth(); j++)
                mapController.setNeighbor(map.getTileBoard()[i][j]);

        while (true) {
            User user = players.get(role);
            while (user.getTurns() > 0) {

                input = scanner.nextLine();
                if (input.equals("game exit"))
                    return;
                    //cheat code for increasing turn
                else if ((matcher = RegexEnums.getMatcher(input, RegexEnums.INCREASE_TURN1)) != null ||
                        (matcher = RegexEnums.getMatcher(input, RegexEnums.INCREASE_TURN2)) != null) {
                    int amount = Integer.parseInt(matcher.group("amount"));
                    if (amount > 0) {
                        gameController.increaseTurn(amount, user);
                        System.out.println("turn increased successfully!");
                    } else
                        System.out.println("invalid number");
                }
                //cheat code for increasing gold
                else if ((matcher = RegexEnums.getMatcher(input, RegexEnums.INCREASE_GOLD1)) != null ||
                        (matcher = RegexEnums.getMatcher(input, RegexEnums.INCREASE_GOLD2)) != null) {
                    int amount = Integer.parseInt(matcher.group("amount"));
                    if (amount > 0) {
                        gameController.increaseGold(amount, user);
                        System.out.println("gold increased successfully!");
                    } else
                        System.out.println("invalid command");
                }
                // selecting tile
                else if ((matcher = RegexEnums.getMatcher(input, RegexEnums.SELECT_TILE)) != null) {
                    int xOrigin = Integer.parseInt(matcher.group("x"));
                    int yOrigin = Integer.parseInt(matcher.group("y"));
                    // valid coordinates
                    if (xOrigin >= 0 && yOrigin >= 0) {
                        Tile origin = gameController.findTile(xOrigin, yOrigin);
                        if (origin != null) {
                            selectedTile(scanner, origin, xOrigin, yOrigin, user);
                        } else
                            System.out.println("invalid tile");
                    } else
                        System.out.println("invalid coordinates");
                }
                else if (input.trim().equals("show board")) {
                    // add all visible tiles and update visited files
                    mapController.addAllVisibleAndVisitedTiles(user);
                    showBoard(user);
                }
                else if (input.trim().equals("show players")) {
                    showPlayers();
                }
                else if (input.trim().equals("show information")) {
                    showInformation(user);
                }
                else
                    System.out.println("invalid command");
            }
            role++;
            user.setTurns(gameController.getTurnForEachPlayer());
            if (role >= players.size())
                role = 0;
        }
    }

    public void selectedTile(Scanner scanner, Tile origin, int xOrigin, int yOrigin, User user) {
        origin.setSelectedOne(false);
        origin.setSelectedTwo(false);
        if (origin.isMilitaryUnitExists())
            origin.setSelectedOne(true);
        else if (origin.isCivilianUnitExists())
            origin.setSelectedTwo(true);

        String tileInput;
        while (true) {
            tileInput = scanner.nextLine();
            if (tileInput.equals("tile exit"))
                return;
            else if ((matcher = RegexEnums.getMatcher(tileInput, RegexEnums.SELECT_TILE)) != null) {
                int anotherXOrigin = Integer.parseInt(matcher.group("x"));
                int anotherYOrigin = Integer.parseInt(matcher.group("y"));
                if (anotherXOrigin >= 0 && anotherYOrigin >= 0) {
                    if (anotherXOrigin == xOrigin && anotherYOrigin == yOrigin) {
                        // if the user press again on the tile , change the unit if two exists
                        if (origin.isMilitaryUnitExists() && origin.isSelectedOne() && origin.isCivilianUnitExists()) {
                            origin.setSelectedOne(false);
                            origin.setSelectedTwo(true);
                        }
                        else if (origin.isCivilianUnitExists() && origin.isSelectedTwo() && origin.isMilitaryUnitExists()) {
                            origin.setSelectedOne(true);
                            origin.setSelectedTwo(false);
                        }
                    }
                    else {
                        Tile destination = gameController.findTile(anotherXOrigin, anotherYOrigin);
                        if (destination != null) {
                            selectedTile(scanner, destination, anotherXOrigin, anotherYOrigin, user);
                            origin.setSelectedOne(false);
                            origin.setSelectedTwo(false);
                            return;
                        }
                        else
                            System.out.println("invalid tile");
                    }
                }
                else
                    System.out.println("invalid coordinates");
            }
            else if ((matcher = RegexEnums.getMatcher(tileInput, RegexEnums.MOVE)) != null) {
                if (origin.isCivilianUnitExists() || origin.isMilitaryUnitExists()) {
                    int xDestination = Integer.parseInt("x");
                    int yDestination = Integer.parseInt("y");
                    if (xDestination >= 0 && yDestination >= 0) {
                        Tile destination = gameController.findTile(xDestination, yDestination);
                        if (destination != null) {
                            if (origin.isMilitaryUnitExists() && origin.isSelectedOne()) {
                                if (!destination.isMilitaryUnitExists() && !destination.getLand().getName().equals("mountain") && !destination.getLand().getName().equals("ocean"))
                                    moveUnit(scanner, origin, destination, origin.getMilitaryUnit(), user, true);
                                else
                                    System.out.println("can't move a unit to this tile");
                            }
                            else if (origin.isCivilianUnitExists() && origin.isSelectedTwo()) {
                                if (!destination.isCivilianUnitExists())
                                    moveUnit(scanner, origin, destination, origin.getCivilianUnit(), user, false);
                                else
                                    System.out.println("can't move a unit to this tile");
                            }
                            else
                                System.out.println("there is no unit in this tile!");
                        }
                        else
                            System.out.println("invalid destination");
                    }
                    else
                        System.out.println("invalid coordinates");
                }
                else
                    System.out.println("there is no unit in this tile!");
            }
        }
    }

    public void moveUnit(Scanner scanner, Tile origin, Tile destination, Unit unit, User user, boolean isMilitary) {

        ArrayList<Tile> tilesInTheWay = new ArrayList<>();
        Tile tile = origin;
        while ((tile = mapController.bestChoiceAmongNeighbors(tile, destination, isMilitary)) != destination) {
            if (tile == null) {
                System.out.println("sorry, moving is impossible");
                return;
            }
            tilesInTheWay.add(tile);
        }
        int mp = 0;
        for (Tile value : tilesInTheWay) {
            if (value.getLand().getMovementPrice() > user.getTurns()) {
                gameController.moveUnit(origin, value, unit, isMilitary);
                System.out.println(mp + " movement by unit to get to the destination");
                return;
            }
            mp += value.getLand().getMovementPrice();
            user.setTurns(user.getTurns() - value.getLand().getMovementPrice());
        }
        gameController.moveUnit(origin, destination, unit, isMilitary);
        System.out.println(mp + " movement by unit to get to the destination");
    }

    private void showBoard(User user) {
        for (Tile tile : user.getVisible()) {
            // TODO first show the visible tiles
        }

        for (Tile tile : user.getVisited()) {
            if (!user.getVisible().contains(tile)) {
                // TODO show the tiles which are not completely visible
            }
        }
    }

    private void showPlayers() {
        int index = 1;
        for (User player : players) {
            System.out.println(index + "- username: " + player.getUsername() + " nickname: " + player.getNickname());
            index++;
        }
    }
    private void showInformation(User user) {
        //temporary
        System.out.println("username: " + user.getUsername());
        System.out.println("nickname: " + user.getNickname());
        System.out.println("remained movements: " + user.getTurns());
        System.out.println("gold: " + user.getGold());
        System.out.println("culture: " + user.getCulture());
        System.out.println("faith: " + user.getFaith());
        System.out.println("happiness: " + user.getHappiness());
        System.out.println("food: " + user.getFood());
    }
}

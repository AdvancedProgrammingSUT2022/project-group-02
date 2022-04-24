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
    private int mapSize;
    private MapController mapController;
    private int role;
    public PlayGame (ArrayList<User> players, int mapSize, MapController mapController) {
        this.players = players;
        this.mapSize = mapSize;
        map = new Maps(mapSize);
        gameController = new GameController(players, 1, map, mapSize);
        this.mapController = mapController;
    }
    public void run(Scanner scanner) {
        String input;
        int role = 0;
        // assign all the neighbors to each tile
        for (int i = 0; i < map.getHeight(); i++)
            for (int j = 0; j < map.getWidth(); j++)
                mapController.setNeighbor(map.getTileBoard()[i][j]);


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
            // selecting tile
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

            else if (input.trim().equals("show board")) {
                // add all visible tiles and update visited files
                mapController.addAllVisibleAndVisitedTiles();
                showBoard();
            }

            else
                System.out.println("invalid command");
        }
    }

    public void selectedTile(Scanner scanner, Tile origin, int xOrigin, int yOrigin) {
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
                            selectedTile(scanner, destination, anotherXOrigin, anotherYOrigin);
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
                                // TODO move the military unit to the destination
                                moveUnit(scanner, origin, destination, xOrigin, yOrigin, xDestination, yDestination, origin.getMilitaryUnit());
                            }
                            else if (origin.isCivilianUnitExists() && origin.isSelectedTwo()) {
                                // TODO move the civilian unit to the destination
                                moveUnit(scanner, origin, destination, xOrigin, yOrigin, xDestination, yDestination, origin.getCivilianUnit());
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

    public void moveUnit(Scanner scanner, Tile origin, Tile destination, int xOrigin, int yOrigin, int xDestination, int yDestination, Unit unit) {
        // TODO first check all the possibilities and move the unit

        ArrayList<Tile> tilesInTheWay = new ArrayList<>();
        Tile tile = origin;
        while ((tile = mapController.bestChoiceAmongNeighbors(tile, destination)) != destination) {
            tilesInTheWay.add(tile);
        }
        int mp = 0;
        for (Tile value : tilesInTheWay) {
            if (value.getLand().getMovementPrice() > players.get(role).getTurns()) {
                gameController.moveUnit(origin, value, unit);
                System.out.println(mp + " movement by unit to get to the destination");
                return;
            }
            mp += value.getLand().getMovementPrice();
            players.get(role).setTurns(players.get(role).getTurns() - value.getLand().getMovementPrice());
        }
        gameController.moveUnit(origin, destination, unit);
        System.out.println(mp + " movement by unit to get to the destination");
    }

    private void showBoard() {
        for (Tile tile : map.getVisible()) {
            // TODO first show the visible tiles
        }

        for (Tile tile : map.getVisited()) {
            if (!map.getVisible().contains(tile)) {
                // TODO show the tiles which are not completely visible
            }
        }
    }
}

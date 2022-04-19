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

            }
            /*else if ((matcher = RegexEnums.getMatcher(input, RegexEnums.MOVE)) != null) {
                //moving the unit
                //find the origin coordinates from input's regex
                int xOrigin = Integer.parseInt(matcher.group("originX"));
                int yOrigin = Integer.parseInt(matcher.group("originY"));
                //find the destination coordinates from input's regex
                int xDestination = Integer.parseInt(matcher.group("destinationX"));
                int yDestination = Integer.parseInt(matcher.group("destinationY"));
                //valid coordinates (natural number for coordinates + 0)
                if (xOrigin >= 0 && yOrigin >= 0 && xDestination >= 0 && yDestination >= 0) {
                    //find the index of origin tile with regard to given coordinates
                    int originIndex = gameController.findTile(xOrigin, yOrigin);
                    Tile originTile = map.getSpecificTile(originIndex);
                    //check if such tile exists
                    if (originIndex >= 0) {
                        //find the index of destination tile with regard to give coordinates
                        int destinationIndex = gameController.findTile(xDestination, yDestination);
                        Tile destinationTile = map.getSpecificTile(destinationIndex);
                        //check if such tile exists
                        if (destinationIndex >= 0) {
                            //units on the origin tile
                            Unit selectedUnitMilitary = originTile.getMilitaryUnit();
                            Unit selectedUnitCivilian = destinationTile.getCivilianUnit();
                            //which unit exists ? military or civilian or both ???
                            if (selectedUnitMilitary != null) {
                                //make sure there is no military unit in the destination tile
                                if (destinationTile.getMilitaryUnit() == null) {
                                    //swap
                                    selectedUnitMilitary.setTile(destinationTile);
                                    originTile.setMilitaryUnit(null);
                                    destinationTile.setMilitaryUnit(selectedUnitMilitary);
                                }
                                else
                                    System.out.println("there is already a military unit in this tile");
                            }
                            else if (selectedUnitCivilian != null) {
                                //make sure there is no civilian unit in the destination tile
                                if (destinationTile.getCivilianUnit() == null) {
                                    //swap
                                    selectedUnitCivilian.setTile(destinationTile);
                                    originTile.setCivilianUnit(null);
                                    destinationTile.setCivilianUnit(selectedUnitCivilian);
                                }
                                else
                                    System.out.println("there is already a military unit in this tile");
                            }
                            else
                                System.out.println("there is no unit in this tile");
                        }
                        else
                            System.out.println("invalid destination");
                    }
                    else
                        System.out.println("invalid origin");
                }
                else
                    System.out.println("invalid coordinate");
            }*/

            else
                System.out.println("invalid command");
        }
    }
}

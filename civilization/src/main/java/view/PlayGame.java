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
        System.out.println("Game started , good luck");
        System.out.println("the players are as follows:");
        showPlayers();
        fillMap(players.get(0), players.get(1));
        System.out.println("press \"game exit\" to end the game");
        System.out.println("press \"show board\" to see the map");
        System.out.println("press \"show players\" to see the players");
        System.out.println("press \"show information\" to see the information of current player");
        System.out.println("to select a tile :");
        System.out.println("select tile -x <x> -y <y>");
        System.out.println("**********************");
        System.out.println("while you are in tile :");
        System.out.println("press \"tile exit\" to get out of tile");
        System.out.println("to move a unit :");
        System.out.println("move unit -x <x> -y <y>");
        System.out.println("notice ---> x and y are coordinates of destination , make sure to use valid coordinates");
        System.out.println("to select another tile :");
        System.out.println("select tile -x <x> -y <y>");
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

    private void fillMap(User user1, User user2){
        //fill map
        //should change with file

        Terrain jungle = new Terrain("jungle", 2, 1, 0.25, 0, 1);
        Land Desert = new Land("Ocean", "yellow", 1, 0, -0.33, 0, 0, true);
        Land GrassLand = new Land("Grassland", "green", 1, 2, -0.33, 0, 0, true);
        Land Hill = new Land("Hill", "purple", 2, 0, 0.25, 0, 2, true);
        Land Mountain = new Land("Mountain", "cyan", 0, 0, 0, 0, 0, false);
        Land Ocean = new Land("Ocean", "black", 0, 0,0, 0, 0, false);
        Land Plain = new Land("Plain", "green", 1, 1, -0.33, 0, 1, true);
        Land SnowLand = new Land("Snow", "white", 1, 0 ,-0.33, 0, 0, true);

        boolean[] noRiver = {false ,false ,false ,false ,false ,false};
        boolean[] riverBorder1 = {false ,true ,false ,false ,false ,false};
        boolean[] riverBorder2 = {false ,false ,true ,true ,true ,false};
        boolean[] riverBorder3 = {false ,false ,false ,true ,true ,false};
        boolean[] riverBorder4 = {false ,false ,true ,true ,false ,false};
        boolean[] riverBorder5 = {true ,false ,false ,false ,false ,true};
        boolean[] riverBorder6 = {false ,false ,false ,true ,false ,false};
        boolean[] riverBorder7 = {true ,true ,false ,false ,false ,false};
        boolean[] riverBorder8 = {true ,false ,false ,false ,false ,false};
        Tile tile1 = new Tile(0 , 0, null, Ocean, 0, false, noRiver, null, jungle);
        Tile tile2 = new Tile(0, 1, null, Mountain, 0, false, noRiver, null, jungle);
        Tile tile3 = new Tile(0, 2, null, Mountain, 0, false, noRiver, null, jungle);
        Tile tile4 = new Tile(0, 3, null, Mountain, 0, true, riverBorder6, null, jungle);
        Tile tile5 = new Tile(1, 0, user2, GrassLand, 0, true, riverBorder3, null, jungle);
        Tile tile6 = new Tile(1, 1, user2, GrassLand, 0, false, noRiver, null, jungle);
        Tile tile7 = new Tile(1, 2, user2, Plain, 0, true, riverBorder4, null, jungle);
        Tile tile8 = new Tile(1, 3, null, Ocean, 0, false, noRiver, null, jungle);
        Tile tile9 = new Tile(2, 0, null, Ocean, 0, true, riverBorder1, null, jungle);
        Tile tile10 = new Tile(2, 1, user1, GrassLand, 0, true, riverBorder3, null, jungle);
        Tile tile11 = new Tile(2, 2, user2, GrassLand, 0, true, riverBorder4, null, jungle);
        Tile tile12 = new Tile(2, 3, user1, Plain, 0, true, riverBorder5, null, jungle);
        Tile tile13 = new Tile(3, 0, user1, Hill, 0, true, riverBorder7, null, jungle);
        Tile tile14 = new Tile(3, 1, null, Mountain, 0, true, riverBorder2, null, jungle);
        Tile tile15 = new Tile(3, 2, user2, SnowLand, 0, true, riverBorder5, null, jungle);
        Tile tile16 = new Tile(3, 3, null, Ocean, 0, false, noRiver, null, jungle);
        Tile tile17 = new Tile(4, 0, null, Ocean, 0, false, noRiver, null, jungle);
        Tile tile18 = new Tile(4, 1, user1, Desert, 0, true, riverBorder7, null, jungle);
        Tile tile19 = new Tile(4, 2, user1, Desert, 0, true, riverBorder5, null, jungle);
        Tile tile20 = new Tile(4, 3, user1, Desert, 0, false, noRiver, null, jungle);
        Tile tile21 = new Tile(5, 0, user1, Desert, 0, false, noRiver, null, jungle);
        Tile tile22 = new Tile(5, 1, user2, Desert, 0, true, riverBorder8, null, jungle);
        Tile tile23 = new Tile(5, 2, user1, Desert, 0, false, noRiver, null, jungle);
        Tile tile24 = new Tile(5, 3, null, Ocean, 0, false, noRiver, null, jungle);
        Tile tile25 = new Tile(6, 0, null, Ocean, 0, false, noRiver, null, jungle);
        Tile tile26 = new Tile(6, 1, user1, Plain, 0, false, noRiver, null, jungle);
        Tile tile27 = new Tile(6, 2, user2, Plain, 0, false, noRiver, null, jungle);
        Tile tile28 = new Tile(6, 3, user2, Plain, 0, false, noRiver, null, jungle);
        Tile tile29 = new Tile(7, 0, user2, Desert, 0, false, noRiver, null, jungle);
        Tile tile30 = new Tile(7, 1, user2, Desert, 0, false, noRiver, null, jungle);
        Tile tile31 = new Tile(7, 2, user1, Desert, 0, false, noRiver, null, jungle);
        Tile tile32 = new Tile(7, 3, user1, Ocean, 0, false, noRiver, null, jungle);
        map.getTileBoard()[0][0] = tile1;
        map.getTileBoard()[0][1] = tile2;
        map.getTileBoard()[0][2] = tile3;
        map.getTileBoard()[0][3] = tile4;
        map.getTileBoard()[1][0] = tile5;
        map.getTileBoard()[1][1] = tile6;
        map.getTileBoard()[1][2] = tile7;
        map.getTileBoard()[1][3] = tile8;
        map.getTileBoard()[2][0] = tile9;
        map.getTileBoard()[2][1] = tile10;
        map.getTileBoard()[2][2] = tile11;
        map.getTileBoard()[2][3] = tile12;
        map.getTileBoard()[3][0] = tile13;
        map.getTileBoard()[3][1] = tile14;
        map.getTileBoard()[3][2] = tile15;
        map.getTileBoard()[3][3] = tile16;
        map.getTileBoard()[4][0] = tile17;
        map.getTileBoard()[4][1] = tile18;
        map.getTileBoard()[4][2] = tile19;
        map.getTileBoard()[4][3] = tile20;
        map.getTileBoard()[5][0] = tile21;
        map.getTileBoard()[5][1] = tile22;
        map.getTileBoard()[5][2] = tile23;
        map.getTileBoard()[5][3] = tile24;
        map.getTileBoard()[6][0] = tile25;
        map.getTileBoard()[6][1] = tile26;
        map.getTileBoard()[6][2] = tile27;
        map.getTileBoard()[6][3] = tile28;
        map.getTileBoard()[7][0] = tile29;
        map.getTileBoard()[7][1] = tile30;
        map.getTileBoard()[7][2] = tile31;
        map.getTileBoard()[7][3] = tile32;
    }
}

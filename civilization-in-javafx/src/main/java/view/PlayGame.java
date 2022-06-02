package view;

import controller.*;
import view.enums.Colors;
import view.enums.RegexEnums;
import model.*;

import java.util.*;
import java.util.regex.*;

public class PlayGame {
    private final ArrayList<User> players;
    private final GameController gameController;
    private Maps map;
    private Matcher matcher;
    private final MapController mapController;
    private UnitController unitController;
    private final SettlerController settlerController;
    private final TechController techController;
    private CombatController combatController;
    private int role;
    private int height;
    private int width;
    private ArrayList<Tile> firstTurnsSettlers;
    private CityMenu cityMenu;
    private ResearchMenu researchMenu;


    public PlayGame(ArrayList<User> players, Maps map, int[][] ancientGraph, ArrayList<Technology> ancientTechnology) {
        this.players = players;
        this.map = map;
        this.height = 26;
        this.width = 80;
        gameController = new GameController(players, 1, map, height, width);
        this.mapController = new MapController(map);
        unitController = new UnitController();
        settlerController = new SettlerController();
        techController = new TechController(ancientGraph, ancientTechnology);
        combatController = new CombatController();
    }

    // provide some information for players
    private void manPlayGame() {
        String boldColor = Colors.YELLOW_BOLD;
        String color = Colors.CYAN;
        String noticeColor = Colors.RED;
        System.out.println("Game started , good luck");
        System.out.println("the players are as follows:");
        showPlayers();
        System.out.println(color + "press \"game exit\" to end the game");
        System.out.println("press \"show board\" to see the map");
        System.out.println("press \"show players\" to see the players");
        System.out.println("press \"show information\" to see the information of current player");
        System.out.println("press \"choose technology\" to choose a technology for research" + Colors.RESET);
        System.out.println(boldColor + "to select a tile :" + Colors.RESET);
        System.out.println(color + "select tile -x <x> -y <y>" + Colors.RESET);
        System.out.println("**********************");
        System.out.println(boldColor + "while you are in tile :" + Colors.RESET);
        System.out.println(color + "press \"tile exit\" to get out of tile" + Colors.RESET);
        System.out.println(boldColor + "to move a unit :" + Colors.RESET);
        System.out.println(color + "move unit to -x <x> -y <y>" + Colors.RESET);
        System.out.println(noticeColor + "notice" + Colors.RESET + " ---> x and y are coordinates of destination , make sure to use valid coordinates");
        System.out.println(boldColor + "to select another tile :" + Colors.RESET);
        System.out.println(color + "select tile -x <x> -y <y>" + Colors.RESET);
        System.out.println(boldColor + "to see possible improvements which can be implemented on this tile :" + Colors.RESET);
        System.out.println(color + "show possible improvements" + Colors.RESET);
        System.out.println("**********************");
        System.out.println(boldColor + "to create city with settler :" + Colors.RESET);
        System.out.println(color + "place city here" + Colors.RESET);
    }

    private void assignNeighbor() {

        // assign all the neighbors to each tile
        for (int i = 0; i < map.getHeight(); i++)
            for (int j = 0; j < map.getWidth(); j++)
                mapController.setNeighbor(map.getTileBoard()[i][j]);
    }

    public void run(Scanner scanner) {
        cityMenu = new CityMenu(mapController, techController, settlerController, gameController, players);
        researchMenu = new ResearchMenu(techController, gameController);
        UserPanel userPanel = new UserPanel(gameController);
        manPlayGame();
        String input;
        int role = 0;
        firstTurnsSettlers = mapController.firstSetOfSettlers(players);
        int turn = 1;
        assignNeighbor();
        boolean nextTurn = true;
        while (true) {
            User user = players.get(role);
            unitController.repairMovementPoint(user);
            String color = new ColorsController().getColorOfUser(user);
            System.out.println("it's " + color + user.getNickname() + Colors.RESET + " turn");
            // handle production turn in cities and research turn of user
            gameController.cityTurnProducts(user);
            gameController.userTurnResearch(user);
            gameController.userTurnWorker(user);
            gameController.increaseCitizens(user);
            gameController.citiesIncome(user);
            gameController.usersIncomeHandling(user , map);
            gameController.userHappiness(user);
            gameController.makeAllUnOrdered(user);
            gameController.foundCity(user);
            while (nextTurn) {

                input = scanner.nextLine();
                if (input.equals("game exit"))
                    return;
                else if (input.trim().equals("next turn")) {
                    boolean did = true;
                    if (user.getUnits() != null) {
                        for (Unit unit : user.getUnits()) {
                            if (!unit.isOrdered() && !unit.isAlert() && !unit.isSleep()) {
                                did = false;
                                break;
                            }
                        }
                    }
                    if (did) {
                        nextTurn = false;
                        user.setTurns(turn);
                    }
                    else
                        System.out.println("you didn't play all your turns");
                }
                else if (input.trim().equals("next turn --force")) {
                    nextTurn = false;
                    user.setTurns(turn);
                }
                else if (input.trim().equals("city menu")) {
                    cityMenu.run(scanner, user);
                }
                else if (input.trim().equals("research panel")) {
                    researchMenu.run(scanner, user);
                }
                else if (input.trim().equals("user panel")) {
                    userPanel.run(scanner, user);
                }
                    //cheat codes
                else if ((matcher = RegexEnums.getMatcher(input, RegexEnums.INCREASE_TURN1)) != null ||
                        (matcher = RegexEnums.getMatcher(input, RegexEnums.INCREASE_TURN2)) != null) {
                    int amount = Integer.parseInt(matcher.group("amount"));
                    if (amount > 0) {
                        gameController.increaseTurn(amount, user);
                        System.out.println("turn increased successfully!");
                        showMap(user);
                    } else
                        System.out.println("invalid number");

                }
                else if ((matcher = RegexEnums.getMatcher(input, RegexEnums.INCREASE_GOLD1)) != null ||
                        (matcher = RegexEnums.getMatcher(input, RegexEnums.INCREASE_GOLD2)) != null) {
                    int amount = Integer.parseInt(matcher.group("amount"));
                    if (amount > 0) {
                        gameController.increaseGold(amount, user);
                        System.out.println("gold increased successfully!");
                        showMap(user);
                    } else
                        System.out.println("invalid command");
                }
                else if((matcher = RegexEnums.getMatcher(input, RegexEnums.INCREASE_FOOD)) != null){
                    int amount = Integer.parseInt(matcher.group("amount"));
                    if (amount > 0) {
                        gameController.increaseFood(amount, user);
                        System.out.println("food increased successfully!");
                        showMap(user);
                    } else
                        System.out.println("invalid command");
                }else if((matcher = RegexEnums.getMatcher(input, RegexEnums.INCREASE_FAITH)) != null){
                    int amount = Integer.parseInt(matcher.group("amount"));
                    if (amount > 0) {
                        gameController.increaseFaith(amount, user);
                        System.out.println("faith increased successfully!");
                        showMap(user);
                    } else
                        System.out.println("invalid command");
                }else if((matcher = RegexEnums.getMatcher(input, RegexEnums.INCREASE_SCIENCE)) != null){
                    int amount = Integer.parseInt(matcher.group("amount"));
                    if (amount > 0) {
                        gameController.increaseScience(amount, user);
                        System.out.println("science increased successfully!");
                        showMap(user);
                    } else
                        System.out.println("invalid command");
                }else if((matcher = RegexEnums.getMatcher(input, RegexEnums.INCREASE_CAPITAL_CITIZENS)) != null){
                    int amount = Integer.parseInt(matcher.group("amount"));
                    if (amount > 0) {
                        if (user.getCapital() != null) {
                            gameController.increaseCapitalCitizens(amount, user);
                            System.out.println("capitalCitizens increased successfully!");
                            showMap(user);
                        }
                        else
                            System.out.println("user doesn't have capital right now!");
                    } else
                        System.out.println("invalid command");
                }else if((matcher = RegexEnums.getMatcher(input, RegexEnums.INCREASE_CAPITAL_DEFENCE)) != null){
                    int amount = Integer.parseInt(matcher.group("amount"));
                    if (amount > 0) {
                        if (user.getCapital() != null) {
                            gameController.increaseCapitalDefence(amount, user);
                            System.out.println("capitalDefence increased successfully!");
                            showMap(user);
                        }
                        else
                            System.out.println("user doesn't have capital right now!");
                    } else
                        System.out.println("invalid command");
                }else if((matcher = RegexEnums.getMatcher(input, RegexEnums.INCREASE_CULTURE)) != null){
                    int amount = Integer.parseInt(matcher.group("amount"));
                    if (amount > 0) {
                        gameController.increaseCulture(amount, user);
                        System.out.println("culture increased successfully!");
                        showMap(user);
                    } else
                        System.out.println("invalid command");
                }else if((matcher = RegexEnums.getMatcher(input, RegexEnums.INCREASE_HAPPINESS)) != null){
                    int amount = Integer.parseInt(matcher.group("amount"));
                    if (amount > 0) {
                        gameController.increaseHappiness(amount, user);
                        System.out.println("happiness increased successfully!");
                        showMap(user);
                    } else
                        System.out.println("invalid command");
                }else if((matcher = RegexEnums.getMatcher(input, RegexEnums.DECREASE_RESEARCH_TURN_LEFT)) != null){
                    int amount = Integer.parseInt(matcher.group("amount"));
                    if (amount > 0) {
                        if (user.getCurrentTechnology() != null) {
                            gameController.decreaseResearchTurnLeft(amount, user);
                            System.out.println("researches increased successfully!");
                            showMap(user);
                        }
                        else
                            System.out.println("user don't research on anything right now!");
                    } else
                        System.out.println("invalid number");
                }
                // selecting tile
                else if ((matcher = RegexEnums.getMatcher(input, RegexEnums.SELECT_TILE1)) != null ||
                        (matcher = RegexEnums.getMatcher(input, RegexEnums.SELECT_TILE2)) != null) {
                    int xOrigin = Integer.parseInt(matcher.group("x"));
                    int yOrigin = Integer.parseInt(matcher.group("y"));
                    // valid coordinates
                    if (xOrigin >= 0 && yOrigin >= 0 && xOrigin < map.getHeight() && yOrigin < map.getWidth()) {
                        Tile origin = map.getSpecificTile(xOrigin, yOrigin);
                        selectedTile(scanner, origin, xOrigin, yOrigin, user);
                    } else
                        System.out.println("invalid coordinates");
                }

                else if (input.trim().equals("choose technology")) {
                    if (!user.isResearching())
                        researchMenu.selectTech(user, scanner);
                    else
                        System.out.println("you are researching on something right now!");
                }

                else if (input.trim().equals("show board")) {
                    // add all visible tiles and update visited files
                    mapController.addAllVisibleAndVisitedTiles(user);
                    showMap(user);
                } else if (input.trim().equals("show players")) {
                    showPlayers();
                } else if (input.trim().equals("show information")) {
                    showInformation(user);
                } else
                    System.out.println("invalid command");
            }
            role++;
            user.setTurns(gameController.getTurnForEachPlayer());
            if (role >= players.size())
                role = 0;
            nextTurn = true;
        }
    }


    public void selectedTile(Scanner scanner, Tile origin, int xOrigin, int yOrigin, User user) {
        // TODO enable far working
        System.out.println("you have selected a tile with -x " + origin.getX() + " -y " + origin.getY());
        origin.setSelectedOne(false);
        origin.setSelectedTwo(false);
        if (origin.isMilitaryUnitExists())
            origin.setSelectedOne(true);
        else if (origin.isCivilianUnitExists())
            origin.setSelectedTwo(true);

        String tileInput;
        while (true) {
            tileInput = scanner.nextLine();
            if (tileInput.equals("tile exit")) {
                System.out.println("get out of tile");
                return;
            }

            else if ((matcher = RegexEnums.getMatcher(tileInput, RegexEnums.SELECT_TILE1)) != null ||
                    (matcher = RegexEnums.getMatcher(tileInput, RegexEnums.SELECT_TILE2)) != null) {
                if (selectAnotherTile(origin, scanner, user, xOrigin, yOrigin))
                    return;
            }
            // move the unit in this tile to destination
            else if ((matcher = RegexEnums.getMatcher(tileInput, RegexEnums.MOVE1)) != null ||
                    (matcher = RegexEnums.getMatcher(tileInput, RegexEnums.MOVE2)) != null) {
                Tile tile = moveUnitConditions(origin, user, matcher);
                if (tile != null && !tile.equals(origin)) {
                    selectedTile(scanner, tile, tile.getX(), tile.getY(), user);
                    return;
                }
            }
            // order settler to place city
            else if ((matcher = RegexEnums.getMatcher(tileInput, RegexEnums.CITY1)) != null ||
                    (matcher = RegexEnums.getMatcher(tileInput, RegexEnums.CITY2)) != null) {
                if (conditionsForPlaceCity(tileInput, origin)) {
                    String nameOfCity = matcher.group("city");
                    createCity(origin, user, nameOfCity);
                }
                else
                    System.out.println("");
            }
            // order worker to improve the tile
            else if (tileInput.trim().equals("show possible improvements")) {
                if (origin.isCivilianUnitExists() &&
                        origin.getCivilianUnit().getOwner().equals(user) &&
                        origin.getCivilianUnit().getName().equals("worker"))
                    showImprovements(origin, user, scanner);
                else
                    System.out.println("there is no worker in this tile");
            }
            else if (tileInput.trim().equals("city page")) {
                if (origin.getCity() != null && origin.getCity().getCityLocation().equals(origin))
                    cityMenu.cityPage(origin.getCity(), user, scanner);

                else
                    System.out.println("this tile is not a city");
            }
            else if (tileInput.trim().equals("tile information")) {
                tileInformation(origin);
            }
            else if ((matcher = RegexEnums.getMatcher(tileInput, RegexEnums.ATTACK_CITY1)) != null ||
                    (matcher = RegexEnums.getMatcher(tileInput, RegexEnums.ATTACK_CITY2)) != null) {
                int x = Integer.parseInt(matcher.group("x"));
                int y = Integer.parseInt(matcher.group("y"));
                boolean found = false;
                if (x >= 0 && x < map.getHeight() && y >= 0 && y < map.getWidth()) {
                    Tile des = map.getSpecificTile(x, y);
                    if (des.getCity() != null && des.getCity().getTile().equals(des)) {
                        if (origin.isMilitaryUnitExists()) {
                            // melee
                            if (origin.getMilitaryUnit().getRangeCombatStrength() == 0) {
                                for (int i = 0; i < origin.getNeighbors().size(); i++) {
                                    if (origin.getNeighbors().get(i).equals(des)) {
                                        found = true;
                                        attackCity(origin, des, des.getCity(), user, scanner);
                                        break;
                                    }
                                }
                            }
                            // ranged
                            else {
                                for (int i = 0; i < origin.getNeighbors().size(); i++) {
                                    if (origin.getNeighbors().get(i).equals(des)) {
                                        found = true;
                                        attackCity(origin, des, des.getCity(), user, scanner);
                                        break;
                                    }
                                    for (int j = 0; j < origin.getNeighbors().get(i).getNeighbors().size(); j++) {
                                        if (origin.getNeighbors().get(i).getNeighbors().get(j).equals(des)) {
                                            found = true;
                                            attackCity(origin, des, des.getCity(), user, scanner);
                                            break;
                                        }
                                    }
                                }
                            }
                            if (!found)
                                System.out.println("this city is not in the range of your unit");
                        } else
                            System.out.println("there is no military unit on this tile");
                    }
                    else
                        System.out.println("there is no city on this tile");
                }
                else
                    System.out.println("invalid coordinates");
            }
            else if (tileInput.equals("delete unit")) {
                if (origin.isMilitaryUnitExists() && origin.isSelectedOne()) {
                    origin.setMilitaryUnitExists(false);
                    origin.setMilitaryUnit(null);
                    origin.setSelectedOne(false);
                    if (origin.isCivilianUnitExists())
                        origin.setSelectedTwo(true);
                }
                else if (origin.isCivilianUnitExists() && origin.isSelectedTwo()) {
                    origin.setCivilianUnitExists(false);
                    origin.setCivilianUnit(null);
                    origin.setSelectedTwo(false);
                    if (origin.isMilitaryUnitExists())
                        origin.setSelectedOne(true);
                }
            }
            else if (tileInput.equals("sleep unit")) {
                if (origin.isMilitaryUnitExists() && origin.isSelectedOne()) {
                    origin.getMilitaryUnit().setSleep(true);
                    if (origin.isCivilianUnitExists()) {
                        origin.setSelectedOne(false);
                        origin.setSelectedTwo(true);
                    }
                }
                else if (origin.isCivilianUnitExists() && origin.isSelectedTwo()) {
                    origin.getCivilianUnit().setSleep(true);
                    if (origin.isMilitaryUnitExists()) {
                        origin.setSelectedOne(true);
                        origin.setSelectedTwo(false);
                    }
                }
            }
            else if (tileInput.equals("alert unit")) {
                if (origin.isMilitaryUnitExists() && origin.isSelectedOne()) {
                    origin.getMilitaryUnit().setAlert(true);
                    if (origin.isCivilianUnitExists()) {
                        origin.setSelectedOne(false);
                        origin.setSelectedTwo(true);
                    }
                }
                else if (origin.isCivilianUnitExists() && origin.isSelectedTwo()) {
                    origin.getCivilianUnit().setAlert(true);
                    if (origin.isMilitaryUnitExists()) {
                        origin.setSelectedOne(true);
                        origin.setSelectedTwo(false);
                    }
                }
            }
            else if (tileInput.equals("pause improving")){
                if (origin.isInProgress()) {
                    Worker worker = (Worker) origin.getCivilianUnit();
                    worker.setWorkingStatus(false);
                }
                else
                    System.out.println("not producing anything right now!");
            }
            else if (tileInput.equals("resume improving")) {
                if (origin.isCivilianUnitExists() && origin.getCivilianUnit().getName().equals("worker")) {
                    Worker worker = (Worker) origin.getCivilianUnit();
                    worker.setWorkingStatus(true);
                }
                else
                    System.out.println("do not have any improvement in queue");
            }
            else
                System.out.println("invalid command");
        }
    }

    private void showImprovements(Tile tile, User user, Scanner scanner) {
        ArrayList<Improvement> improvements = user.getImprovements();
        boolean deleted = true;
        if (tile.getImprovement() != null) {
            System.out.println("your current improvement on this tile is :" + tile.getImprovement().getName());
            System.out.println("you have to first remove the current improvement then you can build something else!");
            deleted = false;
        }
        int index = 1;
        // print possible improvements with detail
        for (Improvement improvement : improvements) {
            System.out.println(index + "- " + improvement.getName() + "\nProduction : " + improvement.getProductionRate() + "\nFood : " + improvement.getFoodRate() + "\nGold : " + improvement.getGoldRate());
            index++;
        }
        boolean road = false;
        for (Technology technology : user.getTechnologies()) {
            if (technology.getName().equals("The Wheel") && !tile.isRoad()) {
                road = true;
                System.out.println("press -build road- to build road on the tile");
                System.out.println("press -build road cheat- to build road on the tile immediately");
            }

        }
        System.out.println("choose an improvement by index to be applied on this tile");
        System.out.println("press \"add (--improvement | -i) (index)\" to build the improvement immediately");
        System.out.println("press <improvement exit> to get out of here");
        String improvementInput;
        while (true) {
            improvementInput = scanner.nextLine();
            if (improvementInput.equals("improvement exit"))
                return;
            if (deleted) {
                if (Pattern.matches("[\\d+]", improvementInput)) {
                    index = Integer.parseInt(improvementInput);
                    if (index <= improvements.size() && index >= 1) {
                        tile.setInProgress(true);
                        Worker worker = (Worker) tile.getCivilianUnit();
                        worker.setRemainingTurnsToComplete(improvements.get(index - 1).getPrice());
                        worker.setWorkingStatus(true);
                        worker.setImprovement(improvements.get(index - 1));
                        worker.setOrdered(true);
                        gameController.userTurnWorker(user);
                        System.out.println("get back to tile page");
                        return;
                    } else
                        System.out.println("invalid number");
                } else if ((matcher = RegexEnums.getMatcher(improvementInput, RegexEnums.ADD_IMPROVEMENT1)) != null ||
                        (matcher = RegexEnums.getMatcher(improvementInput, RegexEnums.ADD_IMPROVEMENT2)) != null) {
                    index = Integer.parseInt(matcher.group("index"));
                    if (index >= 1 && index <= improvements.size()) {
                        tile.setInProgress(true);
                        Worker worker = (Worker) tile.getCivilianUnit();
                        worker.setRemainingTurnsToComplete(1);
                        worker.setWorkingStatus(true);
                        worker.setImprovement(improvements.get(index - 1));
                        worker.setOrdered(true);
                        gameController.userTurnWorker(user);
                        System.out.println("get back to tile page");
                        return;
                    } else
                        System.out.println("invalid number");
                }
                else if (improvementInput.equals("build road") && road) {
                    // later
                    tile.setInProgress(true);
                    Worker worker = (Worker) tile.getCivilianUnit();
                    worker.setRemainingTurnsToComplete(5);
                    worker.setWorkingStatus(true);
                    worker.setOrdered(true);
                }
                else if (improvementInput.equals("build road cheat") && road) {
                    tile.setRoad(true);
                    tile.getCivilianUnit().setOrdered(true);
                    UserPanel.roadNotification(tile, user);
                    System.out.println("get back to the tile page");
                    return;
                }
                else
                    System.out.println("invalid command");
            }
            else if (improvementInput.equals("delete the current")) {
                tile.setImprovement(null);
                System.out.println("improvement deleted successfully!");
                deleted = true;
            }
            else
                System.out.println("delete the current");
        }

    }

    private boolean selectAnotherTile(Tile origin, Scanner scanner, User user, int xOrigin, int yOrigin) {
        int anotherXOrigin = Integer.parseInt(matcher.group("x"));
        int anotherYOrigin = Integer.parseInt(matcher.group("y"));
        if (anotherXOrigin >= 0 && anotherYOrigin >= 0) {
            if (anotherXOrigin == xOrigin && anotherYOrigin == yOrigin) {
                // if the user press again on the tile , change the unit if two exists
                if (origin.isMilitaryUnitExists() && origin.isSelectedOne() && origin.isCivilianUnitExists()) {
                    origin.setSelectedOne(false);
                    origin.setSelectedTwo(true);
                } else if (origin.isCivilianUnitExists() && origin.isSelectedTwo() && origin.isMilitaryUnitExists()) {
                    origin.setSelectedOne(true);
                    origin.setSelectedTwo(false);
                }
                return false;
            } else {
                Tile destination = gameController.findTile(anotherXOrigin, anotherYOrigin);
                if (destination != null) {
                    selectedTile(scanner, destination, anotherXOrigin, anotherYOrigin, user);
                    origin.setSelectedOne(false);
                    origin.setSelectedTwo(false);
                    return true;
                } else
                    System.out.println("invalid tile");
            }
        } else
            System.out.println("invalid coordinates");
        return false;
    }

    // check everything about moving the unit
    private Tile moveUnitConditions(Tile origin, User user, Matcher matcher) {
        if ((origin.getCivilianUnit() != null && origin.getCivilianUnit().getOwner().equals(user)) ||
                (origin.getMilitaryUnit() != null && origin.getMilitaryUnit().getOwner().equals(user))) {
            int xDestination = Integer.parseInt(matcher.group("x"));
            int yDestination = Integer.parseInt(matcher.group("y"));
            if (xDestination >= 0 && yDestination >= 0 && xDestination < map.getHeight() && yDestination < map.getWidth()) {
                Tile destination = map.getSpecificTile(xDestination, yDestination);
                if (destination.getTerrain().isPassable()) {
                    if (origin.isMilitaryUnitExists() && origin.isSelectedOne()) {
                        if (!destination.isMilitaryUnitExists() && destination.getTerrain().isPassable())
                            return moveUnit(origin, destination, origin.getMilitaryUnit(), user, true);
                        else
                            System.out.println("can't move a unit to this tile");
                    }
                    else if (origin.isCivilianUnitExists() && origin.isSelectedTwo()) {
                        if (!destination.isCivilianUnitExists())
                            return moveUnit(origin, destination, origin.getCivilianUnit(), user, false);
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
            System.out.println("there is no unit here or you are not the owner of this unit");
        return null;
    }

    private Tile moveUnit(Tile origin, Tile destination, Unit unit, User user, boolean isMilitary) {
        // create an array list to store all the tiles to destination
        int i = 0;
        ArrayList<Tile> tilesInTheWay = new ArrayList<>();
        Tile tile = origin;
        while ((tile = mapController.bestChoiceAmongNeighbors(tile, destination, isMilitary)) != destination) {
            i++;
            if (tile == null || i > 50) {
                System.out.println("sorry, moving is impossible");
                return origin;
            }
            tilesInTheWay.add(tile);
        }
        tilesInTheWay.add(tile);
        int mp = 0;
        unit.setOrdered(true);
        tile = origin;
        for (Tile value : tilesInTheWay) {
            tileInformation(value);
            if (value.getTerrain().getMovementPrice() > unit.getMP()) {
                gameController.moveUnit(origin, value, unit, isMilitary);
                System.out.println(mp + " movement by unit to get to the destination");
                return tile;
            }
            if (!tile.isRoad())
                mp += value.getTerrain().getMovementPrice();
            unit.setMP(unit.getMP() - value.getTerrain().getMovementPrice());
            tile = value;
        }
        System.out.println("hello");
        gameController.moveUnit(origin, destination, unit, isMilitary);
        System.out.println(mp + " movement by unit to get to the destination");
        return destination;
    }

    private void showPlayers() {
        int index = 1;
        String color;
        ColorsController colorsController = new ColorsController();
        for (User player : players) {
            color = colorsController.getColorOfUser(player);
            System.out.println(index + "- username: " + player.getUsername() + " nickname: " + color + player.getNickname() + Colors.RESET);
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

    //check if tile is valid
    private boolean conditionsForPlaceCity(String input, Tile tile) {
        // neighbors of the tile should be neutral
        for (Tile neighbor : tile.getNeighbors()) {
            if (neighbor.getOwner() != null) {
                System.out.println("a tile has owner here");
                return false;
            }
        }
        if (tile.isCivilianUnitExists() && tile.getCivilianUnit().getName().equals("settler")) {
            if (tile.getCity() == null) {
                if (tile.getOwner() == null) {
                    return true;
                }
                System.out.println("you are in someone's territory");
            } else
                System.out.println("there is already a city here");
        } else
            System.out.println("no settler");
        return false;
    }

    // create city
    private void createCity(Tile tile, User user, String nameOfCity) {
        // completely delete settler
        settlerController.createNewCity(tile.getCivilianUnit(), user, tile, nameOfCity);
        for (Resource foundResource : user.getFoundResources()) {
            if (!foundResource.isAnnounce()){
                System.out.println("You found" + foundResource.getName() + "in this tile.");
                if (!user.getAvailableResources().contains(foundResource)){
                    System.out.println("You should first build" + foundResource.getRequiredImprovement()
                            + "on this tile to use this resource benefits!");
                }
            }
        }
        // remove settler from tile
        mapController.deleteCivilian(tile);
        System.out.println("city located successfully!");
    }

    private void attackCity(Tile origin, Tile destination, City city, User user, Scanner scanner) {
        System.out.println("war panel with city");
        Unit unit = origin.getMilitaryUnit();
        System.out.println("use cheat code -destroy city-");
        System.out.println("press -city war exit- to get out");
        System.out.println("press -ordinary attack- to just attack the city");
        boolean cheat = true;
        String cityCombatInput;
        while (cheat) {
            cityCombatInput = scanner.nextLine();
            if (cityCombatInput.equals("city war exit")) {
                System.out.println("get out of war panel with city");
                cheat = false;
            }
            else if (cityCombatInput.equals("destroy city")) {
                cheat = decideOnWhatToDoWithCity(city, scanner, unit);
                unit.setOrdered(true);
            }
            else if (cityCombatInput.equals("ordinary attack")){
                unit.setOrdered(true);
                if (city.getHP() < unit.getAttackPoint()) {
                    System.out.println("you won, congratulation " + user.getUsername());
                    cheat = decideOnWhatToDoWithCity(city, scanner, unit);
                }
                else {
                    combatController.attackCity(city, unit);
                }
            }
        }

    }

    private boolean decideOnWhatToDoWithCity(City city, Scanner scanner, Unit unit) {
        String cityCombatInput;
        System.out.println("which one do you choose?");
        System.out.println("1- completely destroy city");
        System.out.println("2- annex city");
        System.out.println("please press one of this numbers");
        boolean decide = true;
        while(decide) {
            cityCombatInput = scanner.nextLine();
            if (Pattern.matches("\\d+", cityCombatInput)) {
                int index = Integer.parseInt(cityCombatInput);
                if (index == 1) {
                    combatController.destroyCity(city);
                    decide = false;
                }
                else if (index == 2) {
                    combatController.annexCity(city, unit);
                    decide = false;
                }
                else
                    System.out.println("invalid number");
            }
            else
                System.out.println("invalid command");
        }
        return false;
    }

    public void showMap(User user) {
        System.out.println("user nickname : " + new ColorsController().getColorOfUser(user) + user.getNickname() + Colors.RESET);
        System.out.print("user Happiness : " + user.getHappiness());
        System.out.print("           user UnHappiness : " + user.getUnhappiness());
        System.out.print("           user Food : " + user.getFood());
        System.out.print("           user Gold : " + user.getGold());
        System.out.println("           user Science : " + user.getScience());
        //first top sides of left tiles of game board
        for (int j = 0; j < map.getWidth(); j++)
            System.out.print("   " + mapController.riverFinder(map.getTileBoard()[0][j], 0) + "              ");
        System.out.println();

        //print the game board
        for (int i = 0; i < map.getHeight()/2; i++) {
            leftCoordinatesPlace(i);
            leftOwnerName(i);
            leftTilesUnit(i);
            leftResourceAndTerrain(i);
            rightOwnerName(i);
            leftBottomSides(i);
        }

    }

    private void leftCoordinatesPlace(int i) {

        //Coordinates of left tiles and resource and terrain in right tiles
        for (int j = 0; j < map.getWidth(); j++) {
            if (i != 0) {
                if (j != 0)
                    System.out.print(mapController.getColorOfTile(map.getTileBoard()[2 * i - 1][j - 1])
                        + "  " + Colors.RESET);
                else System.out.print("  ");
                System.out.print(mapController.riverFinder(map.getTileBoard()[2 * i][j], 5)
                        + mapController.getColorOfTile(map.getTileBoard()[2 * i][j]) + leftCoordination(i , j)
                        + Colors.RESET + mapController.riverFinder(map.getTileBoard()[2 * i][j], 1)
                        + mapController.getColorOfTile(map.getTileBoard()[2 * i - 1][j]) + "   "
                        + mapController.tileResource(map.getTileBoard()[2 * i - 1][j], false)
                        + "   " + mapController.tileFeature(map.getTileBoard()[2 * i - 1][j], false)
                        + "  " + Colors.RESET);
            } else System.out.print("  " + mapController.riverFinder(map.getTileBoard()[2 * i][j], 5)
                    + mapController.getColorOfTile(map.getTileBoard()[2 * i][j])
                    + leftCoordination(0 , j) + Colors.RESET
                    + mapController.riverFinder(map.getTileBoard()[2 * i][j], 1) + "             ");
        }
        if (i != 0) System.out.println(mapController.getColorOfTile(map.getTileBoard()[2 * i - 1][map.getWidth() - 1])
                + "  " + Colors.RESET + mapController.riverFinder(map.getTileBoard()[2 * i - 1][map.getWidth() - 1], 2));
        else System.out.println();

    }

    private String leftCoordination(int i, int j){
        if (2 * i < 10 && j < 10) return "  [0" + 2 * i + ",0" + j + "]  ";
        else if (2 * i > 9 && j < 10) return "  [" + 2 * i + ",0" + j + "]  ";
        else if (2 * i > 9) return "  [" + 2 * i + "," + j + "]  ";
        else return "  [0" + 2 * i + "," + j + "]  ";
    }

    private void leftOwnerName(int i) {
        String ANSI_COLOR;

        //owner name and color of left tiles and right Improvement
        for (int j = 0; j < map.getWidth(); j++) {
            ANSI_COLOR = mapController.getColorOfTileOwner(map.getTileBoard()[2 * i][j]);
            if (i != 0 && j != 0)
                System.out.print(mapController.getColorOfTile(map.getTileBoard()[2 * i - 1][j - 1]));
            System.out.print(" " + Colors.RESET + mapController.riverFinder(map.getTileBoard()[2 * i][j], 5)
                    + mapController.getColorOfTile(map.getTileBoard()[2 * i][j]) + "     " + ANSI_COLOR
                    + mapController.getColorOfTile(map.getTileBoard()[2 * i][j])
                    + mapController.tileOwner(map.getTileBoard()[2 * i][j])
                    + mapController.getColorOfTile(map.getTileBoard()[2 * i][j]) + "     " + Colors.RESET
                    + mapController.riverFinder(map.getTileBoard()[2 * i][j], 1));
            if (i != 0)
                System.out.print(mapController.getColorOfTileOwner(map.getTileBoard()[2 * i - 1][j])
                        + mapController.getColorOfTile(map.getTileBoard()[2 * i - 1][j])
                        + "     " + mapController.tileImprovement(map.getTileBoard()[2 * i - 1][j])
                        + "    " + Colors.RESET);
            else System.out.print("            ");
        }
        if (i != 0) System.out.println(mapController.getColorOfTile(map.getTileBoard()[2 * i - 1][map.getWidth() - 1])
                + " " + Colors.RESET + mapController.riverFinder(map.getTileBoard()[2 * i][0], 2));
        else System.out.println();

    }

    private void leftTilesUnit(int i){
        String ANSI_COLOR;

        //units on the left tiles and top sides of right tiles
        for (int j = 0; j < map.getWidth(); j++) {
            ANSI_COLOR = mapController.getColorOfTileOwner(map.getTileBoard()[2 * i][j]);
            System.out.print(mapController.riverFinder(map.getTileBoard()[2 * i][j], 5)
                    + mapController.getColorOfTile(map.getTileBoard()[2 * i][j]) + "    "
                    + ANSI_COLOR + mapController.getColorOfTile(map.getTileBoard()[2 * i][j])
                    + mapController.civilianUnit(map.getTileBoard()[2 * i][j])
                    + "   " + ANSI_COLOR + mapController.getColorOfTile(map.getTileBoard()[2 * i][j])
                    + mapController.militaryUnit(map.getTileBoard()[2 * i][j])
                    + mapController.getColorOfTile(map.getTileBoard()[2 * i][j]) + "    "
                    + Colors.RESET + mapController.riverFinder(map.getTileBoard()[2 * i][j], 1)
            );
            if (i != 0) System.out.print(mapController.riverFinder(map.getTileBoard()[2 * i - 1][j], 3));
            else System.out.print(mapController.riverFinder(map.getTileBoard()[1][j], 0));
        }
        if (i != 0) System.out.println(mapController.riverFinder(map.getTileBoard()[2 * i][map.getWidth() - 1], 2));
        else System.out.println();
    }

    private void leftResourceAndTerrain(int i) {
        //resource and terrain in left tiles and Coordinates of right tiles
        for (int j = 0; j < map.getWidth(); j++) {
            if (i != map.getHeight() / 2 - 1)
                System.out.print(mapController.riverFinder(map.getTileBoard()[2 * i][j], 4)
                        + mapController.getColorOfTile(map.getTileBoard()[2 * i][j]) + "   "
                        + mapController.tileResource(map.getTileBoard()[2 * i][j], false)
                        + "   " + mapController.tileFeature(map.getTileBoard()[2 * i][j], false)
                        + "    " + Colors.RESET + mapController.riverFinder(map.getTileBoard()[2 * i][j], 2)
                        + mapController.getColorOfTile(map.getTileBoard()[2 * i + 1][j])
                        + rightCoordination(i , j) + Colors.RESET);
            else System.out.print(mapController.riverFinder(map.getTileBoard()[2 * i][j], 4)
                    + mapController.getColorOfTile(map.getTileBoard()[2 * i][j])
                    + "   " + mapController.tileResource(map.getTileBoard()[2 * i][j], false)
                    + "   " + mapController.tileFeature(map.getTileBoard()[2 * i][0], false) + "    "
                    + Colors.RESET + mapController.riverFinder(map.getTileBoard()[2 * i][j], 2) + "           ");
        }
        if (i != map.getHeight() / 2 - 1) System.out.println(mapController.riverFinder(map.getTileBoard()[2 * i + 1][map.getWidth() - 1], 1));
        else System.out.println();

    }

    private String rightCoordination(int i, int j){
        if (2 * i + 1 < 10 && j < 10) return "  [0" + (2 * i + 1) + ",0" + j + "]  ";
        else if (2 * i + 1 > 9 && j < 10) return "  [" + (2 * i + 1) + ",0" + j + "]  ";
        else if (2 * i + 1 > 9) return "  [" + (2 * i + 1) + "," + j + "]  ";
        else return "  [0" + (2 * i + 1) + "," + j + "]  ";
    }

    private void rightOwnerName(int i) {
        String ANSI_COLOR;
        String ANSI_COLOR2;
        //owner name and color of right tiles and left Improvement
        for (int j = 0; j < map.getWidth(); j++) {
            ANSI_COLOR = mapController.getColorOfTileOwner(map.getTileBoard()[2 * i][j]);
            ANSI_COLOR2 = mapController.getColorOfTileOwner(map.getTileBoard()[2 * i + 1][j]);;
            if (i != map.getHeight() / 2 - 1) {
                if (j != 0) System.out.print(mapController.getColorOfTile(map.getTileBoard()[2 * i + 1][j - 1]));
                System.out.print(" " + Colors.RESET + mapController.riverFinder(map.getTileBoard()[2 * i][j], 4)
                        + ANSI_COLOR + mapController.getColorOfTile(map.getTileBoard()[2 * i][j])
                        + "     " + mapController.tileImprovement(map.getTileBoard()[2 * i][j])
                        + "     " + Colors.RESET + mapController.riverFinder(map.getTileBoard()[2 * i][j], 2)
                        + ANSI_COLOR2 + mapController.getColorOfTile(map.getTileBoard()[2 * i + 1][j])
                        + "     " + mapController.getColorOfTile(map.getTileBoard()[2 * i + 1][j])
                        + mapController.tileOwner(map.getTileBoard()[2 * i + 1][j])
                        + mapController.getColorOfTile(map.getTileBoard()[2 * i + 1][j]) + "    " + Colors.RESET);
            } else System.out.print(" " + mapController.riverFinder(map.getTileBoard()[2 * i][j], 4)
                    + ANSI_COLOR + mapController.getColorOfTile(map.getTileBoard()[2 * i][j])
                    + "     " + mapController.tileImprovement(map.getTileBoard()[2 * i][j])
                    + "     " + Colors.RESET + mapController.riverFinder(map.getTileBoard()[2 * i][j], 2)
                    + "            ");
        }
        if (i != map.getHeight() / 2 - 1) System.out.println(mapController.getColorOfTile(map.getTileBoard()[2 * i + 1][map.getWidth() - 1])
                + " " + Colors.RESET + mapController.riverFinder(map.getTileBoard()[2 * i + 1][map.getWidth() - 1], 1));
        else System.out.println();

    }

    private void leftBottomSides(int i) {
        String ANSI_COLOR = Colors.WHITE;

        //bottom sides of left tiles and units on the right tiles
        for (int j = 0; j < map.getWidth(); j++) {
            if (i != map.getHeight() / 2 - 1) ANSI_COLOR = mapController.getColorOfTileOwner(map.getTileBoard()[2 * i + 1][j]);

            if (i != map.getHeight() / 2 - 1) {
                if (j != 0) System.out.print(mapController.getColorOfTile(map.getTileBoard()[2 * i + 1][j - 1]));
                System.out.print("  " + Colors.RESET + mapController.riverFinder(map.getTileBoard()[2 * i][j], 4)
                        + mapController.riverFinder(map.getTileBoard()[2 * i][j], 3)
                        + mapController.riverFinder(map.getTileBoard()[2 * i][j], 2)
                        + mapController.getColorOfTile(map.getTileBoard()[2 * i + 1][j])
                        + "    " + ANSI_COLOR + mapController.getColorOfTile(map.getTileBoard()[2 * i + 1][j])
                        + mapController.civilianUnit(map.getTileBoard()[2 * i + 1][0])
                        + mapController.getColorOfTile(map.getTileBoard()[2 * i + 1][j])
                        + "   " + ANSI_COLOR + mapController.getColorOfTile(map.getTileBoard()[2 * i + 1][j])
                        + mapController.militaryUnit(map.getTileBoard()[2 * i + 1][j]) + "  " + Colors.RESET);
            } else
                System.out.print("  " + mapController.riverFinder(map.getTileBoard()[2 * i][j], 4)
                        + mapController.riverFinder(map.getTileBoard()[2 * i][j], 3)
                        + mapController.riverFinder(map.getTileBoard()[2 * i][j], 2) + "             ");
        }
        if (i != map.getHeight() / 2 - 1)
            System.out.println(mapController.getColorOfTile(map.getTileBoard()[2 * i + 1][map.getWidth() - 1])
                + "  " + Colors.RESET + mapController.riverFinder(map.getTileBoard()[2 * i + 1][map.getWidth() - 1], 1));
        else System.out.println();

    }

    private void tileInformation(Tile tile) {
        if (tile.getOwner() != null)
            System.out.println("Owner : " + tile.getOwner().getUsername());
        if (tile.getCity() != null)
            System.out.println("City : " + tile.getCity().getName());
        System.out.println("Coordinate : -x " + tile.getX() + " -y " + tile.getY());
        if (tile.isMilitaryUnitExists() && tile.isSelectedOne())
            System.out.println("military unit selected");
        if (tile.isCivilianUnitExists() && tile.isSelectedTwo())
            System.out.println("civilian unit selected");
        tileDetails(tile);
    }

    static void tileDetails(Tile tile) {
        System.out.println("Terrain : " + tile.getTerrain().getName());
        if (tile.getFeature() != null)
            System.out.println("Feature : " + tile.getFeature().getName());
        if (tile.getResource() != null)
            System.out.println("Resource : " + tile.getResource().getName() + " of type : " + tile.getResource().getResourceType());
        if (tile.getImprovement() != null)
            System.out.println("Improvement : " + tile.getImprovement().getName());
        if (tile.isMilitaryUnitExists()) {
            System.out.println("Military unit exists here :");
            Unit unit = tile.getMilitaryUnit();
            System.out.println("Name : " + unit.getName());
            System.out.println("HP : " + unit.getHP());
            System.out.println("MP : " + unit.getMP());
            System.out.println("Combat strength : " + unit.getCombatStrength());
            System.out.println("Ranged combat strength : " + unit.getRangeCombatStrength());
            System.out.println("Level : " + unit.getLevel());
        }
        if (tile.isCivilianUnitExists()) {
            System.out.println("Civilian unit exists here :");
            Unit unit = tile.getCivilianUnit();
            System.out.println("Name : " + unit.getName());
            System.out.println("HP : " + unit.getHP());
            System.out.println("MP : " + unit.getMP());
            System.out.println("Combat strength : " + unit.getCombatStrength());
            System.out.println("Ranged combat strength : " + unit.getRangeCombatStrength());
            System.out.println("Level : " + unit.getLevel());
        }
    }

}

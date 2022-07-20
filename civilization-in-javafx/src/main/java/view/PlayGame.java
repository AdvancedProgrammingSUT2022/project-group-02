package view;

import controller.*;
import view.enums.Colors;
import view.enums.RegexEnums;
import model.*;

import java.util.*;
import java.util.regex.*;

public class PlayGame {
    private final ArrayList<User> players;
    private Maps map;
    private Matcher matcher;
    private int height;
    private int width;
    private ArrayList<Tile> firstTurnsSettlers;
    private CityMenu cityMenu;
    private ResearchMenu researchMenu;
    private int[][] graph;
    private ArrayList<Technology> technologies;

    private GameController gameController;
    private MapController mapController;
    private TechController techController;
    private UnitController unitController;
    private UsersController usersController;
    private SettlerController settlerController;
    private CombatController combatController;


    public PlayGame(ArrayList<User> players, Maps map, int[][] graph, ArrayList<Technology> technologies) {
        this.players = players;
        this.map = map;
        this.height = 26;
        this.width = 80;
        this.graph = graph;
        this.technologies = technologies;
        gameController = GameController.getInstance(players, map);
        mapController = MapController.getInstance(map);
        techController = TechController.getInstance();
        TechController.getInstance().setTechnologies(technologies);
        TechController.getInstance().setTechnologiesGraph(graph);
        unitController = UnitController.getInstance();
        usersController = UsersController.getInstance();
        settlerController = SettlerController.getInstance();
        combatController = CombatController.getInstance();
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

    public void run(Scanner scanner) {
        cityMenu = new CityMenu(players, mapController, gameController);
        researchMenu = new ResearchMenu(techController, gameController);
        UserPanel userPanel = new UserPanel(gameController);
        manPlayGame();
        String input;
        int role = 0;
        firstTurnsSettlers = mapController.firstSetOfSettlers(players);
        int turn = 1;
        gameController.assignNeighbor(mapController);
        boolean nextTurn = true;
        while (true) {
            User user = players.get(role);
            unitController.repairMovementPoint(user);
            String color = new ColorsController().getColorOfUser(user);
            System.out.println("it's " + color + user.getNickname() + Colors.RESET + " turn");
            // handle production turn in cities and research turn of user
            //pre turn actions
            gameController.cityTurnProducts(user);
            gameController.userTurnResearch(user);
            gameController.userTurnWorker(user);
            gameController.increaseCitizens(user);
            gameController.citiesIncome(user);
            gameController.usersIncomeHandling(user , map);
            gameController.userHappiness(user);
            gameController.makeAllUnOrdered(user);
            gameController.foundCity(user);
            gameController.moveTravelingUnits(user, this);
            gameController.foundRuin(user);

            while (nextTurn) {

                input = scanner.nextLine();
                if (input.equals("game exit"))
                    return;

                else if (input.trim().startsWith("next turn")) {
                    Request request = new Request();
                    request.setMenu("play game");
                    request.setAction("next turn");
                    HashMap<String, Object> parameters = new HashMap<>();
                    parameters.put("username", user.getUsername());
                    if (input.trim().equals("next turn")) {
                        parameters.put("cheat", Boolean.FALSE);
                    }
                    else if (input.trim().equals("next turn --force")) {
                        parameters.put("cheat", Boolean.TRUE);
                    }
                    request.setParameters(parameters);
                    Response response = NetworkController.getInstance().sendRequest(request);
                    System.out.println(response.getMessage());
                    if ((Boolean)response.getParameters().get("next turn"))
                        nextTurn = false;
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
                    Request request = new Request();
                    request.setMenu("play game");
                    request.setAction("increase turn");
                    HashMap<String, Object> parameters = new HashMap<>();
                    parameters.put("username", user.getUsername());
                    parameters.put("amount", amount);
                    request.setParameters(parameters);
                    Response response = NetworkController.getInstance().sendRequest(request);
                    System.out.println(response.getMessage());
                }
                else if ((matcher = RegexEnums.getMatcher(input, RegexEnums.INCREASE_GOLD1)) != null ||
                        (matcher = RegexEnums.getMatcher(input, RegexEnums.INCREASE_GOLD2)) != null) {
                    int amount = Integer.parseInt(matcher.group("amount"));
                    Request request = new Request();
                    request.setMenu("play game");
                    request.setAction("increase gold");
                    HashMap<String, Object> parameters = new HashMap<>();
                    parameters.put("username", user.getUsername());
                    parameters.put("amount", amount);
                    request.setParameters(parameters);
                    Response response = NetworkController.getInstance().sendRequest(request);
                    System.out.println(response.getMessage());
                }
                else if((matcher = RegexEnums.getMatcher(input, RegexEnums.INCREASE_FOOD)) != null) {

                    int amount = Integer.parseInt(matcher.group("amount"));
                    Request request = new Request();
                    request.setMenu("play game");
                    request.setAction("increase food");
                    HashMap<String, Object> parameters = new HashMap<>();
                    parameters.put("username", user.getUsername());
                    parameters.put("amount", amount);
                    request.setParameters(parameters);
                    Response response = NetworkController.getInstance().sendRequest(request);
                    System.out.println(response.getMessage());

                }else if((matcher = RegexEnums.getMatcher(input, RegexEnums.INCREASE_FAITH)) != null){

                    int amount = Integer.parseInt(matcher.group("amount"));
                    Request request = new Request();
                    request.setMenu("play game");
                    request.setAction("increase faith");
                    HashMap<String, Object> parameters = new HashMap<>();
                    parameters.put("username", user.getUsername());
                    parameters.put("amount", amount);
                    request.setParameters(parameters);
                    Response response = NetworkController.getInstance().sendRequest(request);
                    System.out.println(response.getMessage());

                }else if((matcher = RegexEnums.getMatcher(input, RegexEnums.INCREASE_SCIENCE)) != null){

                    int amount = Integer.parseInt(matcher.group("amount"));
                    Request request = new Request();
                    request.setMenu("play game");
                    request.setAction("increase science");
                    HashMap<String, Object> parameters = new HashMap<>();
                    parameters.put("username", user.getUsername());
                    parameters.put("amount", amount);
                    request.setParameters(parameters);
                    Response response = NetworkController.getInstance().sendRequest(request);
                    System.out.println(response.getMessage());

                }else if((matcher = RegexEnums.getMatcher(input, RegexEnums.INCREASE_CAPITAL_CITIZENS)) != null){

                    int amount = Integer.parseInt(matcher.group("amount"));
                    Request request = new Request();
                    request.setMenu("play game");
                    request.setAction("increase capital citizens");
                    HashMap<String, Object> parameters = new HashMap<>();
                    parameters.put("username", user.getUsername());
                    parameters.put("amount", amount);
                    request.setParameters(parameters);
                    Response response = NetworkController.getInstance().sendRequest(request);
                    System.out.println(response.getMessage());

                }else if((matcher = RegexEnums.getMatcher(input, RegexEnums.INCREASE_CAPITAL_DEFENCE)) != null){

                    int amount = Integer.parseInt(matcher.group("amount"));
                    Request request = new Request();
                    request.setMenu("play game");
                    request.setAction("increase capital defence");
                    HashMap<String, Object> parameters = new HashMap<>();
                    parameters.put("username", user.getUsername());
                    parameters.put("amount", amount);
                    request.setParameters(parameters);
                    Response response = NetworkController.getInstance().sendRequest(request);
                    System.out.println(response.getMessage());

                }else if((matcher = RegexEnums.getMatcher(input, RegexEnums.INCREASE_CULTURE)) != null){
                    int amount = Integer.parseInt(matcher.group("amount"));

                    Request request = new Request();
                    request.setMenu("play game");
                    request.setAction("increase culture");
                    HashMap<String, Object> parameters = new HashMap<>();
                    parameters.put("username", user.getUsername());
                    parameters.put("amount", amount);
                    request.setParameters(parameters);
                    Response response = NetworkController.getInstance().sendRequest(request);
                    System.out.println(response.getMessage());

                }else if((matcher = RegexEnums.getMatcher(input, RegexEnums.INCREASE_HAPPINESS)) != null){
                    int amount = Integer.parseInt(matcher.group("amount"));

                    Request request = new Request();
                    request.setMenu("play game");
                    request.setAction("increase culture");
                    HashMap<String, Object> parameters = new HashMap<>();
                    parameters.put("username", user.getUsername());
                    parameters.put("amount", amount);
                    request.setParameters(parameters);
                    Response response = NetworkController.getInstance().sendRequest(request);
                    System.out.println(response.getMessage());

                }else if((matcher = RegexEnums.getMatcher(input, RegexEnums.DECREASE_RESEARCH_TURN_LEFT)) != null){
                    int amount = Integer.parseInt(matcher.group("amount"));

                    Request request = new Request();
                    request.setMenu("play game");
                    request.setAction("decrease research turn");
                    HashMap<String, Object> parameters = new HashMap<>();
                    parameters.put("username", user.getUsername());
                    parameters.put("amount", amount);
                    request.setParameters(parameters);
                    Response response = NetworkController.getInstance().sendRequest(request);
                    System.out.println(response.getMessage());
                }
                // selecting tile
                else if ((matcher = RegexEnums.getMatcher(input, RegexEnums.SELECT_TILE1)) != null ||
                        (matcher = RegexEnums.getMatcher(input, RegexEnums.SELECT_TILE2)) != null) {
                    int xOrigin = Integer.parseInt(matcher.group("x"));
                    int yOrigin = Integer.parseInt(matcher.group("y"));

                    Request request = new Request();
                    request.setMenu("play game");
                    request.setAction("select tile");
                    HashMap<String, Object> parameters = new HashMap<>();
                    parameters.put("x", xOrigin);
                    parameters.put("y", yOrigin);
                    request.setParameters(parameters);
                    Response response = NetworkController.getInstance().sendRequest(request);
                    System.out.println(response.getMessage());
                    if (response.getStatusCode().equals("200")) {
                        Tile origin = map.getSpecificTile(xOrigin, yOrigin);
                        selectedTile(scanner, origin, user);
                    }
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
            user.setTurns(turn);
            if (role >= players.size())
                role = 0;
            nextTurn = true;
        }
    }


    public void selectedTile(Scanner scanner, Tile origin, User user) {

        System.out.println("you have selected a tile with -x " + origin.getX() + " -y " + origin.getY());
        origin.setSelectedOne(false);
        origin.setSelectedTwo(false);
        if (origin.isMilitaryUnitExists())
            origin.setSelectedOne(true);
        else if (origin.isCivilianUnitExists())
            origin.setSelectedTwo(true);
        Request request;
        String tileInput;
        while (true) {

            request = new Request();
            request.setMenu("tile menu");

            tileInput = scanner.nextLine();
            if (tileInput.equals("tile exit")) {
                System.out.println("get out of tile");
                return;
            }

            else if ((matcher = RegexEnums.getMatcher(tileInput, RegexEnums.SELECT_TILE1)) != null ||
                    (matcher = RegexEnums.getMatcher(tileInput, RegexEnums.SELECT_TILE2)) != null) {
                if (selectAnotherTile(origin, scanner, user))
                    return;
            }
            // move the unit in this tile to destination
            else if ((matcher = RegexEnums.getMatcher(tileInput, RegexEnums.MOVE1)) != null ||
                    (matcher = RegexEnums.getMatcher(tileInput, RegexEnums.MOVE2)) != null) {

                request.setAction("move unit");
                HashMap<String, Object> parameters = new HashMap<>();
                int xDestination = Integer.parseInt(matcher.group("x"));
                int yDestination = Integer.parseInt(matcher.group("y"));
                parameters.put("xDestination", xDestination);
                parameters.put("yDestination", yDestination);
                request.setParameters(parameters);
                Response response = NetworkController.getInstance().sendRequest(request);
                System.out.println(response.getMessage());
                if (!(Boolean)response.getParameters().get("arrived")) {
                    //it's not over, wait till next turn to move to destination
                }
                /*
                Tile tile = moveUnitConditions(origin, user, matcher);
                if (tile != null && !tile.equals(origin)) {
                    selectedTile(scanner, tile, user);
                    return;
                }
                */
            }
            // order settler to place city
            else if ((matcher = RegexEnums.getMatcher(tileInput, RegexEnums.CITY1)) != null ||
                    (matcher = RegexEnums.getMatcher(tileInput, RegexEnums.CITY2)) != null) {

                int xDestination = origin.getX();
                int yDestination = origin.getY();

                request.setAction("place city");
                HashMap<String, Object> parameters = new HashMap<>();
                parameters.put("xDestination", xDestination);
                parameters.put("yDestination", yDestination);
                parameters.put("username", user.getUsername());
                parameters.put("name", matcher.group("city"));

                request.setParameters(parameters);
                Response response = NetworkController.getInstance().sendRequest(request);
                System.out.println(response.getMessage());
            }
            // order worker to improve the tile
            else if (tileInput.trim().equals("show possible improvements")) {
                if (origin.isCivilianUnitExists() &&
                        origin.getCivilianUnit().getOwner().equals(user) &&
                        origin.getCivilianUnit().getName().equals("worker")) {
                    if (!origin.isLooted())
                        showImprovements(origin, user, scanner);
                    else
                        System.out.println("looted!");
                }
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

                request.setAction("attack city");
                HashMap<String, Object> parameters = new HashMap<>();
                parameters.put("username", user.getUsername());
                parameters.put("xOrigin", origin.getX());
                parameters.put("yOrigin", origin.getY());
                parameters.put("xDestination", x);
                parameters.put("yDestination", y);
                request.setParameters(parameters);
                Response response = NetworkController.getInstance().sendRequest(request);
                System.out.println(response.getMessage());
                if ((boolean)response.getParameters().get("ruined")) {
                    //the city has been destroyed , decision on what to do
                    parameters = new HashMap<>();
                    request = new Request();
                    request.setMenu("tile menu");
                    request.setAction("decision on what to do with city");
                    decisionOnWhatToDoWithCity(scanner, parameters);
                    parameters.put("xOrigin", origin.getX());
                    parameters.put("yOrigin", origin.getY());
                    parameters.put("xDestination", x);
                    parameters.put("yDestination", y);
                    request.setParameters(parameters);

                    response = NetworkController.getInstance().sendRequest(request);
                    System.out.println(response.getMessage());

                }
            }

            else if (((matcher = RegexEnums.getMatcher(tileInput, RegexEnums.ATTACK_UNIT1)) != null ||
                    (matcher = RegexEnums.getMatcher(tileInput, RegexEnums.ATTACK_UNIT2)) != null) && origin.isMilitaryUnitExists()) {
                int x = Integer.parseInt(matcher.group("x"));
                int y = Integer.parseInt(matcher.group("y"));
                if (x >= 0 && x < map.getWidth() && y >= 0 && y < map.getHeight()) {
                    Tile des = map.getSpecificTile(x, y);
                    if (mapController.findDistance(origin, des) == 1 || (mapController.findDistance(origin, des) == 2 && origin.getMilitaryUnit().getRangeCombatStrength() > 0)) {
                        if (des.isMilitaryUnitExists() && !des.getMilitaryUnit().getOwner().equals(user)) {
                            //todo : if user is not in war with the owner of unit , ask him if he want to start a war
                            if (!user.getEnemies().contains(des.getMilitaryUnit().getOwner())) {
                                UserPanel.sendNotificationToInvader(user, des.getMilitaryUnit().getOwner());
                            }
                            CombatController.getInstance().attackUnit(origin.getMilitaryUnit(), des.getMilitaryUnit());

                        } else if (des.isCivilianUnitExists() && !des.getCivilianUnit().getOwner().equals(user)) {
                            //todo : if user is not in war with the owner of unit , ask him if he want to start a war
                            if (!user.getEnemies().contains(des.getCivilianUnit().getOwner())) {
                                UserPanel.sendNotificationToDefender(user, des.getCivilianUnit().getOwner());
                            }
                            CombatController.getInstance().annexCivilianUnit(user, des.getCivilianUnit());
                            System.out.println("you own this unit now!");
                        } else
                            System.out.println("there is no unit on this tile");
                    }
                    else
                        System.out.println("this tile is not in your range");
                }
                else
                    System.out.println("invalid coordinates");
            }

            else if (tileInput.equals("delete unit")) {
                if (origin.isMilitaryUnitExists() && origin.isSelectedOne() && origin.getMilitaryUnit().getOwner().equals(user)) {
                    origin.setMilitaryUnitExists(false);
                    origin.getMilitaryUnit().getOwner().removeUnit(origin.getMilitaryUnit());
                    origin.setMilitaryUnit(null);
                    origin.setSelectedOne(false);
                    if (origin.isCivilianUnitExists())
                        origin.setSelectedTwo(true);
                    System.out.println("unit deleted successfully!");
                }
                else if (origin.isCivilianUnitExists() && origin.isSelectedTwo() && origin.getCivilianUnit().getOwner().equals(user)) {
                    origin.setCivilianUnitExists(false);
                    origin.getCivilianUnit().getOwner().removeUnit(origin.getCivilianUnit());
                    origin.setCivilianUnit(null);
                    origin.setSelectedTwo(false);
                    if (origin.isMilitaryUnitExists())
                        origin.setSelectedOne(true);
                    System.out.println("unit deleted successfully!");
                }
            }
            else if (tileInput.equals("sleep unit")) {
                if (origin.isMilitaryUnitExists() && origin.isSelectedOne() && origin.getMilitaryUnit().getOwner().equals(user)) {
                    origin.getMilitaryUnit().setSleep(true);
                    if (origin.isCivilianUnitExists()) {
                        origin.setSelectedOne(false);
                        origin.setSelectedTwo(true);
                    }
                    System.out.println("unit sleep successfully!");
                }
                else if (origin.isCivilianUnitExists() && origin.isSelectedTwo() && origin.getCivilianUnit().getOwner().equals(user)) {
                    origin.getCivilianUnit().setSleep(true);
                    if (origin.isMilitaryUnitExists()) {
                        origin.setSelectedOne(true);
                        origin.setSelectedTwo(false);
                    }
                    System.out.println("unit sleep successfully!");
                }
            }
            else if (tileInput.equals("alert unit")) {
                if (origin.isMilitaryUnitExists() && origin.isSelectedOne() && origin.getMilitaryUnit().getOwner().equals(user)) {
                    origin.getMilitaryUnit().setAlert(true);
                    if (origin.isCivilianUnitExists()) {
                        origin.setSelectedOne(false);
                        origin.setSelectedTwo(true);
                    }
                    System.out.println("unit alerted successfully!");
                }
                else if (origin.isCivilianUnitExists() && origin.isSelectedTwo() && origin.getCivilianUnit().getOwner().equals(user)) {
                    origin.getCivilianUnit().setAlert(true);
                    if (origin.isMilitaryUnitExists()) {
                        origin.setSelectedOne(true);
                        origin.setSelectedTwo(false);
                    }
                    System.out.println("unit alerted successfully!");
                }
            }
            else if (tileInput.equals("garrison unit")) {
                if (origin.getCity() != null) {
                    if (origin.getCity().getTile().equals(origin)) {
                        if (origin.isMilitaryUnitExists() && origin.isSelectedOne() && origin.getMilitaryUnit().getOwner().equals(user)) {
                            Unit unit = origin.getMilitaryUnit();
                            unit.setAlert(true);
                            unit.setOrdered(true);
                            origin.getCity().setHP(origin.getCity().getHP() * 2);
                            System.out.println("assigned to defend city successfully!");
                        }
                        else if (origin.isCivilianUnitExists() && origin.isSelectedTwo() && origin.getCivilianUnit().getOwner().equals(user)) {
                            Unit unit = origin.getCivilianUnit();
                            unit.setAlert(true);
                            unit.setOrdered(true);
                            origin.getCity().setHP(origin.getCity().getHP() * 2);
                            System.out.println("assigned to defend city successfully!");
                        }
                        else
                            System.out.println("no unit here");
                    }
                    else
                        System.out.println("there is no city on this tile");
                }
                else
                    System.out.println("this tile do not belong to any user");
            }
            else if (tileInput.equals("fortify unit")) {
                if (origin.isMilitaryUnitExists() && origin.isSelectedOne() && origin.getMilitaryUnit().getOwner().equals(user)) {
                    if (origin.getMilitaryUnit().getHP() != origin.getMilitaryUnit().getTotalHealth()) {
                        origin.getMilitaryUnit().setFortify(true);
                        System.out.println("assigned to fortify successfully!");
                    }
                    else
                        System.out.println("no need to fortify");
                }
                else if (origin.isCivilianUnitExists() && origin.isSelectedTwo() && origin.getCivilianUnit().getOwner().equals(user)) {
                    if (origin.getCivilianUnit().getHP() != origin.getCivilianUnit().getTotalHealth()) {
                        origin.getCivilianUnit().setFortify(true);
                        System.out.println("assigned to fortify successfully!");
                    }
                    else
                        System.out.println("no need to fortify");
                }
                else
                    System.out.println("no unit here");
            }
            else if (tileInput.equals("pillage unit")) {
                if (origin.isMilitaryUnitExists() && origin.isSelectedOne() && origin.getMilitaryUnit().getOwner().equals(user)) {
                    if (origin.getOwner() != null && !origin.getOwner().equals(user) && origin.getImprovement() != null) {
                        origin.setLooted(true);
                        System.out.println("pillaged successfully!");
                    }
                    else
                        System.out.println("it is not proper for pillaging");
                }
                else
                    System.out.println("none of your military units are here!");
            }
            else if (tileInput.equals("repair improvement")) {
                if (origin.isCivilianUnitExists() && origin.getCivilianUnit().getName().equals("worker") && origin.getOwner().equals(user) && origin.getImprovement() != null && origin.isLooted()) {
                    origin.setInProgress(true);
                    Worker worker = (Worker) origin.getCivilianUnit();
                    worker.setWorkingStatus(true);
                    worker.setRemainingTurnsToComplete(origin.getImprovement().getPrice());
                    worker.setImprovement(origin.getImprovement());
                    origin.setImprovement(null);
                    System.out.println("will be repaired as soon as possible!");
                }
                System.out.println("impossible to repair");
            }
            else if (tileInput.equals("repair improvement cheat")) {
                if (origin.isCivilianUnitExists() && origin.getCivilianUnit().getName().equals("worker") && origin.getOwner().equals(user) && origin.getImprovement() != null && origin.isLooted()) {
                    origin.setLooted(false);
                    System.out.println("repaired successfully!");
                }
                else
                    System.out.println("impossible to repair");
            }
            else if (tileInput.equals("pause improving")){
                if (origin.isInProgress() && origin.getCivilianUnit().getOwner().equals(user)) {
                    Worker worker = (Worker) origin.getCivilianUnit();
                    worker.setWorkingStatus(false);
                }
                else
                    System.out.println("not producing anything right now!");
            }
            else if (tileInput.equals("resume improving")) {
                if (origin.isCivilianUnitExists() && origin.getCivilianUnit().getName().equals("worker") && origin.getCivilianUnit().getOwner().equals(user)) {
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

    private boolean selectAnotherTile(Tile origin, Scanner scanner, User user) {
        int xOrigin = origin.getX();
        int yOrigin = origin.getY();
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
                    selectedTile(scanner, destination, user);
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

    private void decisionOnWhatToDoWithCity(Scanner scanner, HashMap<String, Object> parameters) {
        System.out.println("which one do you choose?");
        System.out.println("1- completely destroy city");
        System.out.println("2- annex city");
        System.out.println("please press one of this numbers");
        Request request = new Request();
        request.setMenu("tile menu");
        request.setAction("what to do with city");
        String input;
        while (true) {
            input = scanner.nextLine();
            if (Pattern.matches("\\d+", input)) {
                int index = Integer.parseInt(input);
                switch (index) {
                    case 1 -> {
                        parameters.put("index", 1);
                        System.out.println();
                        return;
                    }
                    case 2 -> {
                        parameters.put("index", 2);
                        return;
                    }
                    default -> System.out.println("invalid number");
                }
            }
            else
                System.out.println("invalid command");
        }
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

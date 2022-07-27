package view;

import controller.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
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
        mapController.firstSetOfSettlers(players);
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
//            gameController.moveTravelingUnits(user, this);
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
                request.setAction("attack unit");
                HashMap<String, Object> parameters = new HashMap<>();
                parameters.put("username", user.getUsername());
                parameters.put("xOrigin", origin.getX());
                parameters.put("yOrigin", origin.getY());
                parameters.put("xDestination", matcher.group("x"));
                parameters.put("yDestination", matcher.group("y"));
                request.setParameters(parameters);
                Response response = NetworkController.getInstance().sendRequest(request);
                System.out.println(response.getMessage());
                if ((boolean)response.getParameters().get("notification")) {
                    for (String notification : response.getNotifications()) {
                        System.out.println(notification);
                    }
                }
            }

            else if (tileInput.equals("delete unit")) {

                request.setAction("delete unit");
                HashMap<String, Object> parameters = new HashMap<>();
                parameters.put("xOrigin", origin.getX());
                parameters.put("yOrigin", origin.getY());
                request.setParameters(parameters);
                Response response = NetworkController.getInstance().sendRequest(request);
                System.out.println(response.getMessage());
            }
            else if (tileInput.equals("sleep unit")) {
                request.setAction("sleep unit");
                HashMap<String, Object> parameters = new HashMap<>();
                parameters.put("xOrigin", origin.getX());
                parameters.put("yOrigin", origin.getY());
                request.setParameters(parameters);
                Response response = NetworkController.getInstance().sendRequest(request);
                System.out.println(response.getMessage());
            }
            else if (tileInput.equals("alert unit")) {
                request.setAction("alert unit");
                HashMap<String, Object> parameters = new HashMap<>();
                parameters.put("xOrigin", origin.getX());
                parameters.put("yOrigin", origin.getY());
                request.setParameters(parameters);
                Response response = NetworkController.getInstance().sendRequest(request);
                System.out.println(response.getMessage());
            }
            else if (tileInput.equals("garrison unit")) {
                request.setAction("garrison unit");
                HashMap<String, Object> parameters = new HashMap<>();
                parameters.put("xOrigin", origin.getX());
                parameters.put("yOrigin", origin.getY());
                request.setParameters(parameters);
                Response response = NetworkController.getInstance().sendRequest(request);
                System.out.println(response.getMessage());
            }
            else if (tileInput.equals("fortify unit")) {
                request.setAction("fortify unit");
                HashMap<String, Object> parameters = new HashMap<>();
                parameters.put("xOrigin", origin.getX());
                parameters.put("yOrigin", origin.getY());
                request.setParameters(parameters);
                Response response = NetworkController.getInstance().sendRequest(request);
                System.out.println(response.getMessage());
            }
            else if (tileInput.equals("pillage unit")) {
                request.setAction("pillage unit");
                HashMap<String, Object> parameters = new HashMap<>();
                parameters.put("xOrigin", origin.getX());
                parameters.put("yOrigin", origin.getY());
                request.setParameters(parameters);
                Response response = NetworkController.getInstance().sendRequest(request);
                System.out.println(response.getMessage());
            }
            else if (tileInput.equals("repair improvement")) {
                request.setAction("pillage unit");
                HashMap<String, Object> parameters = new HashMap<>();
                parameters.put("xOrigin", origin.getX());
                parameters.put("yOrigin", origin.getY());
                request.setParameters(parameters);
                Response response = NetworkController.getInstance().sendRequest(request);
                System.out.println(response.getMessage());
            }
            else if (tileInput.equals("repair improvement cheat")) {
                request.setAction("repair improvement");
                HashMap<String, Object> parameters = new HashMap<>();
                parameters.put("xOrigin", origin.getX());
                parameters.put("yOrigin", origin.getY());
                request.setParameters(parameters);
                Response response = NetworkController.getInstance().sendRequest(request);
                System.out.println(response.getMessage());
            }
            else if (tileInput.equals("pause improving")){
                request.setAction("pause improvement");
                HashMap<String, Object> parameters = new HashMap<>();
                parameters.put("xOrigin", origin.getX());
                parameters.put("yOrigin", origin.getY());
                request.setParameters(parameters);
                Response response = NetworkController.getInstance().sendRequest(request);
                System.out.println(response.getMessage());
            }
            else if (tileInput.equals("resume improving")) {
                request.setAction("resume improvement");
                HashMap<String, Object> parameters = new HashMap<>();
                parameters.put("xOrigin", origin.getX());
                parameters.put("yOrigin", origin.getY());
                request.setParameters(parameters);
                Response response = NetworkController.getInstance().sendRequest(request);
                System.out.println(response.getMessage());
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

    //bullshit

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

    public static void lineOfTree(AnchorPane techRoot) {
        Line line1 = new Line(970, 60, 485, 132);
        Line line2 = new Line(970, 60, 805, 132);
        Line line3 = new Line(970, 60, 1125, 132);
        Line line4 = new Line(970, 60, 1445, 132);
        Line line5 = new Line(485, 195, 155, 267);
        Line line6 = new Line(485, 195, 485, 267);
        Line line7 = new Line(805, 195, 805, 267);
        Line line8 = new Line(805, 195, 1125, 267);
        Line line9 = new Line(1445, 195, 1445, 267);
        Line line10 = new Line(1445, 195, 1765, 267);
        Line line11 = new Line(1125, 328, 1275, 402);
        Line line12 = new Line(485, 325, 1600, 402);
        Line line13 = new Line(1600, 460, 1600, 535);
        Line line14 = new Line(1600, 460, 330, 532);
        Line line15 = new Line(1600, 592, 650, 666);
        Line line16 = new Line(650, 725, 485, 800);
        Line line17 = new Line(650, 725, 815, 800);
        Line line18 = new Line(485, 857, 330, 930);
        Line line19 = new Line(485, 857, 1600, 930);
        Line line20 = new Line(1600, 990, 1445, 1063);
        Line line21 = new Line(1600, 990, 815, 1063);
        Line line22 = new Line(330, 570, 330, 670);
        Line line23 = new Line(330, 725, 815, 800);
        Line line24 = new Line(815, 858, 970, 930);
        Line line25 = new Line(970, 988, 815, 1063);
        Line line26 = new Line(815, 1063, 660, 990);
        Line line27 = new Line(660, 990, 485, 1063);
        Line line28 = new Line(485, 1125, 815, 1195);
        Line line29 = new Line(815, 1195, 1130, 1125);
        Line line30 = new Line(1130, 1063, 1265, 990);
        Line line31 = new Line(1265, 930, 1130, 858);
        Line line32 = new Line(1130, 858, 660, 930);
        Line line33 = new Line(1130, 1256, 970, 1330);
        Line line34 = new Line(1130, 1256, 640, 1330);
        Line line35 = new Line(1130, 1256, 1280, 1330);
        Line line36 = new Line(640, 1389, 970, 1462);
        Line line37 = new Line(640, 1389, 1280, 1462);
        Line line38 = new Line(970, 1389, 640, 1462);
        Line line39 = new Line(640, 1462, 1280, 1389);
        Line line40 = new Line(1445, 327, 970, 400);
        Line line41 = new Line(970, 460, 1280, 532);
        Line line42 = new Line(1280, 592, 1280, 665);
        Line line43 = new Line(1280, 592, 1610, 665);
        Line line44 = new Line(1280, 725, 1115, 800);
        Line line45 = new Line(1610, 725, 1115, 800);
        Line line46 = new Line(1280, 725, 1445, 800);
        Line line47 = new Line(1445, 858, 970, 930);
        Line line48 = new Line(1765, 327, 320, 400);
        Line line49 = new Line(320, 460, 970, 532);
        Line line50 = new Line(970, 592, 1280, 665);
        Line line51 = new Line(970, 592, 970, 665);
        Line line52 = new Line(970, 725, 1445, 800);
        Line line53 = new Line(1125, 327, 670, 400);
        Line line54 = new Line(1275, 460, 670, 532);
        Line line55 = new Line(1275, 460, 970, 532);
        Line line56 = new Line(670, 593, 330, 665);

        Polyline polyline1 = new Polyline(1125, 195, 1125, 225, 1275, 225, 1275, 402);
        Polyline polyline2 = new Polyline(155, 327, 155, 490, 1600, 490, 1600, 530);
        Polyline polyline3 = new Polyline(815, 327, 815, 500, 330, 500, 330, 530);
        Polyline polyline4 = new Polyline(670, 460, 670, 480, 500, 480, 500, 630, 330, 630, 330, 665);
        Polyline polyline5 = new Polyline(1445, 1115, 1445, 1300, 640, 1300, 640, 1330);
        Polyline polyline6 = new Polyline(815, 1240, 815, 1400, 640, 1400, 640, 1460);

        techRoot.getChildren().add(line1);
        techRoot.getChildren().add(line2);
        techRoot.getChildren().add(line3);
        techRoot.getChildren().add(line4);
        techRoot.getChildren().add(line5);
        techRoot.getChildren().add(line6);
        techRoot.getChildren().add(line7);
        techRoot.getChildren().add(line8);
        techRoot.getChildren().add(line9);
        techRoot.getChildren().add(line10);
        techRoot.getChildren().add(line11);
        techRoot.getChildren().add(line12);
        techRoot.getChildren().add(line13);
        techRoot.getChildren().add(line14);
        techRoot.getChildren().add(line15);
        techRoot.getChildren().add(line16);
        techRoot.getChildren().add(line17);
        techRoot.getChildren().add(line18);
        techRoot.getChildren().add(line19);
        techRoot.getChildren().add(line20);
        techRoot.getChildren().add(line21);
        techRoot.getChildren().add(line22);
        techRoot.getChildren().add(line23);
        techRoot.getChildren().add(line24);
        techRoot.getChildren().add(line25);
        techRoot.getChildren().add(line26);
        techRoot.getChildren().add(line27);
        techRoot.getChildren().add(line28);
        techRoot.getChildren().add(line29);
        techRoot.getChildren().add(line30);
        techRoot.getChildren().add(line31);
        techRoot.getChildren().add(line32);
        techRoot.getChildren().add(line33);
        techRoot.getChildren().add(line34);
        techRoot.getChildren().add(line35);
        techRoot.getChildren().add(line36);
        techRoot.getChildren().add(line37);
        techRoot.getChildren().add(line38);
        techRoot.getChildren().add(line39);
        techRoot.getChildren().add(line40);
        techRoot.getChildren().add(line41);
        techRoot.getChildren().add(line42);
        techRoot.getChildren().add(line43);
        techRoot.getChildren().add(line44);
        techRoot.getChildren().add(line45);
        techRoot.getChildren().add(line46);
        techRoot.getChildren().add(line47);
        techRoot.getChildren().add(line48);
        techRoot.getChildren().add(line49);
        techRoot.getChildren().add(line50);
        techRoot.getChildren().add(line51);
        techRoot.getChildren().add(line52);
        techRoot.getChildren().add(line53);
        techRoot.getChildren().add(line54);
        techRoot.getChildren().add(line55);
        techRoot.getChildren().add(line56);

        techRoot.getChildren().add(polyline1);
        techRoot.getChildren().add(polyline2);
        techRoot.getChildren().add(polyline3);
        techRoot.getChildren().add(polyline4);
        techRoot.getChildren().add(polyline5);
        techRoot.getChildren().add(polyline6);
    }

}

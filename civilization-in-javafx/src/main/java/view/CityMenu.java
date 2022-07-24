package view;

import controller.*;
import view.enums.Colors;
import model.*;
import view.enums.RegexEnums;
import model.City;
import model.Product;
import model.Tile;
import model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CityMenu {

    private ArrayList<User> players;
    private Matcher matcher;
    private CityController cityController;
    private MapController mapController;
    private GameController gameController;

    public CityMenu (ArrayList<User> players, MapController mapController, GameController gameController) {
        cityController = CityController.getInstance();
        this.players = players;
        this.mapController = mapController;
        this.gameController = gameController;
    }

    public void run(Scanner scanner, User user) {
        String cityInput;
        System.out.println("welcome to city menu dear " + user.getUsername());
        while (true) {
            cityInput = scanner.nextLine();
            // get out
            if (cityInput.equals("city exit")) {
                System.out.println("back to play game");
                return;
            }
            // show player cities
            else if (cityInput.equals("user cities")) {
                //get user from server
                Request request = new Request();
                request.setMenu("city menu");
                request.setAction("get user");
                Response response = NetworkController.getInstance().sendRequest(request);
                user = response.getUser();

                if (user.getCities() != null && user.getCities().size() > 0) {
                    int index = 1;
                    for (City city : user.getCities()) {
                        System.out.println(index + "- " + city.getName());
                        index++;
                    }
                    while (true) {
                        cityInput = scanner.nextLine();
                        if (cityInput.equals("city exit")) {
                            System.out.println("back to play game");
                            return;
                        } else if (Pattern.matches("[0-9]+", cityInput)) {
                            index = Integer.parseInt(cityInput);
                            if (index >= 1 && index <= user.getCities().size()) {
                                cityPage(user.getCities().get(index - 1), user, scanner);
                            } else
                                System.out.println("invalid number");
                        }
                        else
                            System.out.println("invalid command");
                    }
                }
                else
                    System.out.println("user do not have any city!");
            }
            // show all cities in the game
            else if (cityInput.equals("show all cities")) {
                System.out.println("**********");
                int index = 1;
                for (User player : players) {
                    if (player.getCities() != null) {
                        for (City city : player.getCities()) {
                            System.out.println(index + "- " + city.getName());
                            index++;
                        }
                    }
                    else
                        System.out.println(player.getUsername() + " do not have any city!");
                    System.out.println("**********");
                    index = 1;
                }
            }
            else
                System.out.println("invalid command");
        }
    }

    public void cityPage(City city, User user, Scanner scanner) {
        String cityInput;
        System.out.println("you are in the city page of : " + city.getName());
        while (true) {
            cityInput = scanner.nextLine();
            if (cityInput.trim().equals("city exit")) {
                System.out.println("back to city menu");
                return;
            }
            else if (cityInput.trim().equals("buy tile")) {
                ArrayList<Tile> neighborOfCity = mapController.neighborOfCity(city);
                int index = 1;
                for (Tile tile : neighborOfCity) {
                    System.out.println(index + "- coordinate : -x " + tile.getX() + " -y " + tile.getY());
                    System.out.println("Terrain : " + tile.getTerrain().getName());
                    if (tile.getFeature() != null)
                        System.out.println("Feature : " + tile.getFeature().getName());
                    index++;
                }

                String buyTileInput;
                boolean buying = true;
                while (buying) {
                    buyTileInput = scanner.nextLine();
                    if (buyTileInput.equals("buy tile exit"))
                        buying = false;
                    else if (Pattern.matches("[\\d+]", buyTileInput)) {
                        index = Integer.parseInt(buyTileInput);
                        if (index >= 1 && index <= neighborOfCity.size()) {
                            // add the tile to the city and user
                            if (user.getGold() >= neighborOfCity.get(index - 1).getPrice()) {
                                new ResourceController().addFoundResource(user, neighborOfCity.get(index - 1));
                                for (Resource foundResource : user.getFoundResources()) {
                                    if (!foundResource.isAnnounce()){
                                        System.out.println("You found" + foundResource.getName() + "in this tile.");
                                        if (!user.getAvailableResources().contains(foundResource)){
                                            System.out.println("You should first build" + foundResource.getRequiredImprovement()
                                                    + "on this tile to use this resource benefits!");
                                        }
                                    }
                                }
                                //buy tile without cheat
//                                buyTile(user.getUsername(), user.getCities().indexOf(city), index, false);
                            }
                            else
                                System.out.println("not enough gold!");
                        }
                        else
                            System.out.println("invalid number");
                    }
                    else if ((matcher = RegexEnums.getMatcher(buyTileInput, RegexEnums.BUY_TILE1)) != null ||
                            (matcher = RegexEnums.getMatcher(buyTileInput, RegexEnums.BUY_TILE2)) != null) {
                        index = Integer.parseInt(matcher.group("index"));
                        if (index >= 1 && index <= neighborOfCity.size()) {
                            //buy tile with cheat
//                            buyTile(user.getUsername(), user.getCities().indexOf(city), index, true);
                        }
                        else
                            System.out.println("invalid number");
                    }
                    else
                        System.out.println("invalid command");
                }
            }
            else if (cityInput.trim().equals("new production")) {
                if (!city.isProductStatus())
                    setProduction(city, user, scanner);
                else
                    System.out.println("you are already producing something");
            }
            else if (cityInput.trim().equals("resume production")) {
                if (city.getCurrentProduction() != null) {
                    city.setProductStatus(true);
                    System.out.println("production running");
                }
                else
                    System.out.println("city do not have production in queue");
            }
            else if (cityInput.trim().equals("terminate current production")) {
                if (city.isProductStatus()) {
                    // producing eliminated
                    city.setProductStatus(false);
                }
                else
                    System.out.println("you don't produce anything");
            }
            else if (cityInput.trim().equals("set citizens")){
                alternativeFunction(scanner, city);
            }
            else if (cityInput.trim().equals("city information")) {
                cityInformation(city);
            }
            else
                System.out.println("invalid command");
        }
    }

    public void setProduction(City city, User user, Scanner scanner) {
        int index = 1;
        for (Product product : city.getProducts()) {
            System.out.println(index + "- " + product.getName() + " cost : " + product.getTurnCost());
            index++;
        }
        String productInput;
        System.out.println("you are in production bar");
        while (true) {
            productInput = scanner.nextLine();
            if (productInput.trim().equals("production exit"))
                return;
            else if (Pattern.matches("\\d+", productInput)) {
                int numberOfProduct = Integer.parseInt(productInput);
                if (numberOfProduct <= city.getProducts().size() && numberOfProduct >= 1) {

                    Request request = new Request();
                    request.setMenu("city menu");
                    request.setAction("set production");
                    HashMap<String, Object> parameters = new HashMap<>();
                    parameters.put("index", numberOfProduct);
                    parameters.put("cheat", false);
                    request.setParameters(parameters);

                    Response response = NetworkController.getInstance().sendRequest(request);
                    System.out.println(response.getMessage());
                }
                else
                    System.out.println("invalid number");
            }
            else if ((matcher = RegexEnums.getMatcher(productInput, RegexEnums.ADD_PRODUCT1)) != null ||
                    (matcher = RegexEnums.getMatcher(productInput, RegexEnums.ADD_PRODUCT2)) != null) {
                index = Integer.parseInt(matcher.group("index"));
                if (index >= 1 && index <= city.getProducts().size()) {

                    Request request = new Request();
                    request.setMenu("city menu");
                    request.setAction("set production");
                    HashMap<String, Object> parameters = new HashMap<>();
                    parameters.put("index", index);
                    parameters.put("cheat", true);
                    request.setParameters(parameters);

                    Response response = NetworkController.getInstance().sendRequest(request);
                    System.out.println(response.getMessage());
                }
                else
                    System.out.println("invalid number");
            }
            else
                System.out.println("invalid command");
        }
    }

    public void alternativeFunction(Scanner scanner, City city) {
        int index = 1;
        System.out.println("choose one of the citizens number");

        for (Citizen citizen : city.getCitizens()) {
            if (citizen.isWorking()){
                System.out.println(index + ": working on Tile -> x " + citizen.getTile().getX() + " y " + citizen.getTile().getY());
            } else {
                System.out.println(index + ": unemployed");
            }
            index++;
        }
        String input;
        System.out.println("just numbers, back to return to city panel");
        Citizen citizen;
        while (true) {
            input = scanner.nextLine();
            if (input.equals("back")) {
                System.out.println("back to city panel");
                return;
            }
            else if (Pattern.matches("\\d+", input)) {
                index = Integer.parseInt(input);
                if (index >= 1 && index <= city.getCitizens().size()) {
                    citizen = city.getCitizens().get(index - 1);
                    break;
                }
                else
                    System.out.println("invalid index");
            }
            else
                System.out.println("invalid command, just put numbers");
        }

        index = 1;

        System.out.println("choose one tile number to employ the citizen on the tile");
        for (Tile ownerShipTile : city.getOwnerShipTiles()) {
            if (!ownerShipTile.isCitizenExist()) {
                System.out.println(Colors.PURPLE + index + "- Tile coordination : x " + ownerShipTile.getX()
                        + " y " + ownerShipTile.getY() + Colors.RESET);
                if (ownerShipTile.getFeature() != null) {
                    System.out.println("tile information -> foodRate : "
                            + (ownerShipTile.getTerrain().getFoodRate() + ownerShipTile.getFeature().getFoodRate())
                            + " *** goldRate : "
                            + (ownerShipTile.getTerrain().getGoldRate() + ownerShipTile.getFeature().getGoldRate())
                            + " *** productionRate : "
                            + (ownerShipTile.getTerrain().getProductionRate() + ownerShipTile.getFeature().getProductionRate()));
                } else
                    System.out.println("tile information -> foodRate : "
                            + ownerShipTile.getTerrain().getFoodRate() + " *** goldRate : "
                            + ownerShipTile.getTerrain().getGoldRate() + " *** productionRate : "
                            + ownerShipTile.getTerrain().getProductionRate());
                index++;
            }
        }

        while (true) {
            input = scanner.nextLine();
            if (input.equals("back")) {
                System.out.println("back to city panel");
                return;
            }
            else if (Pattern.matches("\\d+", input)) {
                index = Integer.parseInt(input);
                if (index >= 1 && index <= city.getOwnerShipTiles().size()) {
                    //the function that should be called to set citizen on tile --> amir hossein
                    setCitizen(city.getOwner().getUsername(), city.getOwner().getCities().indexOf(city), index - 1, city.getCitizens().indexOf(citizen));
                    return;
                }
                else
                    System.out.println("invalid index");
            }
        }
    }

    private void setCitizen(String username, int indexOfCity, int indexOfTileInOwnerShips, int indexOfCitizen) {
        Request request = new Request();
        request.setMenu("city menu");
        request.setAction("set citizen");
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("username", username);
        parameters.put("index of city", String.valueOf(indexOfCity));
        parameters.put("index of tile", String.valueOf(indexOfTileInOwnerShips));
        parameters.put("index of citizen", String.valueOf(indexOfCitizen));
        request.setParameters(parameters);
        Response response = NetworkController.getInstance().sendRequest(request);
        System.out.println(response.getMessage());
    }


    private void cityInformation(City city) {
        System.out.println(Colors.YELLOW + "Name : " + city.getName());
        System.out.println("Owner : " + city.getOwner().getUsername());
        System.out.println("Health point : " + city.getHP());
        System.out.println("Coordinate : -x " + city.getTile().getX() + " -y " + city.getTile().getY());
        System.out.println("Possible products :");
        for (Product product : city.getProducts()) {
            System.out.println("Name : " + product.getName());
            System.out.println("Price : " + product.getTurnCost());
        }
        System.out.println("Ownership tile :");
        int index = 1;
        for (Tile ownerShipTile : city.getOwnerShipTiles()) {
            System.out.println(index + "- : -x " + ownerShipTile.getX() + " -y " + ownerShipTile.getY());
            PlayGame.tileDetails(ownerShipTile);
            index++;
        }
        System.out.println(Colors.RESET);
    }

    private void buyTile(String username, int indexOfCity, int indexOfTileInNeighborsOfCity, boolean cheat, Tile tile) {
        Request request = new Request();
        request.setMenu("city menu");
        request.setAction("buy tile");
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("cheat", cheat);
        parameters.put("username", username);
        parameters.put("index of city", String.valueOf(indexOfCity));
        parameters.put("index of tile", String.valueOf(indexOfTileInNeighborsOfCity));
        request.setParameters(parameters);
        Response response = NetworkController.getInstance().sendRequest(request);
        System.out.println(response.getMessage());
    }
}

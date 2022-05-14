package view;

import controller.*;
import controller.enums.Colors;
import model.*;
import controller.enums.RegexEnums;
import model.City;
import model.Product;
import model.Tile;
import model.User;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CityMenu {

    private MapController mapController;
    private TechController techController;
    private SettlerController settlerController;
    private GameController gameController;
    private ArrayList<User> players;
    private Matcher matcher;

    public CityMenu (MapController mapController, TechController techController, SettlerController settlerController, GameController gameController, ArrayList<User> players) {
        this.mapController = mapController;
        this.techController = techController;
        this.settlerController = settlerController;
        this.gameController = gameController;
        this.players = players;
    }

    public void run(Scanner scanner, User user) {
        String cityInput;
        System.out.println("welcome to city menu dear " + user.getUsername());
        while (true) {
            cityInput = scanner.nextLine();
            // get out
            if (cityInput.equals("city exit"))
                return;
            // show player cities
            else if (cityInput.equals("user cities")) {
                if (user.getCities() != null || user.getCities().size() == 0) {
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
        System.out.println("you are in the city page of city : " + city.getName());
        while (true) {
            cityInput = scanner.nextLine();
            if (cityInput.trim().equals("city exit"))
                return;
            else if (cityInput.trim().equals("buy tile")) {
                ArrayList<Tile> neighborOfCity = mapController.neighborOfCity(city);

                // TODO show nearby neutral tiles and then buy ,,, when map is ready

                String buyTileInput;
                boolean buying = true;
                while (buying) {
                    buyTileInput = scanner.nextLine();
                    if (buyTileInput.equals("buy tile exit"))
                        buying = false;
                    else if (Pattern.matches("[\\d+]", buyTileInput)) {
                        int index = Integer.parseInt(buyTileInput);
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
                                user.setGold(user.getGold() - neighborOfCity.get(index - 1).getPrice());
                                city.addOwnerShipTiles(neighborOfCity.get(index - 1));
                                user.addTerritory(neighborOfCity.get(index - 1));
                            }
                            else
                                System.out.println("not enough gold!");
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
                gameController.setCitizen(scanner, city, this);
            }
            else
                System.out.println("invalid command");
        }
    }

    private void setProduction(City city, User user, Scanner scanner) {
        int index = 1;
        for (Product product : city.getProducts()) {
            System.out.println(index + "- " + product.getName());
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
                    city.setCurrentProduction(city.getProducts().get(numberOfProduct - 1));
                    city.setProductStatus(true);
                    city.setProductTurnLeft(city.getCurrentProduction().getTurnCost());
                }
                else
                    System.out.println("invalid number");
            }
            else if ((matcher = RegexEnums.getMatcher(productInput, RegexEnums.ADD_PRODUCT1)) != null ||
                    (matcher = RegexEnums.getMatcher(productInput, RegexEnums.ADD_PRODUCT2)) != null) {
                index = Integer.parseInt(matcher.group("index"));
                if (index >= 1 && index <= city.getProducts().size()) {
                    city.setProductStatus(true);
                    city.setCurrentProduction(city.getProducts().get(index - 1));
                    city.setProductTurnLeft(1);
                    gameController.cityTurnProducts(user);
                }
                else
                    System.out.println("invalid number");
            }
            else
                System.out.println("invalid command");
        }
    }

    public void setCitizenInterface(int which, City city){
        int index = 1;
        switch (which){
            case 1:
                System.out.println("choose one the citizens number");

                for (Citizen citizen : city.getCitizens()) {
                    if (citizen.getTile() != null){
                        System.out.println(index + ": working on Tile -> x " + citizen.getTile().getX() + " y " + citizen.getTile().getY());
                    } else {
                        System.out.println(index + ": unemployed");
                    }
                    index++;
                }
                break;
            case 2:
                System.out.println("choose one tile number to employ the citizen on the tile");
                for (Tile ownerShipTile : city.getOwnerShipTiles()) {
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
                }
            case 3:
                    System.out.println("the citizen employed on the selected tile successfully");
        }
    }
}

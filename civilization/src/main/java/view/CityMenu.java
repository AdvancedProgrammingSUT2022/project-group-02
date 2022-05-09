package view;

import controller.GameController;
import controller.MapController;
import controller.SettlerController;
import controller.TechController;
import model.City;
import model.Product;
import model.Tile;
import model.User;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CityMenu {

    private MapController mapController;
    private TechController techController;
    private SettlerController settlerController;
    private GameController gameController;

    public CityMenu (MapController mapController, TechController techController, SettlerController settlerController, GameController gameController) {
        this.mapController = mapController;
        this.techController = techController;
        this.settlerController = settlerController;
        this.gameController = gameController;
    }

    public void run(Scanner scanner, User user) {
        String cityInput;
        if (user.getCities() != null) {
            int index = 1;
            for (City city : user.getCities()) {
                System.out.println(index + "- " + city.getName());
                index++;
            }
        }
        while (true) {
            cityInput = scanner.nextLine();
            if (cityInput.equals("city exit")) {
                System.out.println("back to play game");
                return;
            }
            else if (Pattern.matches("[0-9]+", cityInput)) {
                int index = Integer.parseInt(cityInput);
                if (index >= 1 && index <= user.getCities().size()) {

                }
                else
                    System.out.println("invalid number");
            }
        }
    }

    public void cityPage(City city, User user, Scanner scanner) {
        String cityInput;
        System.out.println("you are in the city page");
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
                                user.setGold(user.getGold() - neighborOfCity.get(index - 1).getPrice());
                                city.addOwnerShipLand(neighborOfCity.get(index - 1));
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
            // TODO add resume current production
            else if (cityInput.trim().equals("terminate current production")) {
                if (city.isProductStatus()) {
                    // producing eliminated
                    city.setProductStatus(false);
                }
                else
                    System.out.println("you don't produce anything");
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
            else
                System.out.println("invalid command");
        }
    }
}

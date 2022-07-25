package controller;


import model.*;

import java.util.ArrayList;
import java.util.HashMap;

public class CityController {
    private static CityController cityController;

    public static CityController getInstance() {
        if (cityController == null)
            cityController = new CityController();
        return cityController;
    }

    public Response createCity(Tile origin, User user, Unit unit) {
        Request request = new Request();
        int xDestination = origin.getX();
        int yDestination = origin.getY();
        request.setMenu("tile menu");
        request.setAction("place city");
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("xDestination", xDestination);
        parameters.put("yDestination", yDestination);
        parameters.put("username", user.getUsername());
        request.setParameters(parameters);
        Response response = NetworkController.getInstance().sendRequest(request);
        System.out.println(response.getMessage());
        if (response.getMessage().equals("city created successfully")) {
            SettlerController.getInstance().createNewCity(unit, user, unit.getTile(), "name");
        }
        return response;
    }

    public static boolean buyTile(Tile tile, City city, User user) {
        System.out.println(user.getGold());
        System.out.println(tile.getPrice());
        if (user.getGold() >= tile.getPrice()){
            user.setGold(user.getGold() - tile.getPrice());
            user.addTerritory(tile);
            city.addOwnerShipTiles(tile);
            tile.setOwner(user);
            return true;
        }
        return false;
    }

//    public void createNewCity(Unit unit, User user, Tile tile, String nameOfCity) {
//        ArrayList<Tile> ownerShipTiles = new ArrayList<>();
//        ownerShipTiles.add(tile);
//        Citizen citizen = new Citizen(tile);
//        ArrayList<Citizen> citizens = new ArrayList<>();
//        citizens.add(citizen);
//        City city = new City(nameOfCity, tile, user, ownerShipTiles, 100, 100, null, null,
//                50, 1, 1, 1, 1, 1, 1, 1, 1,
//                null, null, false, citizens, 20);
//        tile.setCity(city);
//        tile.setOwner(user);
//        if (user.getCapital() == null)
//            user.setCapital(city);
//        user.addCity(city);
//        removeUnit(true, unit, user);
//        addBasicProducts(city);
//        addBasicUnits(city);
//        addBasicBuildings(city);
//        user.addTerritory(tile);
//        // add neighbors to the city for free
//        for (Tile neighbor : tile.getNeighbors()) {
//            new ResourceController().addFoundResource(user, neighbor);
//            neighbor.setCity(city);
//            neighbor.setOwner(user);
//            city.addOwnerShipTiles(neighbor);
//            user.addTerritory(neighbor);
//        }
//    }
}

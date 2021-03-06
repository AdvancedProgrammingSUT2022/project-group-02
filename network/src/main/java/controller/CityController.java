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

    public void buyingTile(City city, User user, Tile tile) {
            if (user.getGold() >= tile.getPrice()) {
                new ResourceController().addFoundResource(user, tile);
                user.setGold(user.getGold() - tile.getPrice());
                city.addOwnerShipTiles(tile);
                user.addTerritory(tile);
                tile.setCity(city);
                tile.setOwner(user);
            }
    }

    public Response conditionsForPlaceCity(Request request, Maps map) {
        Response response = new Response();
        int xDestination = (int)Math.floor((double)request.getParameters().get("xDestination"));
        int yDestination = (int)Math.floor((double)request.getParameters().get("yDestination"));
        String username = (String) request.getParameters().get("username");
        User user = UsersController.getInstance().getUserByUsername(username);
        String nameOfCity = "city" + (user.getCities().size() + 1);
        Tile tile = map.getSpecificTile(xDestination, yDestination);
        // neighbors of the tile should be neutral
        for (Tile neighbor : tile.getNeighbors()) {
            if (neighbor.getOwner() != null) {
                response.setMessage("a tile has owner here");
                return response;
                //return false;
            }
        }
        if (tile.isCivilianUnitExists() && tile.getCivilianUnit().getName().equals("settler") && tile.getCivilianUnit().getOwner().equals(user)) {
            if (tile.getCity() == null) {
                if (tile.getOwner() == null || tile.getOwner().equals(user)) {
                    //return true;
                    createCity(tile, user, nameOfCity, response);
                    response.setMessage("city created successfully");
                }
                else
                response.setMessage("you are in someone else's territory");
            } else
                response.setMessage("there is already a city here");
        } else
            response.setMessage("no settler");

        return response;
    }

    private void createCity(Tile tile, User user, String nameOfCity, Response response) {
        // completely delete settler
        SettlerController.getInstance().createNewCity(tile.getCivilianUnit(), user, tile, nameOfCity);
//        for (Resource foundResource : user.getFoundResources()) {
//            if (!foundResource.isAnnounce()){
//                response.setMessage("You found" + foundResource.getName() + "in this tile.");
//                if (!user.getAvailableResources().contains(foundResource)){
//                    response.setMessage("You should first build" + foundResource.getRequiredImprovement()
//                            + "on this tile to use this resource benefits!");
//                }
//            }
//        }
        // remove settler from tile
        MapController.getInstance().deleteCivilian(tile);
        response.setMessage("city located successfully!");
    }

    public Response conditionForAttackCity(Request request, Maps map) {

        Response response = new Response();
        HashMap<String, Object> parameters = new HashMap<>();
        String username = (String) request.getParameters().get("username");
        User user = UsersController.getInstance().getUserByUsername(username);
        //destination
        int xDestination = (int) Math.floor((double) request.getParameters().get("xDestination"));
        int yDestination = (int) Math.floor((double) request.getParameters().get("yDestination"));
        Tile destination = map.getSpecificTile(xDestination, yDestination);

        //origin
        int xOrigin = (int) request.getParameters().get("xOrigin");
        int yOrigin = (int) request.getParameters().get("yOrigin");
        Tile origin = map.getSpecificTile(xOrigin, yOrigin);

        boolean found = false;

        if (destination.getCity() != null && destination.getCity().getTile().equals(destination)) {
            if (origin.isMilitaryUnitExists() && origin.getMilitaryUnit().getOwner().equals(user)) {
                // melee
                if (origin.getMilitaryUnit().getRangeCombatStrength() == 0) {
                    for (int i = 0; i < origin.getNeighbors().size(); i++) {
                        if (origin.getNeighbors().get(i).equals(destination)) {
                            found = true;
                            CombatController.getInstance().attackCity(destination.getCity(), origin.getMilitaryUnit());
                            if (destination.getCity().getHP() <= 0)
                                parameters.put("ruined", true);

                            else
                                parameters.put("ruined", false);
                            break;
                        }
                    }
                }
                // ranged
                else {
                    for (int i = 0; i < origin.getNeighbors().size(); i++) {
                        if (origin.getNeighbors().get(i).equals(destination)) {
                            found = true;
                            CombatController.getInstance().attackCity(destination.getCity(), origin.getMilitaryUnit());
                            if (destination.getCity().getHP() <= 0)
                                parameters.put("ruined", true);
                            else
                                parameters.put("ruined", false);

                            break;
                        }
                        for (int j = 0; j < origin.getNeighbors().get(i).getNeighbors().size(); j++) {
                            if (origin.getNeighbors().get(i).getNeighbors().get(j).equals(destination)) {
                                found = true;
                                CombatController.getInstance().attackCity(destination.getCity(), origin.getMilitaryUnit());
                                if (destination.getCity().getHP() <= 0)
                                    parameters.put("ruined", true);
                                else
                                    parameters.put("ruined", false);

                                break;
                            }
                        }
                    }
                }
                if (!found)
                    response.setMessage("this city is not in the range of your unit");
            } else
                response.setMessage("there is no military unit on this tile");
        }
        else
            response.setMessage("there is no city on this tile");

        response.setParameters(parameters);
        return response;
    }

    public Response setProduction(Request request) {

        Response response = new Response();

        String username = (String) request.getParameters().get("username");
        User user = UsersController.getInstance().getUserByUsername(username);
        int index = (int) request.getParameters().get("index of city");
        City city = user.getCities().get(index);

        city.setCurrentProduction(city.getProducts().get(index - 1));
        city.setProductStatus(true);
        city.setProductTurnLeft(city.getCurrentProduction().getTurnCost());

        response.setMessage("product is being produced...!");
        return response;
    }

    public Response buyTile(Request request) {
        Response response = new Response();

        String username = (String) request.getParameters().get("username");
        int indexOfCity = Integer.parseInt((String) request.getParameters().get("index of city"));
        User user = UsersController.getInstance().getUserByUsername(username);
        City city = user.getCities().get(indexOfCity);
        ArrayList<Tile> neighborOfCity = MapController.getInstance().neighborOfCity(city);
        int index = Integer.parseInt((String) request.getParameters().get("index of tile"));
        boolean cheat = (boolean) request.getParameters().get("cheat");
        if (!cheat)
            user.setGold(user.getGold() - neighborOfCity.get(index - 1).getPrice());
        city.addOwnerShipTiles(neighborOfCity.get(index - 1));
        user.addTerritory(neighborOfCity.get(index - 1));
        neighborOfCity.get(index - 1).setCity(city);
        neighborOfCity.get(index - 1).setOwner(user);
        response.setMessage("you bought tile with index " + index + " successfully!");
        return response;
    }

    public Response setCitizen(Request request) {
        Response response = new Response();
        String username = (String) request.getParameters().get("username");
        User user = UsersController.getInstance().getUserByUsername(username);
        int indexOfCity = Integer.parseInt((String) request.getParameters().get("index of city"));
        City city = user.getCities().get(indexOfCity);
        int indexOfTile = Integer.parseInt((String) request.getParameters().get("index of tile"));
        Tile tile = city.getOwnerShipTiles().get(indexOfTile);
        int indexOfCitizen = Integer.parseInt((String) request.getParameters().get("index of citizen"));
        Citizen citizen = city.getCitizens().get(indexOfCitizen);

        tile.setCitizenExist(true);
        citizen.setWorking(true);
        citizen.setTile(tile);
        response.setMessage("the citizen employed on the selected tile successfully");
        return response;
    }


}

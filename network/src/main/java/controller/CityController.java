package controller;


import model.*;

import java.util.HashMap;

public class CityController {
    private static CityController cityController;

    public static CityController getInstance() {
        if (cityController == null)
            cityController = new CityController();
        return cityController;
    }

    public void buyingTile(City city) {

    }

    public Response conditionsForPlaceCity(Request request, Maps map) {
        Response response = new Response();
        int xDestination = (int) request.getParameters().get("xDestination");
        int yDestination = (int) request.getParameters().get("yDestination");
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
        int xDestination = Math.(Double) request.getParameters().get("xDestination");
        int yDestination = (Double) request.getParameters().get("yDestination");
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
}

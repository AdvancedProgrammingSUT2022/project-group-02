package controller;


import model.*;

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
        String nameOfCity = (String) request.getParameters().get("name");
        int xDestination = (int) request.getParameters().get("xDestination");
        int yDestination = (int) request.getParameters().get("yDestination");
        String username = (String) request.getParameters().get("username");
        User user = UsersController.getInstance().getUserByUsername(username);
        Tile tile = map.getSpecificTile(xDestination, yDestination);
        // neighbors of the tile should be neutral
        for (Tile neighbor : tile.getNeighbors()) {
            if (neighbor.getOwner() != null) {
                response.setMessage("a tile has owner here");
                //return false;
            }
        }
        if (tile.isCivilianUnitExists() && tile.getCivilianUnit().getName().equals("settler") && tile.getCivilianUnit().getOwner().equals(user)) {
            if (tile.getCity() == null) {
                if (tile.getOwner() == null) {
                    //return true;
                    createCity(tile, user, nameOfCity, response);
                }
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
}

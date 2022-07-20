package controller;


import model.City;
import model.Resource;
import model.Tile;
import model.User;

public class CityController {
    private static CityController cityController;

    public static CityController getInstance() {
        if (cityController == null)
            cityController = new CityController();
        return cityController;
    }

    public void buyingTile(City city) {

    }

    private boolean conditionsForPlaceCity(String input, Tile tile, User user) {
        // neighbors of the tile should be neutral
        for (Tile neighbor : tile.getNeighbors()) {
            if (neighbor.getOwner() != null) {
                System.out.println("a tile has owner here");
                return false;
            }
        }
        if (tile.isCivilianUnitExists() && tile.getCivilianUnit().getName().equals("settler") && tile.getCivilianUnit().getOwner().equals(user)) {
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

    private void createCity(Tile tile, User user, String nameOfCity) {
        // completely delete settler
        SettlerController.getInstance().createNewCity(tile.getCivilianUnit(), user, tile, nameOfCity);
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
        MapController.getInstance().deleteCivilian(tile);
        System.out.println("city located successfully!");
    }
}

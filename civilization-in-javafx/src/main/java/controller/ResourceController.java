package controller;

import model.*;

public class ResourceController {

    private static ResourceController resourceController;

    public static ResourceController getInstance() {
        if (resourceController == null)
            resourceController = new ResourceController();
        return resourceController;
    }

    public void userResource(User user, Maps map){
        if (user.getFoundResources() != null) {
            for (Resource foundResource : user.getFoundResources()) {
                if (user.getAvailableResources().contains(foundResource) &&
                        !map.getSpecificTile(foundResource.getTileX(), foundResource.getTileY()).isLooted()) {
                    user.setGoldPerTurn(user.getGoldPerTurn() + foundResource.getGoldRate());
                    user.setHappiness(user.getHappiness() + foundResource.getHappiness());
                    user.setFoodPerTurn(user.getFoodPerTurn() + foundResource.getFoodRate());
                    user.setProductPerTurn(user.getProductPerTurn() + foundResource.getProductionRate());
                    if (user.getCities() != null) {
                        for (City city : user.getCities()) {
                            if (city.getOwnerShipTiles().contains(map.getSpecificTile(foundResource.getTileX(), foundResource.getTileY()))) {
                                city.setProduction(city.getProduction() + foundResource.getProductionRate());
                            }
                        }
                    }
                }
            }
        }
    }

    public void addFoundResource(User user, Tile tile){
        if (tile.getResource() != null) user.getFoundResources().add(tile.getResource());
    }

}

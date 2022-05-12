package controller;

import model.*;

public class ResourceController {

    public void userResource(User user){
        if (user.getFoundResources() != null) {
            for (Resource foundResource : user.getFoundResources()) {
                if (user.getAvailableResources().contains(foundResource) && !foundResource.getTile().LootedStatus()) {
                    user.setGoldPerTurn(user.getGoldPerTurn() + foundResource.getGoldRate());
                    user.setHappiness(user.getHappiness() + foundResource.getHappiness());
                    user.setFoodPerTurn(user.getFoodPerTurn() + foundResource.getFoodRate());
                    user.setProductPerTurn(user.getProductPerTurn() + foundResource.getProductionRate());
                    if (user.getCities() != null) {
                        for (City city : user.getCities()) {
                            if (city.getOwnerShipTiles().contains(foundResource.getTile())) {
                                city.setProduction(city.getProduction() + foundResource.getProductionRate());
                            }
                        }
                    }
                }
            }
        }
    }

    public void addFoundResource(User user, Tile tile){
        if (tile.getResource() != null){
            user.getFoundResources().add(tile.getResource());
            System.out.println("You found" + tile.getResource().getName() + "in this tile.");
            if (!user.getAvailableResources().contains(tile.getResource())){
                System.out.println("You should first build" + tile.getResource().getRequiredImprovement()
                        + "on this tile to use this resource benefits!");
            }
        }
    }

    public void addAvailableResource(User user, Tile tile){
        if (tile.getImprovement().getGivenResource().contains(tile.getResource())){
            user.setAvailableResources(tile.getResource());
            System.out.println("now you can use " + tile.getResource().getName() + "benefits!");
        }
    }

}

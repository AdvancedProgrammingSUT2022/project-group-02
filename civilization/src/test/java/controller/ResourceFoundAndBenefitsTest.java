package controller;

import model.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

public class ResourceFoundAndBenefitsTest {

    User user1 = new User("AmirHossein", "AmirHossein", "AmirHossein12");
    Resource Banana = new Resource("Banana", "Bonus", "Plantation", 0, 1, 0, 0);
    Maps map = new Maps(1, 1);
    Tile tile = new Tile(0, 0, user1, null, 1, false, null, Banana, null);
    ResourceController resourceController = new ResourceController();

    @Before
    public void SetUp(){
        ArrayList<Tile> ownerShipTiles = new ArrayList<>();
        ownerShipTiles.add(tile);
        Citizen citizen = new Citizen(tile);
        ArrayList<Citizen> citizens = new ArrayList<>();
        citizens.add(citizen);
        City city = new City("nameOfCity", tile, user1, ownerShipTiles, 100, 100, null, null,
                50, 1, 1, 1, 1, 1, 1, 1, 1,
                null, null, false, citizens, 20);
        user1.addCity(city);
        map.setTileBoard(tile);
        user1.getAvailableResources().add(Banana);
        tile.setLooted(false);
    }

    @Test // step 1: user find a resource on map
    public void checkResourceFound(){
        ArrayList<Resource> resources = new ArrayList<>();
        resourceController.addFoundResource(user1, map.getSpecificTile(0, 0));
        resources.add(Banana);
        Assertions.assertTrue(user1.getFoundResources().containsAll(resources));

    }

    @Test // step 2: user want to use benefits of found resources
    public void checkUserBenefits(){
        int userGoldBeforeRun = user1.getGold();
        int userHappinessBeforeRun = user1.getHappiness();
        int userFoodBeforeRun = user1.getFood();
        resourceController.addFoundResource(user1, tile);
        resourceController.userResource(user1, map);
        Assertions.assertTrue(userGoldBeforeRun <= user1.getGold() && userFoodBeforeRun <= user1.getFood() &&
                userHappinessBeforeRun <= user1.getHappiness());
    }
}

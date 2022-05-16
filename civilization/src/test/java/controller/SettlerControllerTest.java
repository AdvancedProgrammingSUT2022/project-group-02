package controller;

import model.*;
import org.junit.Before;
import org.junit.Test;

public class SettlerControllerTest {
    Maps maps = new Maps(25, 80);
    User user1 = new User("AmirHossein", "AmirHossein", "AmirHossein12");

    @Before
    public void setUp(){
        maps = new UsersController().readFromJsonMap();
        MapController mapController = new MapController(maps);
        for (Tile[] tiles : maps.getTileBoard()) {
            for (Tile tile : tiles) {
                mapController.setNeighbor(tile);
            }
        }
    }

    @Test //check Create New city with a settler
    public void checkCreateNewCity(){
        Tile tile = maps.getSpecificTile(5, 5);
        Settler settler = new Settler("Archer", null, 100, 10, 10, 1, 4, 5, 5,null, user1, 5, 3);
        SettlerController settlerController = new SettlerController();
        user1.setCapital(null);
        settlerController.createNewCity(settler, user1, tile, "City");
    }
}

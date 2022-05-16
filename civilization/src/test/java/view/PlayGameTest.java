package view;

import controller.MapController;
import controller.UsersController;
import model.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayGameTest {

    Maps maps = new Maps(25, 80);
    UsersController usersController = new UsersController();
    ArrayList<User> users = new ArrayList<>();
    User user1 = new User("AmirHossein", "AmirHossein", "AmirHossein12");
    User user2 = new User("Mohammad", "Mohammad", "Mohammad12");
    User user3 = new User("Shayan", "Shayan", "Shayan12");
    MilitaryUnit meleeUnit = new MilitaryUnit("swordMan", maps.getSpecificTile(4, 5), 2, 2, 2, 1, 2, 2, 0,user1, 2, 2);
    MilitaryUnit rangeUnit = new MilitaryUnit("swordMan", maps.getSpecificTile(4, 5), 2, 2, 2, 1, 2, 2, 2,user1, 2, 2);
    MilitaryUnit defMeleeUnit = new MilitaryUnit("swordMan", maps.getSpecificTile(5, 5), 2, 2, 2, 1, 2, 2, 0,user1, 2, 2);
    MilitaryUnit defRangeUnit = new MilitaryUnit("swordMan", maps.getSpecificTile(5, 5), 2, 2, 2, 1, 2, 2, 2,user1, 2, 2);
    @Before
    public void SetUp() {
        usersController.addUser(user1);
        usersController.addUser(user2);
        usersController.addUser(user3);
    }

    @Test // city has melee military unit
    public void checkAttackCity1(){
        maps = usersController.readFromJsonMap();
        MapController mapController = new MapController(maps);
        City city = new City("nameOfCity", maps.getSpecificTile(5, 5), user1, null, 100, 100, null, null,
                50, 1, 1, 1, 1, 1, 1, 1, 1,
                null, null, false, null, 20);
        for (Tile[] tiles : maps.getTileBoard()) {
            for (Tile tile : tiles) {
                mapController.setNeighbor(tile);
            }
        }
        PlayGame playGame = new PlayGame(users, maps, null, null);
        Scanner scanner = new Scanner("attack city -x 5 -y 5\ncity war exit\ntile exit");
        maps.getSpecificTile(5 , 5).setCity(city);
        Tile tile = maps.getSpecificTile(4, 5);
        tile.setMilitaryUnitExists(true);
        tile.setMilitaryUnit(meleeUnit);
        playGame.selectedTile(scanner, tile, 5, 5, user1);
    }

    @Test // city has range military unit
    public void checkAttackCity2(){
        maps = usersController.readFromJsonMap();
        MapController mapController = new MapController(maps);
        City city = new City("nameOfCity", maps.getSpecificTile(5, 5), user1, null, 100, 100, null, null,
                50, 1, 1, 1, 1, 1, 1, 1, 1,
                null, null, false, null, 20);
        for (Tile[] tiles : maps.getTileBoard()) {
            for (Tile tile : tiles) {
                mapController.setNeighbor(tile);
            }
        }
        PlayGame playGame = new PlayGame(users, maps, null, null);
        Scanner scanner = new Scanner("attack city -x 5 -y 5\ncity war exit\ncity war exit\ncity war exit\ntile exit");
        maps.getSpecificTile(5 , 5).setCity(city);
        Tile tile = maps.getSpecificTile(4, 5);
        tile.setMilitaryUnitExists(true);
        tile.setMilitaryUnit(rangeUnit);
        playGame.selectedTile(scanner, tile, 5, 5, user1);
    }

}

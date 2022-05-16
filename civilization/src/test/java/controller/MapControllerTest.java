package controller;

import model.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import view.enums.Colors;

import java.util.ArrayList;

public class MapControllerTest {
    User user1 = new User("AmirHossein", "AmirHossein", "AmirHossein12");
    Maps maps = new Maps(25, 80);
    MapController mapController;
    @Before
    public void setUp(){
        UsersController usersController = new UsersController();
        maps = usersController.readFromJsonMap();
        mapController = new MapController(maps);
    }


    @Test //when the game started we need to set all neighbors for all tiles
    public void checkSetNeighbor(){
         boolean checkBeforeRun = false;
         boolean checkAfterRun = false;
         if (maps.getSpecificTile(3 , 3).getNeighbors() == null)checkBeforeRun = true;
         mapController.setNeighbor(maps.getSpecificTile(3, 3));
         if (!maps.getSpecificTile(3, 3).getNeighbors().isEmpty())checkAfterRun = true;
         Assertions.assertTrue(checkAfterRun && checkBeforeRun);
    }

    @Test //find distance between two tiles for minimax
    public void checkFindDistance(){
        int wantedResult = 10;
        int result = mapController.findDistance(maps.getSpecificTile(5 , 5), maps.getSpecificTile(15, 15));
        Assertions.assertEquals(wantedResult, result);
        result = mapController.findDistance(maps.getSpecificTile(15 , 15), maps.getSpecificTile(5, 5));
        Assertions.assertEquals(wantedResult, result);
    }

    @Test //find the best way to move a unit to another tile -> if destination be a neighbor
    public void checkBestChoiceAmongNeighbors(){
        for (Tile[] tiles : maps.getTileBoard()) {
            for (Tile tile : tiles) {
                mapController.setNeighbor(tile);
            }
        }
        Tile resultTile = maps.getSpecificTile(1, 0);
        Assertions.assertEquals(resultTile, mapController.bestChoiceAmongNeighbors(maps.getSpecificTile(0, 0),
                resultTile, false));
    }

    @Test //find the best wat to move a unit to another tile -> if destination not be a neighbor
    public void checkBestChoiceAmongNeighbors2(){
        for (Tile[] tiles : maps.getTileBoard()) {
            for (Tile tile : tiles) {
                mapController.setNeighbor(tile);
            }
        }
        Assertions.assertNull(mapController.bestChoiceAmongNeighbors(maps.getSpecificTile(0, 0),
                maps.getSpecificTile(5, 5), false));
    }

    @Test //set all visited and visible tiles for foc of war
    public void checkAddAllVisitedAndVisibleTiles(){
        maps.getSpecificTile(17, 17).setCivilianUnitExists(true);
        Worker worker = new Worker("Archer", maps.getSpecificTile(17, 17), 100, 10, 10, 1, 4, 5, 5,false, user1, 5, 3);
        maps.getSpecificTile(17, 17).setCivilianUnit(worker);
        for (Tile[] tiles : maps.getTileBoard()) {
            for (Tile tile : tiles) {
                mapController.setNeighbor(tile);
            }
        }
        mapController.addAllVisibleAndVisitedTiles(user1);
        Assertions.assertNotNull(user1.getVisible());
        Assertions.assertNotNull(user1.getVisited());
    }

    @Test //check tile improvement for map
    public void checkTileImprovement(){
        Tile tile = maps.getSpecificTile(10, 10);
        City city = new City("nameOfCity", tile, user1, null, 100, 100, null, null,
                50, 1, 1, 1, 1, 1, 1, 1, 1,
                null, null, false, null, 20);
        Improvement improvement = new Improvement("Farm", 0, 1, 0, 5, null, null);
        tile.setOwner(null);
        Assertions.assertEquals("   ", mapController.tileImprovement(tile));
        tile.setOwner(user1);
        tile.setImprovement(null);
        tile.setCity(null);
        Assertions.assertEquals("NIY", mapController.tileImprovement(tile));
        tile.setCity(city);
        Assertions.assertEquals("nam", mapController.tileImprovement(tile));
        tile.setCity(null);
        tile.setImprovement(improvement);
        Assertions.assertEquals("Far", mapController.tileImprovement(tile));
    }

    @Test //check tile owner
    public void checkTileOwner(){
        Tile tile = maps.getSpecificTile(10, 10);
        tile.setOwner(null);
        Assertions.assertEquals("   ", mapController.tileOwner(tile));
        tile.setOwner(user1);
        Assertions.assertEquals("Ami", mapController.tileOwner(tile));
    }

    @Test //check tile Civilian and Military unit
    public void checkTileUnit(){
        Tile tile = maps.getSpecificTile(10, 10);
        Worker worker = new Worker("Archer", tile, 100, 10, 10, 1, 4, 5, 5,false, user1, 5, 3);
        tile.setCivilianUnit(null);
        Assertions.assertEquals("  ", mapController.civilianUnit(tile));
        tile.setCivilianUnit(worker);
        Assertions.assertEquals("Ar", mapController.civilianUnit(tile));
        tile.setCivilianUnit(null);
        tile.setMilitaryUnit(null);
        Assertions.assertEquals("  ", mapController.militaryUnit(tile));
        tile.setMilitaryUnit(worker);
        Assertions.assertEquals("Ar", mapController.militaryUnit(tile));
    }

    @Test //check tile resources
    public void checkTileResource(){
        Tile tile = maps.getSpecificTile(10, 10);
        Resource Banana = new Resource("Banana", "Bonus", "Plantation", 0, 1, 0, 0);
        Assertions.assertEquals("   ", mapController.tileResource(tile, true));
        tile.setResource(Banana);
        Assertions.assertEquals("Ban", mapController.tileResource(tile, false));
    }

    @Test //check tile feature
    public void checkTileFeature(){
        Feature Jungle = new Feature("Jungle", 2, 1, 0.25, 0, 1);
        Tile jungleTile = new Tile(1, 1, user1, null, 1, false, null, null, Jungle);
        Assertions.assertEquals("  ", mapController.tileFeature(jungleTile, true));
        Assertions.assertEquals("Ju", mapController.tileFeature(jungleTile, false));
    }

    @Test //check color of user
    public void checkColorOfUser(){
        Tile tile = maps.getSpecificTile(10, 10);
        tile.setOwner(user1);
        user1.setColor("blue");
        Assertions.assertEquals("[0;34m", mapController.getColorOfTileOwner(tile));
        Assertions.assertEquals(Colors.BLUE, mapController.getColorOfTileOwner(tile));
    }

    @Test //check that river finder find river correct
    public void checkRiverFinder(){
        Tile tile = maps.getSpecificTile(0, 0);
        tile.setRiverBorder(null);
        Assertions.assertEquals("___________", mapController.riverFinder(tile, 0));
        Assertions.assertEquals("\\", mapController.riverFinder(tile, 1));
        Assertions.assertEquals("/", mapController.riverFinder(tile, 2));
        boolean[] riverBoarder = {true, true, true, true, true, true};
        tile.setRiverBorder(riverBoarder);
        Assertions.assertEquals("\u001B[44m___________\u001B[0m", mapController.riverFinder(tile, 0));
        Assertions.assertEquals("\u001B[44m\\\u001B[0m", mapController.riverFinder(tile, 1));
        Assertions.assertEquals("\u001B[44m/\u001B[0m", mapController.riverFinder(tile, 2));
        tile = maps.getSpecificTile(10, 10);
        Assertions.assertEquals("\u001B[42m___________\u001B[0m", mapController.riverFinder(tile, 0));
    }

    @Test //check delete units
    public void checkDeleteUnit(){
        Tile tile = maps.getSpecificTile(0, 0);
        Worker worker = new Worker("Archer", tile, 100, 10, 10, 1, 4, 5, 5,false, user1, 5, 3);
        tile.setMilitaryUnit(worker);
        tile.setCivilianUnit(worker);
        Unit unit1 = tile.getMilitaryUnit();
        Unit unit2 = tile.getCivilianUnit();
        mapController.deleteCivilian(tile);
        mapController.deleteMilitary(tile);
        Assertions.assertNotEquals(unit1, tile.getMilitaryUnit());
        Assertions.assertNotEquals(unit2, tile.getMilitaryUnit());
    }

    @Test //check the return neighbors of city
    public void checkTheNeighborsOfCity(){
        Tile tile = maps.getSpecificTile(5, 5);
        for (Tile[] tiles : maps.getTileBoard()) {
            for (Tile tile1 : tiles) {
                mapController.setNeighbor(tile1);
            }
        }
        City city = new City("nameOfCity", tile, user1, tile.getNeighbors(), 100, 100, null, null,
                50, 1, 1, 1, 1, 1, 1, 1, 1,
                null, null, false, null, 20);
        Assertions.assertFalse(tile.getNeighbors().containsAll(mapController.neighborOfCity(city)));
    }

    @Test //check settlers of users at the start
    public void checkStarterSettler(){
        User user2 = new User("Mohammad", "Mohammad", "Mohammad12");
        User user3 = new User("Shayan", "Shayan", "Shayan12");
        ArrayList<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        for (User user : users) {
            Assertions.assertTrue(user.getUnits().isEmpty());
        }
        mapController.firstSetOfSettlers(users);
        for (User user : users) {
            Assertions.assertFalse(user.getUnits().isEmpty());
        }
    }
}

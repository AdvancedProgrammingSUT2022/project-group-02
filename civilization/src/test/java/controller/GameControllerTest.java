package controller;

import model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mock;


import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class GameControllerTest {
    @Mock
    User user;

    @Mock
    Tile origin;

    @Mock
    Tile destination;

    @Mock
    Unit unit;

    User user1 = new User("AmirHossein", "AmirHossein", "AmirHossein12");
    User user2 = new User("Mohammad", "Mohammad", "Mohammad12");
    User user3 = new User("Shayan", "Shayan", "Shayan12");
    Maps map = new Maps(1, 1);
    GameController gameController;

    @Before
    public void setUp() throws Exception {
        ArrayList<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        gameController = new GameController(users, 2, map, 2, 2);
    }

    @Test
    public void increaseTurn() {
        int result1 = user1.getTurns();
        gameController.increaseTurn(2, user1);
        int result2 = user1.getTurns();
        Assert.assertEquals(result1 + 2, result2);
    }

    @Test
    public void increaseGold() {
        int result1 = user1.getGold();
        gameController.increaseGold(2, user1);
        int result2 = user1.getGold();
        Assert.assertEquals(result1 + 2, result2);
    }

    @Test
    public void increaseHappiness() {
        int result1 = user1.getHappiness();
        gameController.increaseHappiness(2, user1);
        int result2 = user1.getHappiness();
        Assert.assertEquals(result1 + 2, result2);
    }

    @Test
    public void increaseFood() {
        int result1 = user1.getFood();
        gameController.increaseFood(2, user1);
        int result2 = user1.getFood();
        Assert.assertEquals(result1 + 2, result2);
    }

    @Test
    public void increaseFaith() {
        int result1 = user1.getFaith();
        gameController.increaseFaith(2, user1);
        int result2 = user1.getFaith();
        Assert.assertEquals(result1 + 2, result2);
    }

    @Test
    public void increaseScience() {
        int result1 = user1.getScience();
        gameController.increaseScience(2, user1);
        int result2 = user1.getScience();
        Assert.assertEquals(result1 + 2, result2);
    }

    @Test
    public void increaseCapitalCitizens() {
        GameController gameController = mock(GameController.class);
        doNothing().when(gameController).increaseCapitalCitizens(2, user);
        gameController.increaseCapitalCitizens(2, user);
        verify(gameController, times(1)).increaseCapitalCitizens(2, user);
    }

    @Test
    public void increaseCapitalDefence() {
        GameController gameController = mock(GameController.class);
        doNothing().when(gameController).increaseCapitalCitizens(2, user);
        gameController.increaseCapitalCitizens(2, user);
        verify(gameController, times(1)).increaseCapitalCitizens(2, user);
    }

    @Test
    public void increaseCulture() {
        int result1 = user1.getCulture();
        gameController.increaseCulture(2, user1);
        int result2 = user1.getCulture();
        Assert.assertEquals(result1 + 2, result2);
    }

    @Test
    public void decreaseResearchTurnLeft() {
        int result1 = user1.getResearchTurnLeft();
        gameController.decreaseResearchTurnLeft(2, user1);
        int result2 = user1.getResearchTurnLeft();
        Assert.assertEquals(result1 - 2, result2);
    }

    @Test
    public void findTile() {
        Maps map = new Maps(2, 2);
        Tile tile = gameController.findTile(4, 2);
        Assert.assertEquals(null, tile);
    }

    @Test
    public void moveMilitary() {
        Tile origin = new Tile(0, 0, user1, null, 1, false, null, null, null);
        Tile destination = new Tile(0, 0, user2, null, 1, false, null, null, null);
        Unit militaryUnit = new MilitaryUnit("settler", origin, 0, 0, 0, 0, 0, 0, 0, user1, 0, 0);
        gameController.moveUnit(origin, destination, militaryUnit, true);
        Assert.assertEquals(militaryUnit, destination.getMilitaryUnit());
    }

    @Test
    public void moveCivilian() {
        Tile origin = new Tile(0, 0, user1, null, 1, false, null, null, null);
        Tile destination = new Tile(0, 0, user2, null, 1, false, null, null, null);
        Unit civilianUnit = new Civilian("settler", origin, 0, 0, 0, 0, 0, 0, 0, user1, 0, 0);
        gameController.moveUnit(origin, destination, civilianUnit, false);
        Assert.assertEquals(civilianUnit, destination.getCivilianUnit());
    }

    @Test
    public void checkFindProduct(){
        UsersController usersController = new UsersController();
        Maps maps = usersController.readFromJsonMap();
        MapController mapController = new MapController(maps);
        for (Tile[] tiles : maps.getTileBoard()) {
            for (Tile tile : tiles) {
                mapController.setNeighbor(tile);
            }
        }
        Tile tile1 = maps.getSpecificTile(5, 5);
        Unit meleeMilitary = new MilitaryUnit("name", tile1, 0, 0, 0, 0, 0, 0, 0, user1, 0, 0);
        Settler settler = new Settler("settler", origin, 2, 2, 2, 2, 2, 2, 2, null, user1, 0, 0);
        MeleeMilitaryUnit scout = new MeleeMilitaryUnit("scout", origin, 2, 2, 2, 2, 2, 2, 2, user1, 0, 0);
        Worker worker = new Worker("worker", origin, 2, 2, 2, 2, 2, 2, 2, true, user1, 0, 0);
        Unit rangeMilitary = new MilitaryUnit("name", tile1, 0, 0, 0, 0, 0, 0, 2, user1, 0, 0);
        City city1 = new City("nameOfCity", tile1, user1, null, 100, 100, null, null,
                50, 1, 1, 1, 1, 1, 1, 1, 1,
                null, null, false, null, 20);
        SettlerController settlerController = new SettlerController();
        Product product1 = new Product("worker", 5);
        Product product2 = new Product("settler", 5);
        Product product3 = new Product("scout", 5);
        Product product4 = new Product("name", 5);

        settlerController.addBasicProducts(city1);
        settlerController.addBasicUnits(city1);
        city1.addPossibleUnit(rangeMilitary);
        city1.addPossibleUnit(meleeMilitary);
        gameController.findProduction(city1, product1);
        gameController.findProduction(city1, product2);
        gameController.findProduction(city1, product3);
        gameController.findProduction(city1, product4);
    }

    @Test
    public void cityTurnProducts() {
        Tile tile = new Tile(0, 0, user1, null, 1, false, null, null, null);
        City city1 = new City("nameOfCity", tile, user1, null, 100, 100, null, null,
                50, 1, 1, 1, 1, 1, 1, 1, 1,
                null, null, false, null, 20);
        City city2 = new City("nameOfCity", tile, user1, null, 100, 100, null, null,
                50, 1, 1, 1, 1, 1, 1, 1, 1,
                null, null, false, null, 20);
        City city3 = new City("nameOfCity", tile, user1, null, 100, 100, null, null,
                50, 1, 1, 1, 1, 1, 1, 1, 1,
                null, null, false, null, 20);
        City city4 = new City("nameOfCity", tile, user1, null, 100, 100, null, null,
                50, 1, 1, 1, 1, 1, 1, 1, 1,
                null, null, false, null, 20);

        city1.setProductStatus(true);
        city2.setProductStatus(true);
        city3.setProductStatus(true);
        city4.setProductStatus(true);

        ArrayList<City> cities = new ArrayList<>();
        cities.add(city1);
        cities.add(city2);
        cities.add(city3);
        cities.add(city4);

        user1.setCities(cities);
        gameController.cityTurnProducts(user1);
        Assert.assertEquals(null, cities.get(0).getCurrentProduction());
    }

    @Test
    public void userTurnResearch() {
        user1.setResearching(true);
        user1.setResearchTurnLeft(1);
        user1.setColor("blue");
        Tile tile1 = new Tile(0, 0, user1, null, 1, false, null, null, null);
        Improvement improvement1 = new Improvement("name", 2, 2, 2, 2, null, null);
        City city1 = new City("nameOfCity", tile1, user1, null, 100, 100, null, null,
                50, 1, 1, 1, 1, 1, 1, 1, 1,
                null, null, false, null, 20);
        SettlerController settlerController = new SettlerController();
        settlerController.addBasicProducts(city1);
        settlerController.addBasicUnits(city1);
        user1.addCity(city1);
        ArrayList<Improvement> improvements = new ArrayList<>();
        improvements.add(improvement1);
        improvement1.setTile(tile1);
        Unit militaryUnit1 = new MilitaryUnit("settler", tile1, 0, 0, 0, 0, 0, 0, 0, user1, 0, 0);
        Unit militaryUnit3 = new MilitaryUnit("settler", tile1, 0, 0, 0, 0, 0, 2, 2, user1, 0, 0);
        ArrayList<Unit> units = new ArrayList<>();
        units.add(militaryUnit1);
        units.add(militaryUnit3);
        Technology technology = new Technology("name", improvements, 0, 0, units);
        user1.setCurrentTechnology(technology);
        gameController.userTurnResearch(user1);
        Assert.assertNull(user1.getCurrentTechnology());
        user1.setResearchTurnLeft(2);
        gameController.userTurnResearch(user1);
        Assert.assertNull(user1.getCurrentTechnology());
    }

    @Test
    public void userTurnWorker() {
        Worker worker = new Worker("worker", origin, 2, 2, 2, 2, 2, 2, 2, true, user1, 0, 0);
        ArrayList<Unit> units = new ArrayList<>();
        Feature Jungle = new Feature("Jungle", 2, 1, 0.25, 0, 1);
        ArrayList<Resource> resources = new ArrayList<>();
        Resource resource = new Resource("Sheep", "Bonus", "Pasture", 0, 2, 0, 0);
        resources.add(resource);
        Tile tile = new Tile(0, 0, user1, null, 1, false, null, resource, Jungle);
        Improvement improvement1 = new Improvement("Farm", 2, 2, 2, 2, resources, null);
        units.add(worker);
        worker.setWorkingStatus(true);
        worker.setRemainingTurnsToComplete(1);
        worker.setTile(tile);
        worker.setImprovement(improvement1);
        user1.setUnits(units);
        user1.setColor("blue");
        gameController.userTurnWorker(user1);
        Assert.assertNotNull(worker.getTile().getImprovement());
        worker.setRemainingTurnsToComplete(5);
        gameController.userTurnWorker(user1);
        Assert.assertNotNull(worker.getTile().getImprovement());
    }

    @Test
    public void increaseCitizens() {
        Tile tile = new Tile(0, 0, user1, null, 1, false, null, null, null);
        Citizen citizen = new Citizen(tile);
        ArrayList<Citizen> citizens = new ArrayList<>();
        citizens.add(citizen);
        City city1 = new City("nameOfCity", tile, user1, null, 100, 100, null, null,
                50, 1, 1, 1, 1, 1, 1, 1, 1,
                null, null, false, citizens, 20);
        City city2 = new City("nameOfCity", tile, user1, null, 100, 100, null, null,
                50, 1, 1, 1, 1, 1, 1, 1, 1,
                null, null, false, citizens, 20);
        city1.setTurnNumber(15);
        city1.setCitizensNumber(15);
        city2.setTurnNumber(15);
        city2.setCitizensNumber(15);
        user1.addCity(city2);
        user1.addCity(city1);
        user1.setColor("blue");
        int result1 = user1.getUnhappiness();
        gameController.increaseCitizens(user1);
        int result2 = user1.getUnhappiness();
        Assert.assertEquals(result1, result2);
    }

    @Test
    public void usersIncomeHandling() {
        Maps map = new Maps(25, 80);
        Tile tile1 = new Tile(0, 0, user1, null, 1, false, null, null, null);
        City city1 = new City("nameOfCity", tile1, user1, null, 100, 100, null, null,
                50, 1, 1, 1, 1, 1, 1, 1, 1,
                null, null, false, null, 20);
        user1.addCity(city1);
        Improvement improvement1 = new Improvement("name", 2, 2, 2, 2, null, null);
        improvement1.setTile(tile1);
        user1.addImprovement(improvement1);
        Unit militaryUnit1 = new MilitaryUnit("settler", tile1, 0, 0, 0, 0, 0, 0, 0, user1, 0, 0);
        user1.addTerritory(tile1);
        user1.addUnit(militaryUnit1);
        user1.setGold(-15);
        tile1.setRoad(true);
        int result1 = user1.getScience();
        gameController.usersIncomeHandling(user1, map);
        int result2 = user1.getScience();
        Assert.assertNotEquals(result1 + 4, result2);
    }

    @Test
    public void userHappiness() {
        Feature Jungle = new Feature("Jungle", 2, 1, 0.25, 0, 1);
        Tile tile = new Tile(0, 0, user1, null, 1, false, null, null, Jungle);
        ArrayList<Citizen> citizens = new ArrayList<>();
        citizens.add(new Citizen(tile));
        City city1 = new City("nameOfCity", tile, user1, null, 100, 100, null, null,
                50, 1, 1, 1, 1, 1, 1, 1, 1,
                null, null, false, citizens, 20);
        Resource resource1 = new Resource("name","Luxury","improvement",2,2,2,2);
        city1.setUnhappinessEffect(false);
        user1.addCity(city1);
        user1.addAnnexedCity(city1);
        user1.addFoundResourced(resource1);
        user1.addAvailableResource(resource1);
        int result1 = user1.getUnhappiness();
        gameController.userHappiness(user1);
        int result2 = user1.getUnhappiness();
        Assert.assertNotEquals(result1 + 5*7, result2);
    }

    @Test
    public void citiesIncome() {
        Terrain Hill = new Terrain("Hill", "purple", 2, 0, 0.25, 0, 2, true);
        Feature Jungle = new Feature("Jungle", 2, 1, 0.25, 0, 1);
        Tile tile = new Tile(0, 0, user1, Hill, 1, false, null, null, Jungle);
        Citizen citizen1 = new Citizen(tile);
        ArrayList<Citizen> citizens = new ArrayList<>();
        citizens.add(citizen1);
        City city1 = new City("nameOfCity", tile, user1, null, 100, 100, null, null,
                50, 1, 1, 1, 1, 1, 1, 1, 1,
                null, null, false, citizens, 20);
        user1.addCity(city1);
        int result1 = user1.getFood();
        gameController.citiesIncome(user1);
        int result2 = user1.getFood();
        Assert.assertEquals(result1, result2);
    }

    @Test
    public void findCivilianTile(){
        UsersController usersController = new UsersController();
        Maps maps = usersController.readFromJsonMap();
        MapController mapController = new MapController(maps);
        for (Tile[] tiles : maps.getTileBoard()) {
            for (Tile tile : tiles) {
                mapController.setNeighbor(tile);
            }
        }
        Tile tile1 = maps.getSpecificTile(10, 65);
        tile1.setCivilianUnitExists(true);
        Assertions.assertNotNull(gameController.findTileForCivilian(tile1));
        tile1.setCivilianUnitExists(false);
        Assertions.assertNotNull(gameController.findTileForCivilian(tile1));
        tile1.setMilitaryUnitExists(true);
        Assertions.assertNotNull(gameController.findTileForMilitary(tile1));
    }

    @Test
    public void checkMakeAllUnderOrdered() {
        UsersController usersController = new UsersController();
        Maps maps = usersController.readFromJsonMap();
        MapController mapController = new MapController(maps);
        for (Tile[] tiles : maps.getTileBoard()) {
            for (Tile tile : tiles) {
                mapController.setNeighbor(tile);
            }
        }
        Tile tile1 = maps.getSpecificTile(10, 65);
        Unit militaryUnit1 = new MilitaryUnit("settler", tile1, 0, 0, 0, 0, 0, 0, 0, user1, 0, 0);
        Unit militaryUnit2 = new MilitaryUnit("settler", tile1, 0, 0, 0, 0, 0, 0, 0, user1, 0, 0);
        Unit militaryUnit3 = new MilitaryUnit("settler", maps.getSpecificTile(12, 65), 0, 0, 0, 0, 0, 0, 0, user2, 0, 0);
        maps.getSpecificTile(12, 65).setMilitaryUnit(militaryUnit3);
        maps.getSpecificTile(12, 65).setMilitaryUnitExists(true);
        militaryUnit1.setAlert(false);
        militaryUnit1.setSleep(false);
        militaryUnit1.setAlert(true);
        user1.addUnit(militaryUnit2);
        user1.addUnit(militaryUnit1);
        gameController.makeAllUnOrdered(user1);
    }

    @Test
    public void checkFoundCity(){
        UsersController usersController = new UsersController();
        Maps maps = usersController.readFromJsonMap();
        MapController mapController = new MapController(maps);
        for (Tile[] tiles : maps.getTileBoard()) {
            for (Tile tile : tiles) {
                mapController.setNeighbor(tile);
            }
        }
        Tile tile1 = maps.getSpecificTile(10, 65);
        Tile tile2 = maps.getSpecificTile(12, 65);
        City city1 = new City("nameOfCity", tile2, user2, null, 100, 100, null, null,
                50, 1, 1, 1, 1, 1, 1, 1, 1,
                null, null, false, null, 20);
        Unit militaryUnit1 = new MilitaryUnit("settler", tile1, 0, 0, 0, 0, 0, 0, 0, user1, 0, 0);
        tile2.setCity(city1);
        tile1.setOwner(user1);
        tile2.setOwner(user2);
        user1.addTerritory(tile1);
        user1.addUnit(militaryUnit1);
        gameController.foundCity(user1);
    }
}
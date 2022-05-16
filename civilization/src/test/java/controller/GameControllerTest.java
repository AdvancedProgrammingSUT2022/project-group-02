package controller;

import model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
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
        Tile tile2 = new Tile(0, 0, user1, null, 1, false, null, null, null);
        Tile tile3 = new Tile(0, 0, user1, null, 1, false, null, null, null);
        Tile tile4 = new Tile(0, 0, user1, null, 1, false, null, null, null);

        Improvement improvement1 = new Improvement("name", 2, 2, 2, 2, null, null);
        Improvement improvement2 = new Improvement("name", 2, 2, 2, 2, null, null);
        Improvement improvement3 = new Improvement("name", 2, 2, 2, 2, null, null);
        Improvement improvement4 = new Improvement("name", 2, 2, 2, 2, null, null);

        ArrayList<Improvement> improvements = new ArrayList<>();
        improvements.add(improvement1);
        improvements.add(improvement2);
        improvements.add(improvement3);
        improvements.add(improvement4);
        improvement1.setTile(tile1);
        improvement2.setTile(tile2);
        improvement3.setTile(tile3);
        improvement4.setTile(tile4);
        Unit militaryUnit1 = new MilitaryUnit("settler", tile1, 0, 0, 0, 0, 0, 0, 0, user1, 0, 0);
        Unit militaryUnit2 = new MilitaryUnit("settler", tile1, 0, 0, 0, 0, 0, 0, 0, user1, 0, 0);
        Unit militaryUnit3 = new MilitaryUnit("settler", tile1, 0, 0, 0, 0, 0, 0, 0, user1, 0, 0);
        Unit militaryUnit4 = new MilitaryUnit("settler", tile1, 0, 0, 0, 0, 0, 0, 0, user1, 0, 0);
        ArrayList<Unit> units = new ArrayList<>();
        units.add(militaryUnit1);
        units.add(militaryUnit2);
        units.add(militaryUnit3);
        units.add(militaryUnit4);
        Technology technology = new Technology("name", improvements, 0, 0, units);

        user1.setCurrentTechnology(technology);
        gameController.userTurnResearch(user1);
        Assert.assertEquals(null, user1.getCurrentTechnology());
    }

    @Test
    public void userTurnWorker() {
        Unit worker = new Worker("worker", origin, 2, 2, 2, 2, 2, 2, 2, true, user1, 0, 0);
        Unit militaryUnit1 = new MilitaryUnit("settler", origin, 0, 0, 0, 0, 0, 0, 0, user1, 0, 0);
        Unit militaryUnit2 = new MilitaryUnit("settler", origin, 0, 0, 0, 0, 0, 0, 0, user1, 0, 0);
        Unit militaryUnit3 = new MilitaryUnit("settler", origin, 0, 0, 0, 0, 0, 0, 0, user1, 0, 0);
        Unit militaryUnit4 = new MilitaryUnit("settler", origin, 0, 0, 0, 0, 0, 0, 0, user1, 0, 0);

        Tile tile = new Tile(0, 0, user1, null, 1, false, null, null, null);
        ArrayList<Unit> units = new ArrayList<>();

        units.add(militaryUnit1);
        units.add(militaryUnit2);
        units.add(militaryUnit3);
        units.add(militaryUnit4);
        units.add(worker);
        worker.setTile(tile);
        user1.setUnits(units);
        gameController.userTurnResearch(user1);
        Assert.assertEquals(null, worker.getTile().getImprovement());
    }

    @Test
    public void increaseCitizens() {
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
        city1.setTurnNumber(15);
        city1.setCitizensNumber(15);
        city2.setTurnNumber(15);
        city2.setCitizensNumber(15);
        city3.setTurnNumber(15);
        city3.setCitizensNumber(15);
        city4.setTurnNumber(15);
        city4.setCitizensNumber(15);
        ArrayList<City> cities = new ArrayList<>();
        cities.add(city1);
        cities.add(city2);
        cities.add(city3);
        cities.add(city4);

        int result1 = user1.getUnhappiness();
        gameController.increaseCitizens(user1);
        int result2 = user1.getUnhappiness();
        Assert.assertEquals(result1, result2);
    }

    @Test
    public void usersIncomeHandling() {
        Maps map = new Maps(1, 1);
        user1.setGoldPerTurn(0);
        user1.setFoodPerTurn(0);
        user1.setProductPerTurn(0);
        user1.setSciencePerTurn(0);

        Tile tile1 = new Tile(0, 0, user1, null, 1, false, null, null, null);
        Tile tile2 = new Tile(0, 0, user1, null, 1, false, null, null, null);
        Tile tile3 = new Tile(0, 0, user1, null, 1, false, null, null, null);
        Tile tile4 = new Tile(0, 0, user1, null, 1, false, null, null, null);

        City city1 = new City("nameOfCity", tile1, user1, null, 100, 100, null, null,
                50, 1, 1, 1, 1, 1, 1, 1, 1,
                null, null, false, null, 20);
        City city2 = new City("nameOfCity", tile2, user1, null, 100, 100, null, null,
                50, 1, 1, 1, 1, 1, 1, 1, 1,
                null, null, false, null, 20);
        City city3 = new City("nameOfCity", tile3, user1, null, 100, 100, null, null,
                50, 1, 1, 1, 1, 1, 1, 1, 1,
                null, null, false, null, 20);
        City city4 = new City("nameOfCity", tile4, user1, null, 100, 100, null, null,
                50, 1, 1, 1, 1, 1, 1, 1, 1,
                null, null, false, null, 20);

        ArrayList<City> cities = new ArrayList<>();
        cities.add(city1);
        cities.add(city2);
        cities.add(city3);
        cities.add(city4);

        Improvement improvement1 = new Improvement("name", 2, 2, 2, 2, null, null);
        Improvement improvement2 = new Improvement("name", 2, 2, 2, 2, null, null);
        Improvement improvement3 = new Improvement("name", 2, 2, 2, 2, null, null);
        Improvement improvement4 = new Improvement("name", 2, 2, 2, 2, null, null);

        ArrayList<Improvement> improvements = new ArrayList<>();
        improvements.add(improvement1);
        improvements.add(improvement2);
        improvements.add(improvement3);
        improvements.add(improvement4);
        improvement1.setTile(tile1);
        improvement2.setTile(tile2);
        improvement3.setTile(tile3);
        improvement4.setTile(tile4);

        Unit militaryUnit1 = new MilitaryUnit("settler", tile1, 0, 0, 0, 0, 0, 0, 0, user1, 0, 0);
        Unit militaryUnit2 = new MilitaryUnit("settler", tile1, 0, 0, 0, 0, 0, 0, 0, user1, 0, 0);
        Unit militaryUnit3 = new MilitaryUnit("settler", tile1, 0, 0, 0, 0, 0, 0, 0, user1, 0, 0);
        Unit militaryUnit4 = new MilitaryUnit("settler", tile1, 0, 0, 0, 0, 0, 0, 0, user1, 0, 0);


        ArrayList<Tile> tiles = new ArrayList<>();
        tiles.add(tile1);
        tiles.add(tile2);
        tiles.add(tile3);
        tiles.add(tile4);
        ArrayList<Unit> units = new ArrayList<>();
        units.add(militaryUnit1);
        units.add(militaryUnit2);
        units.add(militaryUnit3);
        units.add(militaryUnit4);

        user1.setImprovements(improvements);
        user1.setCities(cities);
        user1.setTerritory(tiles);
        user1.setGold(-2);
        user1.setUnits(units);
        int result1 = user1.getScience();
        gameController.usersIncomeHandling(user1, map);
        int result2 = user1.getScience();
        Assert.assertEquals(result1 + 4, result2);
    }

    @Test
    public void userHappiness() {
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
        City city5 = new City("nameOfCity", tile, user1, null, 100, 100, null, null,
                50, 1, 1, 1, 1, 1, 1, 1, 1,
                null, null, false, null, 20);
        Resource resource1 = new Resource("name","type","improvment",2,2,2,2);
        Resource resource2 = new Resource("name","type","improvment",2,2,2,2);
        Resource resource3 = new Resource("name","type","improvment",2,2,2,2);
        Resource resource4 = new Resource("name","type","improvment",2,2,2,2);
        Resource resource5 = new Resource("name","type","improvment",2,2,2,2);

        ArrayList<Resource> resources = new ArrayList<>();
        resources.add(resource1);
        resources.add(resource2);
        resources.add(resource3);
        resources.add(resource4);
        resources.add(resource5);
        user1.setFoundResources(resources);

        city1.setUnhappinessEffect(false);
        city2.setUnhappinessEffect(false);
        city3.setUnhappinessEffect(false);
        city4.setUnhappinessEffect(false);
        city5.setUnhappinessEffect(false);

        ArrayList<City> cities = new ArrayList<>();
        cities.add(city1);
        cities.add(city2);
        cities.add(city3);
        cities.add(city4);
        cities.add(city5);

        user1.setCities(cities);
        user1.setAnnexedCities(cities);
        int result1 = user1.getUnhappiness();
        gameController.userHappiness(user1);
        int result2 = user1.getUnhappiness();
        Assert.assertEquals(result1 + 5*7, result2);
    }

    @Test
    public void citiesIncome() {
        Terrain Hill = new Terrain("Hill", "purple", 2, 0, 0.25, 0, 2, true);
        Tile tile = new Tile(0, 0, user1, Hill, 1, false, null, null, null);
        City city1 = new City("nameOfCity", tile, user1, null, 100, 100, null, null,
                50, 1, 1, 1, 1, 1, 1, 1, 1,
                null, null, false, null, 20);
        City city2 = new City("nameOfCity", tile, user1, null, 100, 100, null, null,
                50, 1, 1, 1, 1, 1, 1, 1, 1,
                null, null, false, null, 20);
        City city3 = new City("nameOfCity", tile, user1, null, 100, 100, null, null,
                50, 1, 1, 1, 1, 1, 1, 1, 1,
                null, null, false, null, 20);
        city1.setUnhappinessEffect(false);
        city2.setUnhappinessEffect(false);
        city3.setUnhappinessEffect(false);

        ArrayList<City> cities = new ArrayList<>();
        cities.add(city1);
        cities.add(city2);
        cities.add(city3);
        Citizen citizen1 = new Citizen(tile);
        Citizen citizen2 = new Citizen(tile);
        Citizen citizen3 = new Citizen(tile);
        Citizen citizen4 = new Citizen(tile);
        Citizen citizen5 = new Citizen(tile);
        Citizen citizen6 = new Citizen(tile);
        Citizen citizen7 = new Citizen(tile);

        ArrayList<Citizen> citizens = new ArrayList<>();
        citizens.add(citizen1);
        citizens.add(citizen2);
        citizens.add(citizen3);
        citizens.add(citizen4);
        citizens.add(citizen5);
        citizens.add(citizen6);
        citizens.add(citizen7);
        city1.setCitizens(citizens);
        city1.setProduction(0);
        city1.setFood(0);
        city1.setGold(0);
        city2.setCitizens(citizens);
        city2.setProduction(0);
        city2.setFood(0);
        city2.setGold(0);
        city3.setCitizens(citizens);
        city3.setProduction(0);
        city3.setFood(0);
        city3.setGold(0);
        user1.setCities(cities);
        int result1 = user1.getFood();
        gameController.citiesIncome(user1);
        int result2 = user1.getFood();
        Assert.assertEquals(result1, result2);
    }
}
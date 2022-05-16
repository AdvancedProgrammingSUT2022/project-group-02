package controller;

import model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import view.CityMenu;
import view.UserPanel;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import static org.junit.Assert.*;
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
        City city = new City("nameOfCity", tile, user1, null, 100, 100, null, null,
                50, 1, 1, 1, 1, 1, 1, 1, 1,
                null, null, false, null, 20);
        ArrayList<City> cities = new ArrayList<>();
        cities.add(city);
        user1.setCities(cities);
        gameController.cityTurnProducts(user1);
        Assert.assertEquals(null, cities.get(0).getCurrentProduction());
    }

    @Test
    public void userTurnResearch() {
        user1.setResearching(true);
        user1.setResearchTurnLeft(1);
        user1.setColor("blue");
        Technology technology = new Technology("name", null, 0, 0, null);
        user1.setCurrentTechnology(technology);
        gameController.userTurnResearch(user1);
        Assert.assertEquals(null, user1.getCurrentTechnology());
    }

    @Test
    public void userTurnWorker() {
        Unit worker = new Worker("worker", origin, 2, 2, 2, 2, 2, 2, 2, true, user1, 0, 0);
        Unit militaryUnit = new MilitaryUnit("settler", origin, 0, 0, 0, 0, 0, 0, 0, user1, 0, 0);
        Tile tile = new Tile(0, 0, user1, null, 1, false, null, null, null);
        ArrayList<Unit> units = new ArrayList<>();
        units.add(militaryUnit);
        units.add(worker);
        worker.setTile(tile);
        user1.setUnits(units);
        gameController.userTurnResearch(user1);
        Assert.assertEquals(null, worker.getTile().getImprovement());
    }

    @Test
    public void increaseCitizens() {
        Tile tile = new Tile(0, 0, user1, null, 1, false, null, null, null);
        City city = new City("nameOfCity", tile, user1, null, 100, 100, null, null,
                50, 1, 1, 1, 1, 1, 1, 1, 1,
                null, null, false, null, 20);
        city.setTurnNumber(15);
        city.setCitizensNumber(15);
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

        Tile tile = new Tile(0, 0, user1, null, 1, false, null, null, null);
        City city = new City("nameOfCity", tile, user1, null, 100, 100, null, null,
                50, 1, 1, 1, 1, 1, 1, 1, 1,
                null, null, false, null, 20);
        ArrayList<City> cities = new ArrayList<>();
        cities.add(city);
        Improvement improvement = new Improvement("name", 2, 2, 2, 2, null, null);
        ArrayList<Improvement> improvements = new ArrayList<>();
        improvements.add(improvement);
        improvement.setTile(tile);
        user1.setImprovements(improvements);
        user1.setCities(cities);
        int result1 = user1.getScience();
        gameController.usersIncomeHandling(user1, map);
        int result2 = user1.getScience();
        Assert.assertEquals(result1 + 4, result2);
    }

    @Test
    public void userHappiness() {
        Tile tile = new Tile(0, 0, user1, null, 1, false, null, null, null);
        City city = new City("nameOfCity", tile, user1, null, 100, 100, null, null,
                50, 1, 1, 1, 1, 1, 1, 1, 1,
                null, null, false, null, 20);
        city.setUnhappinessEffect(false);
        ArrayList<City> cities = new ArrayList<>();
        cities.add(city);
        user1.setCities(cities);
        int result1 = user1.getUnhappiness();
        gameController.userHappiness(user1);
        int result2 = user1.getUnhappiness();
        Assert.assertEquals(result1 + 3, result2);
    }

    @Test
    public void citiesIncome() {
        Terrain Hill = new Terrain("Hill", "purple", 2, 0, 0.25, 0, 2, true);
        Tile tile = new Tile(0, 0, user1, Hill, 1, false, null, null, null);
        City city = new City("nameOfCity", tile, user1, null, 100, 100, null, null,
                50, 1, 1, 1, 1, 1, 1, 1, 1,
                null, null, false, null, 20);
        city.setUnhappinessEffect(false);
        ArrayList<City> cities = new ArrayList<>();
        cities.add(city);
        Citizen citizen = new Citizen(tile);
        ArrayList<Citizen> citizens = new ArrayList<>();
        citizens.add(citizen);
        city.setCitizens(citizens);
        city.setProduction(0);
        city.setFood(0);
        city.setGold(0);
        user1.setCities(cities);
        int result1 = user1.getFood();
        gameController.citiesIncome(user1);
        int result2 = user1.getFood();
        Assert.assertEquals(result1, result2);
    }
}
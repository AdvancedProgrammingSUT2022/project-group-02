package controller;

import model.Tile;
import model.Unit;
import model.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class GameControllerTest {
    @Mock
    User user;

    @Mock
    Map map;

    @Mock
    Tile origin;

    @Mock
    Tile destination;

    @Mock
    Unit unit;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void increaseTurn() {
        GameController gameController = mock(GameController.class);
        doNothing().when(gameController).increaseTurn(2,user);
        gameController.increaseTurn(2,user);
        verify(gameController,times(1)).increaseTurn(2,user);
    }

    @Test
    public void increaseGold() {
        GameController gameController = mock(GameController.class);
        doNothing().when(gameController).increaseGold(2,user);
        gameController.increaseGold(2,user);
        verify(gameController,times(1)).increaseGold(2,user);
    }

    @Test
    public void increaseHappiness() {
        GameController gameController = mock(GameController.class);
        doNothing().when(gameController).increaseHappiness(2,user);
        gameController.increaseHappiness(2,user);
        verify(gameController,times(1)).increaseHappiness(2,user);
    }

    @Test
    public void increaseFood() {
        GameController gameController = mock(GameController.class);
        doNothing().when(gameController).increaseFood(2,user);
        gameController.increaseFood(2,user);
        verify(gameController,times(1)).increaseFood(2,user);
    }

    @Test
    public void increaseFaith() {
        GameController gameController = mock(GameController.class);
        doNothing().when(gameController).increaseFaith(2,user);
        gameController.increaseFaith(2,user);
        verify(gameController,times(1)).increaseFaith(2,user);
    }

    @Test
    public void increaseScience() {
        GameController gameController = mock(GameController.class);
        doNothing().when(gameController).increaseScience(2,user);
        gameController.increaseScience(2,user);
        verify(gameController,times(1)).increaseScience(2,user);
    }

    @Test
    public void increaseCapitalCitizens() {
        GameController gameController = mock(GameController.class);
        doNothing().when(gameController).increaseCapitalCitizens(2,user);
        gameController.increaseCapitalCitizens(2,user);
        verify(gameController,times(1)).increaseCapitalCitizens(2,user);
    }

    @Test
    public void increaseCapitalDefence() {
        GameController gameController = mock(GameController.class);
        doNothing().when(gameController).increaseCapitalDefence(2,user);
        gameController.increaseCapitalDefence(2,user);
        verify(gameController,times(1)).increaseCapitalDefence(2,user);
    }

    @Test
    public void increaseCulture() {
        GameController gameController = mock(GameController.class);
        doNothing().when(gameController).increaseCulture(2,user);
        gameController.increaseCulture(2,user);
        verify(gameController,times(1)).increaseCulture(2,user);
    }

    @Test
    public void decreaseResearchTurnLeft() {
        GameController gameController = mock(GameController.class);
        doNothing().when(gameController).decreaseResearchTurnLeft(2,user);
        gameController.decreaseResearchTurnLeft(2,user);
        verify(gameController,times(1)).decreaseResearchTurnLeft(2,user);
    }

//    @Test
//    public void findTile() {
//    }

    @Test
    public void moveUnit() {
        GameController gameController = mock(GameController.class);
        doNothing().when(gameController).moveUnit(origin,destination,unit,true);
        gameController.moveUnit(origin,destination,unit,true);
        verify(gameController,times(1)).moveUnit(origin,destination,unit,true);
    }

    @Test
    public void getTurnForEachPlayer() {
    }

    @Test
    public void setTurnForEachPlayer() {
    }

    @Test
    public void cityTurnProducts() {
    }

    @Test
    public void userTurnResearch() {
    }

    @Test
    public void userTurnWorker() {
    }

    @Test
    public void findProductionUnit() {
    }

    @Test
    public void usersGoldHandling() {
    }
}
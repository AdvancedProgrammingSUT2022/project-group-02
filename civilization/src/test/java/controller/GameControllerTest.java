package controller;

import model.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class GameControllerTest {
    @Mock
    User user;

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
    }

    @Test
    public void increaseFood() {
    }

    @Test
    public void increaseFaith() {
    }

    @Test
    public void increaseScience() {
    }

    @Test
    public void increaseCapitalCitizens() {
    }

    @Test
    public void increaseCapitalDefence() {
    }

    @Test
    public void increaseCulture() {
    }

    @Test
    public void decreaseResearchTurnLeft() {
    }

    @Test
    public void findTile() {
    }

    @Test
    public void moveUnit() {
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
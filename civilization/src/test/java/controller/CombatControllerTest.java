package controller;

import model.Terrain;
import model.Tile;
import model.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CombatControllerTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void checkDefenderHill() {
        Terrain Hill = new Terrain("Hill", "purple", 2, 0, 0.25, 0, 2, true);
        Tile tile = new Tile(18, 20, null, Hill, 0, false, null, null, null);
        Assert.assertTrue(true);
    }

    @Test
    public void combatHandler() {
        User attackerUser = Mockito.mock(User.class);
    }

    @Test
    public void remoteCombat() {
    }

    @Test
    public void coldWeaponCombat() {
    }

    @Test
    public void captureCity() {
    }

    @Test
    public void destroyCity() {
    }

    @Test
    public void annexCity() {
    }
}
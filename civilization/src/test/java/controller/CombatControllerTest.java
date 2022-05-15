package controller;

import model.Terrain;
import model.Tile;
import model.Unit;
import model.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CombatControllerTest {

    @Mock
    Tile tile;
    @Mock
    Terrain Hill;
    @Mock
    User attackerUser;
    @Mock
    Tile selectedTileForAttack;
    @Mock
    Tile selectedTileForDefend;
    @Mock
    Unit militaryUnit;

    @Before
    public void setUp() {

    }

    @Test
    public void checkDefenderHill() {
//        Terrain Hill = new Terrain("Hill", "purple", 2, 0, 0.25, 0, 2, true);
//        Tile tile = new Tile(18, 20, null, Hill, 0, false, null, null, null);
        when(tile.getTerrain()).thenReturn(Hill);
        when(Hill.getName()).thenReturn("Hill");

        Assert.assertTrue(true);
    }

    @Test
    public void combatHandler() {
//        User attackerUser = Mockito.mock(User.class);

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
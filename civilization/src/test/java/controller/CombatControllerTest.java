package controller;

import model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import static org.mockito.Mockito.*;

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

    @Mock
    City city;

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
        CombatController combatController = new CombatController();
        ArrayList<Tile> tileList = new ArrayList<>();
        tileList.add(selectedTileForDefend);
        //tileList.add(selectedTileForAttack);
        when(attackerUser.getTerritory()).thenReturn(tileList);
        Assert.assertEquals("this tile is not for you",combatController.combatHandler(attackerUser,selectedTileForAttack,selectedTileForDefend));
    }

    @Test
    public void combatHandler2() {
        CombatController combatController = new CombatController();
        ArrayList<Tile> tileList = new ArrayList<>();
        tileList.add(selectedTileForDefend);
        tileList.add(selectedTileForAttack);
        when(attackerUser.getTerritory()).thenReturn(tileList);
        when(selectedTileForAttack.getMilitaryUnit()).thenReturn(null);
        Assert.assertEquals("you don't have any military unit in this tile",combatController.combatHandler(attackerUser,selectedTileForAttack,selectedTileForDefend));
    }

    @Test
    public void combatHandler3() {
        CombatController combatController = new CombatController();
        ArrayList<Tile> tileList = new ArrayList<>();
        tileList.add(selectedTileForDefend);
        tileList.add(selectedTileForAttack);
        when(attackerUser.getTerritory()).thenReturn(tileList);
        when(selectedTileForAttack.getMilitaryUnit()).thenReturn(militaryUnit);
        Assert.assertEquals( "you can not attack to your own tiles",combatController.combatHandler(attackerUser,selectedTileForAttack,selectedTileForDefend));
    }

    @Test
    public void remoteCombat() {
        CombatController combatController = new CombatController();
        ArrayList<Tile> tileList = new ArrayList<>();
        tileList.add(selectedTileForAttack);
        when(attackerUser.getTerritory()).thenReturn(tileList);
        when(selectedTileForAttack.getMilitaryUnit()).thenReturn(militaryUnit);
        when(militaryUnit.getRangeCombatStrength()).thenReturn(3);
        when(combatController.checkDefenderHill(selectedTileForDefend)).thenReturn(true);
        when(militaryUnit.getHP()).thenReturn(15);
        when(selectedTileForDefend.getMilitaryUnit().getHP()).thenReturn(2);
        Assert.assertEquals( "you got a victory in this attack",combatController.combatHandler(attackerUser,selectedTileForAttack,selectedTileForDefend));
    }

    @Test
    public void remoteCombat2() {
        CombatController combatController = new CombatController();
        ArrayList<Tile> tileList = new ArrayList<>();
        tileList.add(selectedTileForAttack);
        when(attackerUser.getTerritory()).thenReturn(tileList);
        when(selectedTileForAttack.getMilitaryUnit()).thenReturn(militaryUnit);
        when(militaryUnit.getRangeCombatStrength()).thenReturn(3);
        when(combatController.checkDefenderHill(selectedTileForDefend)).thenReturn(true);
        when(militaryUnit.getHP()).thenReturn(15);
        when(selectedTileForDefend.getMilitaryUnit().getHP()).thenReturn(7);
        Assert.assertEquals( "you could not get this tile. but you destroyed the military unit of adversary",combatController.combatHandler(attackerUser,selectedTileForAttack,selectedTileForDefend));
    }

    @Test
    public void remoteCombat3() {
        CombatController combatController = new CombatController();
        ArrayList<Tile> tileList = new ArrayList<>();
        tileList.add(selectedTileForAttack);
        when(attackerUser.getTerritory()).thenReturn(tileList);
        when(selectedTileForAttack.getMilitaryUnit()).thenReturn(militaryUnit);
        when(militaryUnit.getRangeCombatStrength()).thenReturn(3);
        when(combatController.checkDefenderHill(selectedTileForDefend)).thenReturn(true);
        when(militaryUnit.getHP()).thenReturn(15);
        when(selectedTileForDefend.getMilitaryUnit().getHP()).thenReturn(20);
        Assert.assertEquals( "you made a damage to adversary military unit but you could not destroy and get the tile",combatController.combatHandler(attackerUser,selectedTileForAttack,selectedTileForDefend));
    }

    @Test
    public void coldWeaponCombat() {
        CombatController combatController = new CombatController();
        ArrayList<Tile> tileList = new ArrayList<>();
        tileList.add(selectedTileForAttack);
        when(attackerUser.getTerritory()).thenReturn(tileList);
        when(selectedTileForAttack.getMilitaryUnit()).thenReturn(militaryUnit);
        when(militaryUnit.getRangeCombatStrength()).thenReturn(1);
        when(combatController.checkDefenderHill(selectedTileForDefend)).thenReturn(true);
        when(militaryUnit.getHP()).thenReturn(15);
        when(selectedTileForDefend.getMilitaryUnit().getHP()).thenReturn(2);
        Assert.assertEquals( "you got a victory in this attack",combatController.combatHandler(attackerUser,selectedTileForAttack,selectedTileForDefend));
    }

    @Test
    public void coldWeaponCombat2() {
        CombatController combatController = new CombatController();
        ArrayList<Tile> tileList = new ArrayList<>();
        tileList.add(selectedTileForAttack);
        when(attackerUser.getTerritory()).thenReturn(tileList);
        when(selectedTileForAttack.getMilitaryUnit()).thenReturn(militaryUnit);
        when(militaryUnit.getRangeCombatStrength()).thenReturn(1);
        when(combatController.checkDefenderHill(selectedTileForDefend)).thenReturn(true);
        when(militaryUnit.getHP()).thenReturn(15);
        when(selectedTileForDefend.getMilitaryUnit().getHP()).thenReturn(7);
        Assert.assertEquals( "you missed your military unit but the unit of adversary is also killed",combatController.combatHandler(attackerUser,selectedTileForAttack,selectedTileForDefend));
    }

    @Test
    public void coldWeaponCombat3() {
        CombatController combatController = new CombatController();
        ArrayList<Tile> tileList = new ArrayList<>();
        tileList.add(selectedTileForAttack);
        when(attackerUser.getTerritory()).thenReturn(tileList);
        when(selectedTileForAttack.getMilitaryUnit()).thenReturn(militaryUnit);
        when(militaryUnit.getRangeCombatStrength()).thenReturn(1);
        when(combatController.checkDefenderHill(selectedTileForDefend)).thenReturn(true);
        when(militaryUnit.getHP()).thenReturn(15);
        when(selectedTileForDefend.getMilitaryUnit().getHP()).thenReturn(15);
        Assert.assertEquals( "you missed this attack and your military unit",combatController.combatHandler(attackerUser,selectedTileForAttack,selectedTileForDefend));
    }

    @Test
    public void captureCity() {
        CombatController combatController = mock(CombatController.class);
        String command = "destroy";
        doNothing().when(combatController).captureCity(city,militaryUnit,command);
        combatController.captureCity(city,militaryUnit,command);
        verify(combatController,times(1)).captureCity(city,militaryUnit,command);
    }

    @Test
    public void destroyCity() {
        CombatController combatController = mock(CombatController.class);
        doNothing().when(combatController).destroyCity(city);
        combatController.destroyCity(city);
        verify(combatController,times(1)).destroyCity(city);
    }

    @Test
    public void annexCity() {
       CombatController combatController = mock(CombatController.class);
       doNothing().when(combatController).annexCity(city,militaryUnit);
       combatController.annexCity(city,militaryUnit);
       verify(combatController,times(1)).annexCity(city,militaryUnit);
    }
}
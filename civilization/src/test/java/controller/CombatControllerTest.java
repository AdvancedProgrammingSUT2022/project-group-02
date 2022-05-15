package controller;

import model.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CombatControllerTest {

    @Mock
    Tile selectedTileForAttack;

    @Mock
    Unit militaryUnit;

    @Mock
    City city;

    @Test
    public void checkDefenderHill() {
        Terrain Hill = new Terrain("Hill", "purple", 2, 0, 0.25, 0, 2, true);
        Tile tile = new Tile(18, 20, null, Hill, 0, false, null, null, null);
        Assert.assertTrue(true);
    }

    @Test
    public void combatHandler() {
        CombatController combatController = new CombatController();
        ArrayList<Tile> tileList = new ArrayList<>();
        Terrain Hill = new Terrain("Hill", "purple", 2, 0, 0.25, 0, 2, true);
        Tile selectedTileForDefend = new Tile(18, 20, null, Hill, 0, false, null, null, null);
        tileList.add(selectedTileForDefend);
        User attackerUser = new User(" ", " ", " ");
        attackerUser.setTerritory(tileList);
        Assert.assertEquals("this tile is not for you", combatController.combatHandler(attackerUser, selectedTileForAttack, selectedTileForDefend));
    }

    @Test
    public void combatHandler2() {
        CombatController combatController = new CombatController();
        ArrayList<Tile> tileList = new ArrayList<>();
        Terrain Hill = new Terrain("Hill", "purple", 2, 0, 0.25, 0, 2, true);
        Tile selectedTileForDefend = new Tile(18, 20, null, Hill, 0, false, null, null, null);
        Tile selectedTileForAttack = new Tile(18, 20, null, Hill, 0, false, null, null, null);
        tileList.add(selectedTileForDefend);
        tileList.add(selectedTileForAttack);
        User attackerUser = new User(" ", " ", " ");
        attackerUser.setTerritory(tileList);
        selectedTileForAttack.setMilitaryUnit(null);
        Assert.assertEquals("you don't have any military unit in this tile", combatController.combatHandler(attackerUser, selectedTileForAttack, selectedTileForDefend));
    }

    @Test
    public void combatHandler3() {
        CombatController combatController = new CombatController();
        ArrayList<Tile> tileList = new ArrayList<>();
        Terrain Hill = new Terrain("Hill", "purple", 2, 0, 0.25, 0, 2, true);
        Tile selectedTileForDefend = new Tile(18, 20, null, Hill, 0, false, null, null, null);
        Tile selectedTileForAttack = new Tile(18, 20, null, Hill, 0, false, null, null, null);
        User attackerUser = new User(" ", " ", " ");
        attackerUser.setTerritory(tileList);
        selectedTileForAttack.setOwner(attackerUser);
        selectedTileForDefend.setOwner(attackerUser);
        tileList.add(selectedTileForDefend);
        tileList.add(selectedTileForAttack);
        Unit militaryUnit = new MilitaryUnit("settler", selectedTileForAttack, 0, 0, 0, 0, 0, 0, 0, attackerUser, 0, 0);
        selectedTileForAttack.setMilitaryUnit(militaryUnit);
        Assert.assertEquals("you can not attack to your own tiles", combatController.combatHandler(attackerUser, selectedTileForAttack, selectedTileForDefend));
    }

    @Test
    public void remoteCombat() {
        CombatController combatController = new CombatController();
        ArrayList<Tile> tileList = new ArrayList<>();
        Terrain Hill = new Terrain("Hill", "purple", 2, 0, 0.25, 0, 2, true);
        Tile selectedTileForDefend = new Tile(18, 20, null, Hill, 0, false, null, null, null);
        Tile selectedTileForAttack = new Tile(18, 20, null, Hill, 0, false, null, null, null);
        User attackerUser = new User(" ", " ", " ");
        attackerUser.setTerritory(tileList);
        selectedTileForAttack.setOwner(attackerUser);
        Unit militaryUnit = new MilitaryUnit("settler", selectedTileForAttack, 0, 0, 0, 0, 0, 0, 0, attackerUser, 0, 0);
        Unit militaryUnit2 = new MilitaryUnit("settler", selectedTileForDefend, 0, 0, 0, 0, 0, 0, 0, attackerUser, 0, 0);
        selectedTileForAttack.setMilitaryUnit(militaryUnit);
        selectedTileForAttack.setMilitaryUnit(militaryUnit);
        tileList.add(selectedTileForAttack);
        attackerUser.setTerritory(tileList);
        selectedTileForAttack.setMilitaryUnit(militaryUnit);
        militaryUnit.setRangeCombatStrength(4);
        militaryUnit.setHP(15);
        militaryUnit2.setHP(2);
        selectedTileForDefend.setMilitaryUnit(militaryUnit2);
        City city = new City(" ", selectedTileForDefend, attackerUser, tileList, 20, 20, militaryUnit2, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, false, null, 0);
        selectedTileForDefend.setCity(city);
        selectedTileForDefend.setCivilianUnit(militaryUnit2);
        Assert.assertEquals("you got a victory in this attack", combatController.combatHandler(attackerUser, selectedTileForAttack, selectedTileForDefend));
    }

    @Test
    public void remoteCombat2() {
        CombatController combatController = new CombatController();
        ArrayList<Tile> tileList = new ArrayList<>();
        Terrain Hill = new Terrain("Hill", "purple", 2, 0, 0.25, 0, 2, true);
        Tile selectedTileForDefend = new Tile(18, 20, null, Hill, 0, false, null, null, null);
        Tile selectedTileForAttack = new Tile(18, 20, null, Hill, 0, false, null, null, null);
        User attackerUser = new User(" ", " ", " ");
        attackerUser.setTerritory(tileList);
        selectedTileForAttack.setOwner(attackerUser);
        Unit militaryUnit = new MilitaryUnit("settler", selectedTileForAttack, 0, 0, 0, 0, 0, 0, 0, attackerUser, 0, 0);
        Unit militaryUnit2 = new MilitaryUnit("settler", selectedTileForDefend, 0, 0, 0, 0, 0, 0, 0, attackerUser, 0, 0);
        selectedTileForAttack.setMilitaryUnit(militaryUnit);
        selectedTileForAttack.setMilitaryUnit(militaryUnit);
        tileList.add(selectedTileForAttack);
        attackerUser.setTerritory(tileList);
        selectedTileForAttack.setMilitaryUnit(militaryUnit);
        militaryUnit.setRangeCombatStrength(4);
        militaryUnit.setHP(15);
        militaryUnit2.setHP(7);
        selectedTileForDefend.setMilitaryUnit(militaryUnit2);
        City city = new City(" ", selectedTileForDefend, attackerUser, tileList, 20, 20, militaryUnit2, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, false, null, 0);
        selectedTileForDefend.setCity(city);
        selectedTileForDefend.setCivilianUnit(militaryUnit2);
        Assert.assertEquals("you could not get this tile. but you destroyed the military unit of adversary", combatController.combatHandler(attackerUser, selectedTileForAttack, selectedTileForDefend));
    }

    @Test
    public void remoteCombat3() {
        CombatController combatController = new CombatController();
        ArrayList<Tile> tileList = new ArrayList<>();
        Terrain Hill = new Terrain("Hill", "purple", 2, 0, 0.25, 0, 2, true);
        Tile selectedTileForDefend = new Tile(18, 20, null, Hill, 0, false, null, null, null);
        Tile selectedTileForAttack = new Tile(18, 20, null, Hill, 0, false, null, null, null);
        User attackerUser = new User(" ", " ", " ");
        attackerUser.setTerritory(tileList);
        selectedTileForAttack.setOwner(attackerUser);
        Unit militaryUnit = new MilitaryUnit("settler", selectedTileForAttack, 0, 0, 0, 0, 0, 0, 0, attackerUser, 0, 0);
        Unit militaryUnit2 = new MilitaryUnit("settler", selectedTileForDefend, 0, 0, 0, 0, 0, 0, 0, attackerUser, 0, 0);
        selectedTileForAttack.setMilitaryUnit(militaryUnit);
        selectedTileForAttack.setMilitaryUnit(militaryUnit);
        tileList.add(selectedTileForAttack);
        attackerUser.setTerritory(tileList);
        selectedTileForAttack.setMilitaryUnit(militaryUnit);
        militaryUnit.setRangeCombatStrength(4);
        militaryUnit.setHP(15);
        militaryUnit2.setHP(20);
        selectedTileForDefend.setMilitaryUnit(militaryUnit2);
        City city = new City(" ", selectedTileForDefend, attackerUser, tileList, 20, 20, militaryUnit2, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, false, null, 0);
        selectedTileForDefend.setCity(city);
        selectedTileForDefend.setCivilianUnit(militaryUnit2);
        Assert.assertEquals("you made a damage to adversary military unit but you could not destroy and get the tile", combatController.combatHandler(attackerUser, selectedTileForAttack, selectedTileForDefend));
    }

    @Test
    public void coldWeaponCombat() {
        CombatController combatController = new CombatController();
        ArrayList<Tile> tileList = new ArrayList<>();
        Terrain Hill = new Terrain("Hill", "purple", 2, 0, 0.25, 0, 2, true);
        Tile selectedTileForDefend = new Tile(18, 20, null, Hill, 0, false, null, null, null);
        Tile selectedTileForAttack = new Tile(18, 20, null, Hill, 0, false, null, null, null);
        User attackerUser = new User(" ", " ", " ");
        attackerUser.setTerritory(tileList);
        selectedTileForAttack.setOwner(attackerUser);
        Unit militaryUnit = new MilitaryUnit("settler", selectedTileForAttack, 0, 0, 0, 0, 0, 0, 0, attackerUser, 0, 0);
        Unit militaryUnit2 = new MilitaryUnit("settler", selectedTileForDefend, 0, 0, 0, 0, 0, 0, 0, attackerUser, 0, 0);
        selectedTileForAttack.setMilitaryUnit(militaryUnit);
        selectedTileForAttack.setMilitaryUnit(militaryUnit);
        tileList.add(selectedTileForAttack);
        attackerUser.setTerritory(tileList);
        selectedTileForAttack.setMilitaryUnit(militaryUnit);
        militaryUnit.setRangeCombatStrength(1);
        militaryUnit.setHP(15);
        militaryUnit2.setHP(2);
        selectedTileForDefend.setMilitaryUnit(militaryUnit2);
        City city = new City(" ", selectedTileForDefend, attackerUser, tileList, 20, 20, militaryUnit2, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, false, null, 0);
        selectedTileForDefend.setCity(city);
        selectedTileForDefend.setCivilianUnit(militaryUnit2);
        Assert.assertEquals("you got a victory in this attack", combatController.combatHandler(attackerUser, selectedTileForAttack, selectedTileForDefend));
    }

    @Test
    public void coldWeaponCombat2() {
        CombatController combatController = new CombatController();
        ArrayList<Tile> tileList = new ArrayList<>();
        Terrain Hill = new Terrain("Hill", "purple", 2, 0, 0.25, 0, 2, true);
        Tile selectedTileForDefend = new Tile(18, 20, null, Hill, 0, false, null, null, null);
        Tile selectedTileForAttack = new Tile(18, 20, null, Hill, 0, false, null, null, null);
        User attackerUser = new User(" ", " ", " ");
        attackerUser.setTerritory(tileList);
        selectedTileForAttack.setOwner(attackerUser);
        Unit militaryUnit = new MilitaryUnit("settler", selectedTileForAttack, 0, 0, 0, 0, 0, 0, 0, attackerUser, 0, 0);
        Unit militaryUnit2 = new MilitaryUnit("settler", selectedTileForDefend, 0, 0, 0, 0, 0, 0, 0, attackerUser, 0, 0);
        selectedTileForAttack.setMilitaryUnit(militaryUnit);
        selectedTileForAttack.setMilitaryUnit(militaryUnit);
        tileList.add(selectedTileForAttack);
        attackerUser.setTerritory(tileList);
        selectedTileForAttack.setMilitaryUnit(militaryUnit);
        militaryUnit.setRangeCombatStrength(1);
        militaryUnit.setHP(15);
        militaryUnit2.setHP(7);
        selectedTileForDefend.setMilitaryUnit(militaryUnit2);
        City city = new City(" ", selectedTileForDefend, attackerUser, tileList, 20, 20, militaryUnit2, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, false, null, 0);
        selectedTileForDefend.setCity(city);
        selectedTileForDefend.setCivilianUnit(militaryUnit2);
        Assert.assertEquals("you missed your military unit but the unit of adversary is also killed", combatController.combatHandler(attackerUser, selectedTileForAttack, selectedTileForDefend));
    }

    @Test
    public void coldWeaponCombat3() {
        CombatController combatController = new CombatController();
        ArrayList<Tile> tileList = new ArrayList<>();
        Terrain Hill = new Terrain("Hill", "purple", 2, 0, 0.25, 0, 2, true);
        Tile selectedTileForDefend = new Tile(18, 20, null, Hill, 0, false, null, null, null);
        Tile selectedTileForAttack = new Tile(18, 20, null, Hill, 0, false, null, null, null);
        User attackerUser = new User(" ", " ", " ");
        attackerUser.setTerritory(tileList);
        selectedTileForAttack.setOwner(attackerUser);
        Unit militaryUnit = new MilitaryUnit("settler", selectedTileForAttack, 0, 0, 0, 0, 0, 0, 0, attackerUser, 0, 0);
        Unit militaryUnit2 = new MilitaryUnit("settler", selectedTileForDefend, 0, 0, 0, 0, 0, 0, 0, attackerUser, 0, 0);
        selectedTileForAttack.setMilitaryUnit(militaryUnit);
        selectedTileForAttack.setMilitaryUnit(militaryUnit);
        tileList.add(selectedTileForAttack);
        attackerUser.setTerritory(tileList);
        selectedTileForAttack.setMilitaryUnit(militaryUnit);
        militaryUnit.setRangeCombatStrength(1);
        militaryUnit.setHP(15);
        militaryUnit2.setHP(20);
        selectedTileForDefend.setMilitaryUnit(militaryUnit2);
        City city = new City(" ", selectedTileForDefend, attackerUser, tileList, 20, 20, militaryUnit2, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, false, null, 0);
        selectedTileForDefend.setCity(city);
        selectedTileForDefend.setCivilianUnit(militaryUnit2);
        Assert.assertEquals("you missed this attack and your military unit", combatController.combatHandler(attackerUser, selectedTileForAttack, selectedTileForDefend));
    }

    @Test
    public void captureCity() {
        CombatController combatController = mock(CombatController.class);
        String command = "destroy";
        doNothing().when(combatController).captureCity(city, militaryUnit, command);
        combatController.captureCity(city, militaryUnit, command);
        verify(combatController, times(1)).captureCity(city, militaryUnit, command);
    }

    @Test
    public void destroyCity() {
        CombatController combatController = mock(CombatController.class);
        doNothing().when(combatController).destroyCity(city);
        combatController.destroyCity(city);
        verify(combatController, times(1)).destroyCity(city);
    }

    @Test
    public void annexCity() {
        CombatController combatController = mock(CombatController.class);
        doNothing().when(combatController).annexCity(city, militaryUnit);
        combatController.annexCity(city, militaryUnit);
        verify(combatController, times(1)).annexCity(city, militaryUnit);
    }
}
package controller;

import model.*;

import java.util.ArrayList;

public class CombatController extends UnitController {

    public CombatController() {
        super();
    }

    private static CombatController combatController;

    public static CombatController getInstance() {
        if (combatController == null)
            combatController = new CombatController();
        return combatController;
    }

    //combat handling : first version of code

    public void destroyCity(City city) {
        User previous = city.getOwner();
        previous.removeCity(city);
        for (Tile ownerShipTile : city.getOwnerShipTiles()) {
            ownerShipTile.setOwner(null);
            ownerShipTile.setCity(null);
            previous.removeTerritory(ownerShipTile);
        }
        city = null;
    }

    public void annexCity(City city, Unit unit) {
        User previous = city.getOwner();

        previous.removeCity(city);
        city.setOwner(unit.getOwner());
        for (Tile ownerShipTile : city.getOwnerShipTiles()) {
            ownerShipTile.setOwner(unit.getOwner());
            unit.getOwner().addTerritory(ownerShipTile);
            previous.removeTerritory(ownerShipTile);
        }
        unit.getOwner().addCity(city);
    }

    public void attackCity(City city, Unit unit) {
        if (city.getTile() != null && city.getTile().getTerrain().getName().equals("Hill")) {
            city.setHP(city.getHP() - (unit.getAttackPoint() / 2));
        }
        else {
            city.setHP(city.getHP() - unit.getAttackPoint());
        }
    }

    public void attackUnit(Unit first, Unit second) {
        second.setHP(second.getHP() - first.getAttackPoint());
        if (second.getHP() <= 0) {
            Tile tile = second.getTile();
            second.getOwner().removeUnit(second);
            tile.setMilitaryUnit(null);
            tile.setMilitaryUnitExists(false);
            moveWinnerUnitToDestination(first, tile);
        }
    }

    private void moveWinnerUnitToDestination(Unit unit, Tile destination) {
        Tile origin = unit.getTile();
        origin.setMilitaryUnitExists(false);
        origin.setMilitaryUnit(null);
        destination.setMilitaryUnitExists(true);
        destination.setMilitaryUnit(unit);
        unit.setTile(destination);
    }

    public void annexCivilianUnit(User user, Unit unit) {
        unit.setOwner(user);
        user.addUnit(unit);
    }
}

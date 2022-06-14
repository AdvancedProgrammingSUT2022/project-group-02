package controller;

import model.*;

import java.util.ArrayList;

public class CombatController extends UnitController {

    //combat handling : first version of code
    public boolean checkDefenderHill(Tile tile) {
        return tile.getTerrain().getName().equals("Hill");
    }

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
}

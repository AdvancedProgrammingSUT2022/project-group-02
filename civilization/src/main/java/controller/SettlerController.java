package controller;

import model.*;

import java.util.ArrayList;
import java.util.HashMap;

public class SettlerController extends UnitController{
    public void createNewCity(Unit unit, User user, Tile tile) {
        String name = user.getUsername() + Integer.toString(user.getCities().size() + 1);
        ArrayList<Tile> ownerShipTiles = new ArrayList<>();
        ownerShipTiles.add(tile);
        HashMap<Citizen, Tile> citizensLocations = new HashMap<>();
        citizensLocations.put(new Citizen(), tile);
        tile.setCity(new City(name, tile, user, ownerShipTiles, 100, 100, null, null,
                50, 0, 1, 1, 1, 1, 1, 1, 1,
                citizensLocations, null, null, false, null, 20));
        tile.setOwner(user);
        removeUnit(unit, user);
    }
}

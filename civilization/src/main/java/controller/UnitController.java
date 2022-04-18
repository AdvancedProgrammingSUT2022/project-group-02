package controller;
import model.Maps;
import model.Tile;
import model.Unit;
import model.User;

import java.util.ArrayList;

public class UnitController {
    private Maps map;
    private ArrayList<Unit> units;
    public UnitController() {
        map = new Maps();
        units = new ArrayList<>();
    }
    public boolean moving (Unit unit, User user, int x, int y) {
        for (int i = 0; i < map.getTileBoard().length; i++) {
            //if ()
        }
        return false;
    }
    public void createUnit (Unit unit, User user) {
        units.add(unit);
    }
    public void repair (Unit unit, User user) {
        int specificAmount = 1;
        unit.setHP(unit.getHP());
    }
    public void loot (Unit unit, User user) {

    }
    public void removeUnit (Unit unit, User user) {
        units.remove(unit);
    }
}

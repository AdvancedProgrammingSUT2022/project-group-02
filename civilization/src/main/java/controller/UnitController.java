package controller;
import model.Maps;
import model.Tile;
import model.Unit;
import model.User;

import java.util.ArrayList;

public class UnitController {

    private ArrayList<Unit> units;
    public UnitController() {
        units = new ArrayList<>();
    }
    public boolean moving (Unit unit, User user, int x, int y, Maps map) {

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
        user.removeUnit(unit);
        units.remove(unit);
    }
}

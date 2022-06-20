package controller;
import model.*;

import java.util.ArrayList;

public class UnitController {

    private final ArrayList<Unit> units;
    public UnitController() {
        units = new ArrayList<>();
    }
    public void removeUnit (boolean isSettler, Unit unit, User user) {
        if (!isSettler) user.setGold(user.getGold() + unit.getGoldPrice()/5);
        user.removeUnit(unit);
        units.remove(unit);
    }
    public void repairMovementPoint(User user) {
        for (Unit unit : user.getUnits())
            unit.setMP(unit.getLastingMP());
    }
}

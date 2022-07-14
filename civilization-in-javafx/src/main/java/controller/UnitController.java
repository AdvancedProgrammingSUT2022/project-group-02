package controller;
import model.*;

import java.util.ArrayList;

public class UnitController {

    private static UnitController unitController;

    private final ArrayList<Unit> units;

    private UnitController() {
        units = new ArrayList<>();
    }

    public static UnitController getInstance() {
        if (unitController == null)
            unitController = new UnitController();
        return unitController;
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

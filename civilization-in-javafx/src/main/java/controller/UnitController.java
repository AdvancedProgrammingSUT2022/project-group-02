package controller;
import model.*;

import java.util.ArrayList;

public class UnitController {

    private static UnitController unitController;

    UnitController() {
    }

    public static UnitController getInstance() {
        if (unitController == null)
            unitController = new UnitController();
        return unitController;
    }

    public static void removeUnit (Unit unit, User user) {
        user.setGold(user.getGold() + unit.getGoldPrice()/5);
        user.removeUnit(unit);
        unit.getTile().setCivilianUnit(null);
    }

    public void repairMovementPoint(User user) {
        for (Unit unit : user.getUnits())
            unit.setMP(unit.getLastingMP());
    }
}

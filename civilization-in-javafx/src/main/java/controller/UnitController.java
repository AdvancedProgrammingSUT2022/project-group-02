package controller;
import model.*;

import java.util.ArrayList;

public class UnitController {

    private static UnitController unitController;

<<<<<<< HEAD
    private final ArrayList<Unit> units = new ArrayList<>();
=======
    private final ArrayList<Unit> units;

    UnitController() {
        units = new ArrayList<>();
    }
>>>>>>> 7f916ad60376acb11edd507b8f9e5a5d3048a0c1

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

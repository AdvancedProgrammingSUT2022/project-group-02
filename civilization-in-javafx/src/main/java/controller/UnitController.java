package controller;
import model.*;

import java.util.ArrayList;

public class UnitController {

    private final ArrayList<Unit> units;
    public UnitController() {
        units = new ArrayList<>();
    }
    public void createUnit (Unit unit) {
        units.add(unit);
    }
    public void repair (Unit unit) {
        unit.setHP(unit.getHP() + 4);
    }
    public void removeUnit (boolean isSettler, Unit unit, User user) {
        if (!isSettler) user.setGold(user.getGold() + unit.getGoldPrice()/5);
        user.removeUnit(unit);
        units.remove(unit);
    }
    public boolean workingWorker(Worker worker){
        return !worker.getWorkingStatus();
    }
    public boolean MPCheckerForImprovement(Unit unit){
        return unit.getMP() > 0;
    }
    public boolean isForestExistOnTile(Tile tile){
        return tile.getFeature().getName().equals("Forest");
    }
    public boolean isJungleExistOnTile(Tile tile){
        return tile.getFeature().getName().equals("Jungle");
    }
    public boolean isMarshExistOnTile(Tile tile){
        return tile.getFeature().getName().equals("Marsh");
    }
    public void repairMovementPoint(User user) {
        for (Unit unit : user.getUnits())
            unit.setMP(unit.getLastingMP());
    }
    public ArrayList<Unit> getUnits() {
        return units;
    }
}

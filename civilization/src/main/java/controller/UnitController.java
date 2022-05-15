package controller;
import controller.enums.Colors;
import model.*;

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
    public boolean workingWorker(Worker worker){
        String fontColor = Colors.RED;
        if (worker.getWorkingStatus()) {
            System.out.println(fontColor + "The selected worker is working now!");
            return false;
        } else return true;
    }
    public boolean MPCheckerForImprovement(Unit unit){
        String fontColor = Colors.RED;
        if (unit.getMP() <= 0) {
            System.out.println(fontColor + "Unit MP is not enough for it in this turn!" + Colors.RESET);
            fontColor = Colors.BLUE;
            System.out.println(fontColor + "do you want to do this action in the upcoming turns?" + Colors.RESET);
            //(Audience : anyone)TODO :  complete if user type "yes"
            return false;
        } else return true;
    }
    public boolean isForestExistOnTile(Tile tile){
        String fontColor = Colors.RED;
        if (!tile.getFeature().getName().equals("Forest")) {
            System.out.println(fontColor + "There is no Forest feature in this tile" + Colors.RESET);
            return false;
        } else return true;
    }
    public boolean isJungleExistOnTile(Tile tile){
        String fontColor = Colors.RED;
        if (!tile.getFeature().getName().equals("Jungle")) {
            System.out.println(fontColor + "There is no Jungle feature in this tile" + Colors.RESET);
            return false;
        } else return true;
    }
    public boolean isMarshExistOnTile(Tile tile){
        String fontColor = Colors.RED;
        if (!tile.getFeature().getName().equals("Marsh")) {
            System.out.println(fontColor + "There is no Marsh feature in this tile" + Colors.RESET);
            return false;
        } else return true;
    }

    public void repairMovementPoint(User user) {
        for (Unit unit : user.getUnits())
            unit.setMP(unit.getLastingMP());
    }
}

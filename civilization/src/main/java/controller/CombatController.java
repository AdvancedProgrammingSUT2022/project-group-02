package controller;

import model.Maps;
import model.Unit;
import model.User;

public class CombatController extends UnitController{

    public boolean setCellForAttacking(int x, int y, Unit unit, User user, Maps map) {
        return false;
    }
    public void AttackToChosenCell(int x, int y, Unit unit, User user, Maps map) {

    }
    private void shortRangeAttack(int x, int y, Unit unit, User user, Maps map) {

    }
    private void longRangeAttack(int x, int y, Unit unit, User user, Maps map) {

    }
    public boolean attackerHPCheck(Unit unit) {
        return unit.getHP() > 0;
    }
    public boolean defenderHPCheck(Unit unit) {
        return unit.getHP() > 0;
    }
}

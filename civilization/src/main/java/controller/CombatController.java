package controller;

import enums.Colors;
import model.*;

public class CombatController extends UnitController{

    //TODO : every city has a combat strength and a HP and a attacking point

    public void MeleeAttack(MilitaryUnit militaryUnit, User user){
        militaryUnit.setHP(militaryUnit.getHP() - militaryUnit.getAttackingTarget().getAttackPoint());
        if (attackerHPCheck(militaryUnit)){
            militaryUnit.getAttackingTarget().setHP(militaryUnit.getAttackingTarget().getHP() - militaryUnit.getAttackPoint());
            if (!defenderHPCheck(militaryUnit.getAttackingTarget())) attackerWinHandler(militaryUnit, user);
        } else {
            user.removeUnit(militaryUnit);
            militaryUnit.getTile().setMilitaryUnit(null);
        }
    }

    public void attackerWinHandler(MilitaryUnit militaryUnit, User user){
        if (!militaryUnit.getAttackingTarget().isCity()){
            militaryUnit.getAttackingTarget().getOwner().removeUnit(militaryUnit.getAttackingTarget());
            militaryUnit.getAttackingTarget().getTile().setMilitaryUnit(null);
        } else {
            //(Audience : mohammad)|(Time : next phase)
            // TODO : we have 3 choice so print them and get user input and do the consequence of that choice
        }
    }

    public boolean attackerHPCheck(PhysicalObject physicalObject) {
        return physicalObject.getHP() > 0;
    }
    public boolean defenderHPCheck(PhysicalObject physicalObject) {
        return physicalObject.getHP() > 0;
    }
}

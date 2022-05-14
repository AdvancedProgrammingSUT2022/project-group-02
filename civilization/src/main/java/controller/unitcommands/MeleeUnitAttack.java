package controller.unitcommands;

import controller.CombatController;
import model.MilitaryUnit;
import model.Tile;
import model.UnitCommand;
import model.User;

public abstract class MeleeUnitAttack implements UnitCommand {

    @Override
    public void doMilitaryAction(MilitaryUnit militaryUnit, Tile tile, User user){
        //(Audience : Shayan)|(Time : next phase)TODO : move unit to the target Tile
        new CombatController().MeleeAttack(militaryUnit, user);
    }

}

package unitcommands;

import model.*;

public abstract class DeleteUnit implements UnitCommand {

    @Override
    public void doUnitAction(Unit unit, Tile tile, User user){
        user.getUnits().remove(unit);
        user.setGold(user.getGold() + unit.getGoldPrice()/2);
        if (unit.getName().equals("Settler") || unit.getName().equals("Worker")){
            unit.getTile().setCivilianUnit(null);
        } else  unit.getTile().setMilitaryUnit(null);
    }

}

package unitcommands;

import model.*;

public abstract class Pillage implements UnitCommand {

    @Override
    public void doMilitaryAction(MilitaryUnit militaryUnit, Tile tile, User user){
        tile.setLooted(true);
        militaryUnit.setMP(0);
    }
}

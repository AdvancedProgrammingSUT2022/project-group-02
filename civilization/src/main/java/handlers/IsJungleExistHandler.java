package handlers;

import enums.Colors;
import model.MilitaryUnit;
import model.Tile;
import model.User;
import model.Worker;

public class IsJungleExistHandler extends Handlers {
    @Override
    public boolean handle(Worker worker, MilitaryUnit militaryUnit, Tile tile, User user){
        String fontColor = Colors.RED;
        if (!tile.getFeature().getName().equals("jungle")) {
            System.out.println(fontColor + "There is no jungle feature in this tile" + Colors.RESET);
            return false;
        } else {
            if (nextHandler != null) return nextHandler.handle(worker, militaryUnit, tile, user);
            else return true;
        }
    }
}

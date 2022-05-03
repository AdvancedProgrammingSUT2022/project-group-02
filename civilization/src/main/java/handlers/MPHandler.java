package handlers;

import enums.Colors;
import model.MilitaryUnit;
import model.Tile;
import model.User;
import model.Worker;

public class MPHandler extends Handlers {
    @Override
    public boolean handle(Worker worker, MilitaryUnit militaryUnit, Tile tile, User user){
        String fontColor = Colors.RED;
        if ((worker != null && worker.getMP() == 0) || (militaryUnit != null && militaryUnit.getMP() == 0)) {
            System.out.println(fontColor + "Unit MP is not enough for it in this turn!" + Colors.RESET);
            fontColor = Colors.BLUE;
            System.out.println(fontColor + "do you want to do this action in the upcoming turns?" + Colors.RESET);
            //(Audience : anyone)TODO :  complete if user type "yes"
            return false;
        } else {
            if (nextHandler != null) return nextHandler.handle(worker, militaryUnit, tile, user);
            else return true;
        }
    }
}

package handlers;

import enums.Colors;
import model.*;

public class WorkerWorkingHandler extends Handlers{

    @Override
    public boolean handle(Worker worker, MilitaryUnit militaryUnit, Tile tile, User user){
        String fontColor = Colors.RED;
        if (worker.getWorkingStatus()) {
            System.out.println(fontColor + "The selected worker is working now!");
            return false;
        } else {
            if (nextHandler != null) return nextHandler.handle(worker, militaryUnit, tile, user);
            else return true;
        }
    }

}

package controller.unitcommands;

import model.Tile;
import model.Worker;

public class RemoveFeature {

    public void removeFeature(Worker worker, Tile tile){
        tile.setFeature(null);
        //remove feature needs 3 turns
        worker.setRemainingTurnsToComplete(3);
        worker.setWorkingStatus(true);
        tile.setInProgress(true);
    }
}

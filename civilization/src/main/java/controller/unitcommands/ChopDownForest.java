package controller.unitcommands;

import controller.UnitController;
import model.Tile;
import model.UnitCommand;
import model.User;
import model.Worker;

public abstract class ChopDownForest extends RemoveFeature implements UnitCommand {

    @Override
    public void doWorkerAction(Worker worker, Tile tile, User user){
        if (new UnitController().workingWorker(worker) && new UnitController().MPCheckerForImprovement(worker) &&
                new UnitController().isForestExistOnTile(tile))
        removeFeature(worker, tile);
    }
}

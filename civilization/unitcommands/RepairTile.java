package controller.unitcommands;

import controller.UnitController;
import model.Tile;
import model.UnitCommand;
import model.User;
import model.Worker;

public abstract class RepairTile implements UnitCommand {

    @Override
    public void doWorkerAction(Worker worker, Tile tile, User user) {
        // TODO : set LootedStatus false after turns completed
        if (new UnitController().workingWorker(worker) && new UnitController().MPCheckerForImprovement(worker) && tile.LootedStatus()){
            worker.setRemainingTurnsToComplete(1);
            worker.setWorkingStatus(true);
            tile.setInProgress(true);
        }
    }

}
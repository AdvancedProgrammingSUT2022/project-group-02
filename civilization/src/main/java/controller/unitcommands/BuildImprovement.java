package controller.unitcommands;

import controller.UnitController;
import model.Tile;
import model.UnitCommand;
import model.User;
import model.Worker;

public abstract class BuildImprovement implements UnitCommand {

    @Override
    public void doWorkerAction(Worker worker, Tile tile, User user) {
        // TODO : set Improvement after turns completed and set Improvement tile too
        if (new UnitController().workingWorker(worker) && new UnitController().MPCheckerForImprovement(worker)){;
            worker.setWorkingStatus(true);
            worker.setRemainingTurnsToComplete(worker.getImprovement().getPrice());
            worker.setBuildingRoad(false);
            tile.setInProgress(true);
        }
    }
}
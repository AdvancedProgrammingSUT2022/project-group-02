package unitcommands;

import controller.UnitController;
import model.Tile;
import model.UnitCommand;
import model.User;
import model.Worker;

public abstract class BuildRoad implements UnitCommand {

    @Override
    public void doWorkerAction(Worker worker, Tile tile, User user) {

        if (new UnitController().workingWorker(worker) && new UnitController().MPCheckerForImprovement(worker)){
            worker.setWorkingStatus(true);
            //required turns To build a road is 3
            worker.setRemainingTurnsToComplete(3);
            worker.setBuildingRoad(true);
            tile.setInProgress(true);
        }
    }
}

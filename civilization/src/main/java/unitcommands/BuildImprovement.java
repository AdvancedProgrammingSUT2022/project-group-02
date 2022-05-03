package unitcommands;

import model.Tile;
import model.UnitCommand;
import model.User;
import model.Worker;

public abstract class BuildImprovement implements UnitCommand {

    @Override
    public void doWorkerAction(Worker worker, Tile tile, User user) {
        worker.getWorkerWorkingHandler().setNextHandler(worker.getMPHandler());
        if (worker.getWorkerWorkingHandler().handle(worker, null, tile, user)){
            worker.setWorkingStatus(true);
            worker.setRemainingTurnsToComplete(worker.getImprovement().getRequiredTurns());
            worker.setBuildingRoad(false);
            tile.setInProgress(true);
        }
        worker.getWorkerWorkingHandler().setNextHandler(null);
    }
}

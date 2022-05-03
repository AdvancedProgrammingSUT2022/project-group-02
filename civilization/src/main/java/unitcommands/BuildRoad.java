package unitcommands;

import model.Tile;
import model.UnitCommand;
import model.User;
import model.Worker;

public abstract class BuildRoad implements UnitCommand {

    @Override
    public void doWorkerAction(Worker worker, Tile tile, User user) {
        worker.getWorkerWorkingHandler().setNextHandler(worker.getMPHandler());
        if (worker.getWorkerWorkingHandler().handle(worker, null, tile, user)){
            worker.setWorkingStatus(true);
            //required turns To build a road is 3
            worker.setRemainingTurnsToComplete(3);
            worker.setBuildingRoad(true);
            tile.setInProgress(true);
        }
        worker.getWorkerWorkingHandler().setNextHandler(null);
    }
}

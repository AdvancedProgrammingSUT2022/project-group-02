package unitcommands;

import model.Tile;
import model.UnitCommand;
import model.User;
import model.Worker;

public abstract class RemoveRoad implements UnitCommand {

    @Override

    public void doWorkerAction(Worker worker, Tile tile, User user){
        /*worker.getWorkerWorkingHandler().setNextHandler(worker.getMPHandler());
        if (worker.getWorkerWorkingHandler().handle(worker, null, tile, user)) {
            tile.setRoad(false);
            worker.setMP(0);
        }
        worker.getWorkerWorkingHandler().setNextHandler(null);*/
    }
}

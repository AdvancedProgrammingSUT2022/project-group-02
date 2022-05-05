package unitcommands;

import model.Tile;
import model.UnitCommand;
import model.User;
import model.Worker;

public abstract class ChopDownForest extends RemoveFeature implements UnitCommand {

    @Override
    public void doWorkerAction(Worker worker, Tile tile, User user){
        //worker.getWorkerWorkingHandler().setNextHandler(worker.getMPHandler());
        //worker.getMPHandler().setNextHandler(new IsForestExistHandler());
        removeFeature(worker, tile, user);
    }
}

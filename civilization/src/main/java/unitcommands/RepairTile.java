package unitcommands;

import model.Tile;
import model.UnitCommand;
import model.User;
import model.Worker;

public abstract class RepairTile implements UnitCommand {

    @Override
    public void doWorkerAction(Worker worker, Tile tile, User user) {
        //(Audience : Amir)TODO : repair a damaged Tile
        //problem : what is a damage tile and how a tile get damage?
    }

}
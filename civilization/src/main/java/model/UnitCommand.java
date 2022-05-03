package model;

public interface UnitCommand {
    //The listener interface for MilitaryUnits
    void doMilitaryAction(MilitaryUnit militaryUnit, Tile tile, User user);
    //The listener interface for WorkerUnits
    void doWorkerAction(Worker worker, Tile tile, User user);
    //The listener interface for SettlerUnits
    void doSettlerAction(Settler settler, Tile tile, User user);
    //The listener interface fo allUnits
    void doUnitAction(Unit unit, Tile tile, User user);
}

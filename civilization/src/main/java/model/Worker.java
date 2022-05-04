package model;

import handlers.Handlers;
import handlers.WorkerWorkingHandler;

public class Worker extends Civilian{

    Handlers workerWorkingHandler = new WorkerWorkingHandler();
    private Improvement improvement;
    private boolean buildingRoad;
    private boolean workingStatus;
    private int remainingTurnsToComplete;

    public Worker(String name, Tile tile, int HP, int price, int level, int MP, int combatStrength, int rangeCombatStrength, boolean working, User user, int attackPoint) {
        super(name, tile, HP, price, level, MP, combatStrength, rangeCombatStrength, user, attackPoint);
    }

    public Improvement getImprovement() {
        return improvement;
    }

    public void setImprovement(Improvement improvement) {
        this.improvement = improvement;
    }

    public boolean getWorkingStatus() {
        return workingStatus;
    }

    public void setWorkingStatus(boolean workingStatus) {
        this.workingStatus = workingStatus;
    }

    public int getRemainingTurnsToComplete() {
        return remainingTurnsToComplete;
    }

    public void setRemainingTurnsToComplete(int remainingTurnsToComplete) {
        this.remainingTurnsToComplete = remainingTurnsToComplete;
    }

    public boolean isBuildingRoad() {
        return buildingRoad;
    }

    public void setBuildingRoad(boolean buildingRoad) {
        this.buildingRoad = buildingRoad;
    }

    public Handlers getWorkerWorkingHandler() {
        return workerWorkingHandler;
    }
}

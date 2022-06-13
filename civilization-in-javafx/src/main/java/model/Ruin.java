package model;

import java.util.ArrayList;

public class Ruin {
    private final ArrayList<Technology> givenTechnologies;
    private final ArrayList<Tile> removedFogs;
    private final boolean addToPopulation;
    private final int gold;
    private final boolean worker;
    private final boolean settler;

    public Ruin(ArrayList<Technology> givenTechnologies, ArrayList<Tile> removedFogs, boolean addToPopulation, int gold, boolean worker, boolean settler) {
        this.givenTechnologies = givenTechnologies;
        this.removedFogs = removedFogs;
        this.addToPopulation = addToPopulation;
        this.gold = gold;
        this.worker = worker;
        this.settler = settler;
    }

    public int getGold() {
        return gold;
    }

    public ArrayList<Technology> getGivenTechnologies() {
        return givenTechnologies;
    }

    public ArrayList<Tile> getRemovedFogs() {
        return removedFogs;
    }

    public boolean isAddToPopulation() {
        return addToPopulation;
    }

    public boolean isSettler() {
        return settler;
    }

    public boolean isWorker() {
        return worker;
    }
}

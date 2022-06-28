package model;

import java.util.ArrayList;

public class Technology {
    private final String name;
    private final ArrayList<Improvement> givenImprovement;
    private final ArrayList<Unit> givenUnits;
    private final ArrayList<Building> givenBuildings;
    private final int index;
    private int sciencePrice;
    public Technology(String name, ArrayList<Improvement> givenImprovement, int index, int sciencePrice, ArrayList<Unit> givenUnits, ArrayList<Building> givenBuildings) {
        this.name = name;
        this.givenImprovement = givenImprovement;
        this.index = index;
        this.sciencePrice = sciencePrice;
        this.givenUnits = givenUnits;
        this.givenBuildings = givenBuildings;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Improvement> getGivenImprovement() {
        return givenImprovement;
    }

    public int getIndex() {
        return index;
    }

    public int getSciencePrice() {
        return sciencePrice;
    }

    public void setSciencePrice(int sciencePrice) {
        this.sciencePrice = sciencePrice;
    }

    public ArrayList<Unit> getGivenUnits() {
        return givenUnits;
    }

    public ArrayList<Building> getGivenBuildings() {
        return givenBuildings;
    }
}

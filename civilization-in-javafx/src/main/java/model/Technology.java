package model;

import java.util.ArrayList;

public class Technology {
    private final String name;
    private final ArrayList<Improvement> givenImprovement;
    private final ArrayList<Unit> givenUnits;
    private final int index;
    private int sciencePrice;
    public Technology(String name, ArrayList<Improvement> givenImprovement, int index, int sciencePrice, ArrayList<Unit> givenUnits) {
        this.name = name;
        this.givenImprovement = givenImprovement;
        this.index = index;
        this.sciencePrice = sciencePrice;
        this.givenUnits = givenUnits;
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

}

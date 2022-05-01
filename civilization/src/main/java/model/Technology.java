package model;

import java.util.ArrayList;

public class Technology {
    private final String name;
    private final ArrayList<Improvement> givenImprovement;
    private final int index;
    public Technology(String name, ArrayList<Improvement> givenImprovement, int index) {
        this.name = name;
        this.givenImprovement = givenImprovement;
        this.index = index;
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
}

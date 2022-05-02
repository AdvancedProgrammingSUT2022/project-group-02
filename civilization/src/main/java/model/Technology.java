package model;

import java.util.ArrayList;

public class Technology {
    private final String name;
    private final ArrayList<Improvement> givenImprovement;
    private final int index;
    private int price;
    public Technology(String name, ArrayList<Improvement> givenImprovement, int index, int price) {
        this.name = name;
        this.givenImprovement = givenImprovement;
        this.index = index;
        this.price = price;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

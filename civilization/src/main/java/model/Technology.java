package model;

import java.util.ArrayList;

public class Technology {
    private final String name;
    private final ArrayList<Product> givenProducts;
    private final int index;
    public Technology(String name, ArrayList<Product> givenProducts, int index) {
        this.name = name;
        this.givenProducts = givenProducts;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Product> getGivenProducts() {
        return givenProducts;
    }

    public int getIndex() {
        return index;
    }
}

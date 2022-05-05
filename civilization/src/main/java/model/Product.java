package model;
import java.util.*;
public class Product {
    private int turnCost;
    private int processing;
    private final String name;
    public Product(String name, int turnCost) {
        this.name = name;
        this.turnCost = turnCost;
        processing = 0;
    }

    public String getName() {
        return name;
    }

    public int getProcessing() {
        return processing;
    }

    public int getTurnCost() {
        return turnCost;
    }

    public void setProcessing(int processing) {
        this.processing = processing;
    }

    public void setTurnCost(int turnCost) {
        this.turnCost = turnCost;
    }
}
